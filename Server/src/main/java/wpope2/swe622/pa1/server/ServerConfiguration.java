package wpope2.swe622.pa1.server;

import java.io.File;
import java.util.Properties;

public class ServerConfiguration {

    private int port;
    private boolean debug;
    private File storageLocation;
    private File tempStorageLocation;

    /**
     * Populates a ServerConfiguration instance with the values in the Properties object.
     *
     * @throws NullPointerException if properties is null.
     */
    public ServerConfiguration(Properties properties) {

        String portStr = properties.getProperty("server.port");
        port = Integer.parseInt(portStr);

        String debugStr = properties.getProperty("debug");
        debug = Boolean.parseBoolean(debugStr);

        String storageLocationStr = properties.getProperty("server.storage.path");
        storageLocation = new File(storageLocationStr);
    }

    /**
     * Returns the server's port.
     *
     * @return the server's port.
     */
    public int getPort() {
        return port;
    }

    /**
     * Returns whether the server is running in debug mode.
     *
     * @return true if the server is in debug-mode; false otherwise.
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Returns the storage directory for the server's files.
     *
     * @return the storage directory for the server's files.
     */
    public File getStorageLocation() {
        return storageLocation;
    }
}
