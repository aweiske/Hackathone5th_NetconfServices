import org.apache.xmlrpc.webserver.WebServer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.apache.xmlrpc.*;

public class ConfigurationServerTest {

    @Test
    @Ignore // former version
    public void canFetchConfigurationFromDevice(){
        ConfigurationServer server = new ConfigurationServer();
        String clientName = "Device1";

        StringBuffer configurationData = server.fetchConfiguation(clientName);

        Assert.assertEquals("module hello {yang-version 1; namespace \"urn:opendaylight:params:xml:ns:yang:hello\"; prefix \"hello\";}", configurationData);
    }

    @Test
    public void canCreateWebServer() {
        ConfigurationServer configurationServer = new ConfigurationServer();
        int port = 80;

        WebServer ws = configurationServer.createWebServer(port);

        Assert.assertNotNull(ws);
    }


}
