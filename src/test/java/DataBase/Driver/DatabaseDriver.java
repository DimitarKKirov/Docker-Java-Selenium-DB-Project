package DataBase.Driver;


import LocalDataBaseCreationRelatedFiles.DataBaseConnectionProperties.Paths;
import org.knowm.yank.Yank;

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
