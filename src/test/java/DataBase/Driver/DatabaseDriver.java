package DataBase.Driver;


import org.knowm.yank.PropertiesUtils;
import org.knowm.yank.Yank;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * Class that points Yank to the connection properties for the needed database
 */
public  abstract class DatabaseDriver {



    private File prop1 = new File("./src/test/java/Database/src/main/java/DataBase/Driver/Connections.properties");
    private File prop2 = new File("./src/test/java/Database/src/main/java/DataBase/Driver/PostgresConnection.properties");
    private File prop3 = new File("./src/test/java/Database/src/main/java/DataBase/Driver/OracleConnect.properties");
    private String path = prop1.getAbsolutePath();
    private String path2 = prop2.getAbsolutePath();
    private String path3 = prop3.getAbsolutePath();
    private Properties MySQLConnection = PropertiesUtils.getPropertiesFromPath(path);
    private Properties PostgresConnection = PropertiesUtils.getPropertiesFromPath(path2);
    private Properties OracleConnect = PropertiesUtils.getPropertiesFromPath(path3);



    /**
     * Yank setupDefaultConnectionPool uses properties file
     * with connection variables
     * the method creates connection for the set database in properties file
     */
    public void createMySQLConnection() {
        Yank.setupDefaultConnectionPool(MySQLConnection);

    }


    /**
     * Yank setupDefaultConnectionPool uses properties file
     * with connection variables
     * the method creates connection for the set database in properties file
     */
    public void createPostgresConnection() {
        Yank.setupDefaultConnectionPool(PostgresConnection);

    }
    public void createOracleConnection() {
        Yank.setupDefaultConnectionPool(OracleConnect);

    }

    /**
     * the method is using the build in method of Yank library
     * for closing the connection to the database
     */
    public void closeConnection(){
        Yank.releaseAllConnectionPools();
    }
}
