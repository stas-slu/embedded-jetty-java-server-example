package com.example;


import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyServletTest {

    @Test
    public void testName() throws Exception {
        ServletTester servletTester = ServletTesterUtils.createServletTester();
        ServletTesterUtils.initServlet(servletTester, "/", BasicHelloServlet.class, "/validUrl");

        HttpTester response = ServletTesterUtils.makeRequest(servletTester, "/validUrl");

        assertEquals(200,response.getStatus());
        assertEquals("<h1>New Hello Simple Servlet</h1>",response.getContent());
        assertEquals("works",response.getHeader("test-header"));
    }

    @Test
    public void testName2() throws Exception {
        ServletTester servletTester = ServletTesterUtils.createServletTester();
        ServletTesterUtils.initServlet(servletTester, "/", BasicHelloServlet.class, "/validUrl");

        HttpTester response = ServletTesterUtils.makeRequest(servletTester, "/invalidUrl");

        assertEquals(404,response.getStatus());
    }
}
