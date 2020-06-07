
package org.onebeartoe.web.enabled.pixel.controllers;

import ioio.lib.api.exception.ConnectionLostException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.onebeartoe.pixel.LogMe;
import org.onebeartoe.pixel.hardware.Pixel;
import org.onebeartoe.web.enabled.pixel.CliPixel;
import org.onebeartoe.web.enabled.pixel.WebEnabledPixel;

/**
 * @author Roberto Marquez
 */
public class StillImageHttpHandler extends ImageResourceHttpHandler
{
    public StillImageHttpHandler(WebEnabledPixel application)
    {
        super(application);
        
        basePath = "alu/";
        defaultImageClassPath = basePath + "tron.png";
        modeName = "still";
    }
    
    @Override
    protected void writeImageResource(String imageClassPath) throws IOException, ConnectionLostException
    {
        //ImageClassPath is for example /images/1941.png
        
        LogMe logMe = LogMe.getInstance();
        
         if (!CliPixel.getSilentMode()) {
            System.out.println("loading new classpath URL for still: " + imageClassPath);
            logMe.aLogger.info("loading new classpath URL for still: " + imageClassPath);
        }
         
        URL url = getClass().getClassLoader().getResource(imageClassPath);
        
        if (!CliPixel.getSilentMode()) {
            System.out.println("URL for " + modeName + " loaded");
            logMe.aLogger.info("URL for " + modeName + " loaded");
        }
        
        String path = "";
        boolean saveAnimation = false;  //TO DO: get the save working here
        BufferedImage image;
        String arcadeName = FilenameUtils.getName(imageClassPath); //get the name only WITH extension
        String ext = FilenameUtils.getExtension(imageClassPath); //get the extension, we want to know if PNG or GIF 
      
        //path = application.getPixel().getPixelHome() + "images/" + arcadeName; //to do need to regression test this
        path = application.getPixel().getPixelHome() + "alu/" + arcadeName; //to do need to regression test this
        File targetFilePath = new File(path);
        url = targetFilePath.toURI().toURL();
        
        if( imageClassPath.contains("/save/"))  saveAnimation = true;
          
        //now let's find out if PNG or GIF
        
//        System.out.println("arcadeNameOnly: " + arcadeName);
//        System.out.println("ext: " + ext);
//        System.out.println("path to file: " + path);
        
        if (ext.equals("gif")) {
            
            try {
               
                if (!CliPixel.getSilentMode()) {
                    System.out.println("Arcade Marquee Handler sending GIF: " + path);
                    logMe.aLogger.info("Arcade Marquee Handler sending GIF: " + path);
                }

                Pixel pixel = application.getPixel();
                
                pixel.writeArcadeAnimation("alu",arcadeName,saveAnimation,0, WebEnabledPixel.pixelConnected); //since this class handles pngs and gifs that are served up, we won't have a loop here so pass 0
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(StillImageHttpHandler.class.getName()).log(Level.SEVERE, null, ex);
                 }
        } 
        else if (ext.equals("png")) {
            
            Pixel pixel = application.getPixel();
            pixel.writeArcadeImage(targetFilePath, saveAnimation, 0,"","",WebEnabledPixel.pixelConnected); //since this class handles pngs and gifs that are served up, we won't have a loop and won't need the console and png names
            
           
        } 
        else {
            
            System.out.println("**** ERROR **** Sorry only PNG and GIF are supported, cannot handle " + path);
            logMe.aLogger.severe("Sorry only PNG and GIF are supported, cannot handle " + path);
        }
    }        
}
