
package org.onebeartoe.web.enabled.pixel.controllers;

import ioio.lib.api.exception.ConnectionLostException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.onebeartoe.pixel.hardware.Pixel;
import org.onebeartoe.web.enabled.pixel.WebEnabledPixel;
import org.onebeartoe.pixel.LogMe;
import org.onebeartoe.web.enabled.pixel.CliPixel;

/**
 * @author Roberto Marquez
 */
public class LocalModeHttpHandler extends ImageResourceHttpHandler
{
    public LocalModeHttpHandler(WebEnabledPixel application)
    {
        super(application);
        
        basePath = "";
        defaultImageClassPath = "tron.png"; //to do change this
        modeName = "arcade"; //to do change this to localplayback and fix
      
    }
    
    @Override
    protected void writeImageResource(String urlParams) throws IOException, ConnectionLostException
    { 
       
        Pixel pixel = application.getPixel();
        
        int loop_ = 0;
        LogMe logMe = null;
        
        List<NameValuePair> params = null;
        try {
                params = URLEncodedUtils.parse(new URI(urlParams), "UTF-8");
            } catch (URISyntaxException ex) {
                Logger.getLogger(LocalModeHttpHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        URI tempURI = null;
        try {
             tempURI = new URI("http://localhost:8080" + urlParams);
        } catch (URISyntaxException ex) {
            Logger.getLogger(LocalModeHttpHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String URLPath = tempURI.getPath();
        System.out.println("path is: " + URLPath);
        
        
        logMe = LogMe.getInstance();
        if (!CliPixel.getSilentMode()) {
            System.out.println("localplayback handler received: " + urlParams);
            logMe.aLogger.info("localplayback handler received: " + urlParams);
        }
            
            for (NameValuePair param : params) {
                  
                switch (param.getName()) {
                    
                    case "l": //how many times to loop
                        loop_ = 1; //we dont' loop for localplayback and just need something other than 0 to add this to the Q
                         //System.out.println("local mode loop: " + loop_);
                        break;
                    case "loop": //loop
                        loop_ = 1;
                        //System.out.println("local mode loop: " + loop_);
                        break;
                }
            }
        
       logMe = LogMe.getInstance();
       
       System.out.println("Received command for Pixel local playback");
       logMe.aLogger.info("Received command for Pixel local playback");
       
       
       //here we call the playlocal method to check if we need to go into the Q. If not, then playlocal is just called directly
       pixel.playLocalModeCheck(loop_ , WebEnabledPixel.pixelConnected, false);
       
       
   }
    
}


