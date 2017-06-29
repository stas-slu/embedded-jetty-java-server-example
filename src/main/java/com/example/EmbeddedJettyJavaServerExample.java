package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * In this example, we will show how to use Jetty HTTP server in embedded mode.
 * Embedded mode means that the server shipped together with the application as opposed of deploying the application on external Jetty server.
 *
 * It means the if in non-embedded approach your webapp built into WAR file which deployed to some server, in embedded Jetty, you write a web application and instantiate jetty server in the same code base.
 *
 */
public class EmbeddedJettyJavaServerExample {

    public static void main(String... args) throws Exception {

        //Running Jetty HTTP server on port 8080. When started, can be accessed from http://localhost:8080/
        Server server = new Server(8080);

        // ServletHandler is the one who handles Servlets in Jetty, Servlets are the standard way to provide application logic that handles HTTP requests.
        // So, here we specifying that we want to use BasicHelloServlet to handle our http requests by attaching it to ServletHandler.
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        servletHandler.addServletWithMapping(BasicHelloServlet.class, "/validUrl");

        // Starting Jetty server.
        server.start();
        server.join();
    }
}