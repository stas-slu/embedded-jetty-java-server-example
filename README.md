## Basic Embedded Jetty Java Server Example

An example of how to use Jetty HTTP server in embedded mode (the server shipped together with the application as opposed of deploying the application separately on external Jetty server).

Could be started by:
* Running the main() method.
* By utilizing [Maven exec plugin][1] with command `mvn clean compile exec:java`

Then, just access `http://localhost:8080/` 
 
 [1]: http://www.mojohaus.org/exec-maven-plugin/