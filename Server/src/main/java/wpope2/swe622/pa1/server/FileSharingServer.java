package wpope2.swe622.pa1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Properties;

public class FileSharingServer {

    private final static String propertiesFileLocation = "server.properties";
    private static ServerConfiguration configuration;

    public static void main(String[] args) throws Exception{

        try {
            initialize();
        } catch (IOException ioException) {
            System.out.println("IOException while attempting to load properties from" + propertiesFileLocation + ": " + ioException.getMessage());
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(configuration.getPort());
        } catch (IOException ioException) {
            System.out.println("Unable to open server socket at port " + configuration.getPort());
        }

        while(true) {
            Socket socketConnection = serverSocket.accept();
            BufferedReader stream = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
        }

    }

    /**
     * Initializes the server instance with values from the configuration file.
     * @throws IOException If the properties cannot be loaded from the properties file location.
     */
    private static void initialize() throws IOException {

        InputStream propertiesInputStream = ClassLoader.getSystemResourceAsStream(propertiesFileLocation);
        Properties properties = new Properties();
        properties.load(propertiesInputStream);
        configuration = new ServerConfiguration(properties);
    }


}
