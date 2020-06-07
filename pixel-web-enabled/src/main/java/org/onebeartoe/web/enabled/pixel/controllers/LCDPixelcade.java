package org.onebeartoe.web.enabled.pixel.controllers;

import java.io.File;
import java.io.IOException;
import org.onebeartoe.web.enabled.pixel.WebEnabledPixel;

public class LCDPixelcade {

    private static String DEFAULT_COMMAND = "sudo fbi lcdmarquees/pixelcade.png -T 1  --noverbose --nocomments --fixwidth -a";
    private static final String JPG_COMMAND = "sudo fbi lcdmarquees/${named}.jpg -T 1 --noverbose --nocomments --fixwidth -a";
    private static final String PNG_COMMAND = "sudo fbi lcdmarquees/${named}.png -T 1 --noverbose --nocomments --fixwidth -a";
    private static final String SLIDESHOW = "sudo fbi lcdmarquees/* -T 1 -t 2 --noverbose --nocomments --fixwidth -a";
    private static final String RESET_COMMAND = "sudo killall -9 fbi;";
    private static final String MARQUEE_PATH = "lcdmarquees/";
    private static final String ENGINE_PATH = "lcdmarquees/";
    public static String theCommand = DEFAULT_COMMAND;
    public static void main(String[] args) {

        String shell = "bash";
        
        boolean haveFBI = new File(ENGINE_PATH).exists();

        if (!haveFBI && WebEnabledPixel.isUnix()) {
            System.out.print("Image engine failure.\n");
        }
        if (args.length > -1) {
            try {

                if(args.length == 1)
                displayImage(args[args.length - 1]);
                else
                    displayImage(args[0],args[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                displayImage(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void displayImage(String named, String system) throws IOException {

         if (new File(String.format("lcdmarquees/console/default-%s.png", system)).exists())
            DEFAULT_COMMAND = "sudo fbi lcdmarquees/console/default-" + system + ".png -T 1  --noverbose --nocomments --fixwidth -a";

        theCommand = DEFAULT_COMMAND;
        displayImage(named);
    }

    static public void  displayImage(String named) throws IOException {  //note this is Pi/linux only!
        if (named == null) return;
        
        if (named != null) if (named.contains("slideshow")) {
            theCommand = SLIDESHOW;
        } else if (new File(MARQUEE_PATH + named + ".png").exists()) {
            theCommand = PNG_COMMAND.replace("${named}", named);
        } else if (new File(MARQUEE_PATH + named + ".jpg").exists())
            theCommand = JPG_COMMAND.replace("${named}", named);

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", RESET_COMMAND + theCommand);

        Process process = builder.start();
        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert exitCode == 0;
    }
}
