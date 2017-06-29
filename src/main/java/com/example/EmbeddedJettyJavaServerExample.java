package com.example;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class EbmeddedJettyJavaServerExample {

    public static void main(String[] args) {
        Server server = new Server(8680);
        try {
            server.setHandler(new HelloHandler());
            server.start();
            server.dumpStdErr();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class HelloHandler extends AbstractHandler {

        public HelloHandler() {
            this("Hello Java Code Geeks - First Handler");
        }

        public HelloHandler(String arg) {
            this(arg, null);
        }

        public HelloHandler(String arg1, String arg2){
            this.greetmessage = arg1;
            this.bodymessage = arg2;
        }
        public void handle(String target, Request baseRequest, HttpServletRequest request,
                           HttpServletResponse response) throws IOException, ServletException {
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.println(greetmessage);
            if(bodymessage != null){
                out.println(bodymessage);
            }

            baseRequest.setHandled(true);

        }

        final String greetmessage;
        final String bodymessage;

    }
}