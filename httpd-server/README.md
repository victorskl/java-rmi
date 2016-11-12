### Build `httpd-server`
The `httpd-server` module for the [Dynamic code downloading using Java RMI](http://docs.oracle.com/javase/8/docs/technotes/guides/rmi/codebase.html) (Using the `java.rmi.server.codebase` Property). This is [optional](#httpdopt) for production use. 

    cd httpd-server
    mvn clean package
    
### Notes <a name="httpdopt"></a>

* Note that the `httpd-server` component is optional. If there is a production web server available (e.g. elsewhere running Apache httpd) then the Remote Interface and parametric artifacts can be better deployed there and recommended for production. But in this case, the `httpd-server` implementation is back by [Jetty](http://www.eclipse.org/jetty/) for ease of development.