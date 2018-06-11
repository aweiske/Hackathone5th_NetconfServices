package netconf.client;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.apache.xmlrpc.client.util.ClientFactory;


public class Client {
    public static void main(String[] args) throws Exception {
        // create configuration
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:8181/xmlrpc"));
        config.setEnabledForExtensions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);

        XmlRpcClient client = new XmlRpcClient();

        // use Commons HttpClient as transport
        client.setTransportFactory(
                new XmlRpcCommonsTransportFactory(client));
        // set configuration
        client.setConfig(config);

        // make the a regular call
        Object[] params = new Object[]{
                "John"
        };
        String result;
        result = (String) client.execute("netconf.operations.NetconfBase.processNetconf", params);
        System.out.println("client:" + result);

//        Object[] params = new Object[]
//                { new Integer(2), new Integer(3) };
//        Integer result = (Integer) client.execute("netconf.operations.Calculator.add", params);
//        System.out.println("2 + 3 = " + result);

        // make a call using dynamic proxy
//        ClientFactory factory = new ClientFactory(client);
//        netconf.operations.Adder adder = (netconf.operations.Adder) factory.newInstance(netconf.operations.Adder.class);
//        int sum = adder.add(2, 4);
//        System.out.println("2 + 4 = " + sum);
    }
}