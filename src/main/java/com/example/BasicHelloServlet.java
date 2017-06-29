package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * It's the handler that our Jetty server will user.
 * When we will access our running server at http://localhost:8080/ that's the handler that will handle and respond to it.
 */
public class BasicHelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("test-header", "works");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("<h1>New Hello Simple Servlet</h1>");
    }
}
