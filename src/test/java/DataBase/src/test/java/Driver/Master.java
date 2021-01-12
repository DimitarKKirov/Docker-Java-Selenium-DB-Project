package DataBase.src.test.java.Driver;

/**
 * Singleton initialization of classes
 * Master class is is static class that can be called freely
 * used for instantiating and accessing classes in the project
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class Master {

    private static Master Master = new Master();
    private MySQLDatabaseDriver Mysql;
    private OracleDatabaseDriver Oracle;


    public static Master getMaster() {
        return Master;
    }

    /**
     * if there is no instance of class MySQLDatabaseDriver
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return MySQLDatabaseDriver instance
     */
    public MySQLDatabaseDriver MysqlDriver() {
        if (Mysql == null) {
            Mysql = new MySQLDatabaseDriver();
        }
        return Mysql;
    }
    /**
     * if there is no instance of class OracleDatabaseDriver
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return OracleDatabaseDriver instance
     */
    public OracleDatabaseDriver OracleDriver() {
        if (Oracle == null) {
            Oracle = new OracleDatabaseDriver();
        }
        return Oracle;
    }
}
