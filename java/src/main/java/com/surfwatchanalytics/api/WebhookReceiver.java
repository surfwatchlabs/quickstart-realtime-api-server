package com.surfwatchanalytics.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import java.io.BufferedReader;

public class WebhookReceiver extends AbstractHandler {

    public static void main(String[] args) throws Exception {
        Server server = new Server( 8080 );
        server.setHandler( new WebhookReceiver() );

        System.out.println( "Starting webhook receiver.." );
        server.start();
        server.join();
    }
    
    public void handle(String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        response.setStatus( HttpServletResponse.SC_OK );
        baseRequest.setHandled( true );

        StringBuilder results = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ( ( line = reader.readLine() ) != null ) {
                results.append( line );
            }
        } catch (Exception e) { /*report an error*/ }

        System.out.println( results.toString() );
    }
    
}
