//import ch.ethz.ssh2.Session;

import org.apache.xmlrpc.webserver.WebServer;

public class ConfigurationServer {

//    private Session netconfSession;

    public StringBuffer fetchConfiguation(String clientName) {
        return null;
    }


    public WebServer createWebServer(int port) {
        return new WebServer(port);
    }
}
