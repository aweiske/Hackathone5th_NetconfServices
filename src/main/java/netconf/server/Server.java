package netconf.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Server {
    private static final int port = 8181;

    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer(port);

        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
          /* Load handler definitions from a property file.
           * The property file might look like:
           *   netconf.operations.Calculator=org.apache.xmlrpc.demo.netconf.operations.Calculator
           *   org.apache.xmlrpc.demo.proxy.netconf.operations.Adder=org.apache.xmlrpc.demo.proxy.netconf.operations.AdderImpl
           */
        phm.load(Thread.currentThread().getContextClassLoader(),
                "MyHandlers.properties");

          /* You may also provide the handler classes directly,
           * like this:
           * phm.addHandler("netconf.operations.Calculator",
           *     org.apache.xmlrpc.demo.netconf.operations.Calculator.class);
           * phm.addHandler(org.apache.xmlrpc.demo.proxy.netconf.operations.Adder.class.getName(),
           *     org.apache.xmlrpc.demo.proxy.netconf.operations.AdderImpl.class);
           */
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig =
                (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();
    }
}