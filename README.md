# Java RMI and Distributed Object Application

* Ant script for deployment
* Maven for package dependency, build and project management

# Building 

### Build `httpd-server`
The `httpd-server` module for the [Dynamic code downloading using Java RMI](http://docs.oracle.com/javase/8/docs/technotes/guides/rmi/codebase.html) (Using the `java.rmi.server.codebase` Property). This is [optional](#httpdopt) for production use. 

    cd httpd-server
    mvn clean package

### Build `oracle-rmi-tute`
A complete RMI application using the [Maven multi module](https://github.com/victorskl/vanilla-archetype-mmmp) structure. The application adapts the tutorial from [Java RMI Tutorial trail](https://docs.oracle.com/javase/tutorial/rmi/overview.html).

    cd oracle-rmi-tute
    mvn clean package
    
# Deployment and Running

Basically, the RMI deployment steps involve 4 distributed components, each of them can be run in different machines or _different processes_ on a _single_ machine. In this example, [the Ant script](build.xml) will create the possible deployment structure and will copy the artifacts in place for running the application.

### Deploy

    ant clean deploy

### Running

Starting each components. **Must be in order**:

1. Start httpd server (for Remote Interface and parametric objects)
2. Start `rmiregistry` process
3. Start RMI server
4. Start RMI client

#### Example: running `oracle-rmi-tute`

    cd deploy/httpd
    start.bat  (or start.sh)
    cd ../registry
    startregistry.bat  (startregistry.sh)
    cd ../server
    start.bat  (or start.sh)
    cd ../client
    start.bat  (or start.sh)

### Notes <a name="httpdopt"></a>

* Note that the `httpd-server` component is optional. If there is a production web server available (e.g. elsewhere running Apache httpd) then the Remote Interface and parametric artifacts can be better deployed there and recommended for production. But in this case, the `httpd-server` implementation is back by [Jetty](http://www.eclipse.org/jetty/) for ease of development.