package com.example;

import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;

import java.io.IOException;
import java.util.Map;


public class ServletTesterUtils {

    public static ServletTester createServletTester() {
        return new ServletTester();
    }

    public static void initServlet(ServletTester servlet, String resourceBase, Class servletClass, String servletContext) throws Exception {
        initServlet(servlet, resourceBase, servletClass, servletContext, null);
    }

    public static void initServlet(ServletTester servlet, String resourceBase, Class servletClass, String servletContext, Map<String,String> initParams) throws Exception {
        servlet.setResourceBase(resourceBase);
        ServletHolder servletHolder = servlet.addServlet(servletClass, servletContext);
        if (initParams != null) {
            for (String param : initParams.keySet()) {
                servletHolder.setInitParameter(param, initParams.get(param));
            }
        }
        servlet.start();
    }

    public static HttpTester makeRequest(ServletTester servlet, String uri) throws IOException, Exception {
        return makeRequest(servlet, uri, null);
    }

    public static HttpTester makeRequest(ServletTester servlet, String uri, Map<String,String> headers) throws IOException, Exception {
        HttpTester request = new HttpTester();
        request.setMethod("GET");
        request.setURI(uri);
        request.setVersion("HTTP/1.0");
        if (headers != null) {
            for (String header : headers.keySet()) {
                request.setHeader(header, headers.get(header));
            }
        }

        HttpTester response = new HttpTester();
        String requestInRawHttp = request.generate();
        String responsesRaw = servlet.getResponses(requestInRawHttp);
        response.parse(responsesRaw);

        return response;
    }
}
