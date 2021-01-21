package database.driver;


import localDataBaseCreationRelatedFiles.dataBaseConnectionProperties.Paths;
import org.knowm.yank.Yank;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that points Yank to the connection properties for the needed database
 */
public  abstract class DatabaseDriver implements Paths {




    /**
     * Yank setupDefaultConnectionPool uses properties file
     * with connection variables
     * the method creates connection for the set database in properties file
     */
    public void createConnection(String databaseName) {
        Logger.getLogger("com.zaxxer.hikari.HikariDataSource").setLevel(Level.WARNING);
        Logger.getLogger("org.knowm.yank.YankPoolManager").setLevel(Level.WARNING);
        if (databaseName.equalsIgnoreCase("Oracle")) {
            Yank.setupDefaultConnectionPool(OracleConnection);
        } else if (databaseName.equalsIgnoreCase("Mysql")) {
            Yank.setupDefaultConnectionPool(MysqlConnection);
        } else if (databaseName.equalsIgnoreCase("Postgres")) {
            Yank.setupDefaultConnectionPool(PostgresConnection);
        }

    }

    public void closeConnection(){
        Yank.releaseAllConnectionPools();
    }
}
