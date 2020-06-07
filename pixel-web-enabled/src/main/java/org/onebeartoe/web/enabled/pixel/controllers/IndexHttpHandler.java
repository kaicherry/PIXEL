package org.onebeartoe.web.enabled.pixel.controllers;

import com.sun.net.httpserver.HttpExchange;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.onebeartoe.network.TextHttpHandler; //this is a maven dependency is is compiled with java 1.8

/**
 *
 * @author Roberto Marquez
 */
public class IndexHttpHandler extends TextHttpHandler
{
    @Override
    protected String getHttpText(HttpExchange t)
    {
//        InetAddress localhost = null; //giving an error on rockchip
//        try {
//            localhost = InetAddress.getLocalHost();
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(IndexHttpHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //TODO: Pull the HTML document from a static file in the distribution JAR        
        String response = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n" +
        "\n" +
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
        "\n" +
        "    <head>\n" +
        "<META HTTP-EQUIV=REFRESH CONTENT=\"1; URL=files/index.html\">" +
        "	            \n" +
        "        <title>Upload Redirect</title>\n" +
        "    </head>\n" +
        "\n" +
        "    <body>\n" +
        "        redirecting...\n" +
        "    </body>\n" +
        "</html>";
        
        
        return response;
    }
}