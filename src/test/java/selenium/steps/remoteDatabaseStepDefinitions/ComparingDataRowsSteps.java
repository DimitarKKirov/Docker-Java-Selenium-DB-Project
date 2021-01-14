package selenium.steps.remoteDatabaseStepDefinitions;


import database.DAO.TablesMysql;
import database.DAO.TablesPostgres;
import database.config.Master;
import database.POJO.Items;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;

public class ComparingDataRowsSteps {

    ArrayList<Items> myDB = new ArrayList<>();
    ArrayList<Items> oracleDBO = new ArrayList<>();
    boolean asd;

    @Given("user extracts data from {int} of {string} Database")
    public void extractingDataFromMySQLDB(int idMysql,String databaseName) {
        TablesMysql mySQLDB = new TablesMysql(Master.getMaster().MysqlDriver());
        mySQLDB.sqlConnection(databaseName);
            myDB.add(mySQLDB.getItemById(idMysql));

        System.out.println(myDB.size());
        mySQLDB.closeConnectionMy();
    }

    @Given("{int} from {string} Database")
    public void extractingDataFromOracleDB(int idOracle,String databaseName) {
        TablesPostgres oracleDB = new TablesPostgres(Master.getMaster().postgresDriver());
        oracleDB.oracleConnection(databaseName);
            oracleDBO.add(oracleDB.getItemByIdOracle(idOracle));
        System.out.println(oracleDBO.size());
        oracleDB.closeConnectionOracle();
    }


    @Then("the user compares the rows data and its the same")
    public void comparingListsWithData() {
        int i = 0;
            Assert.assertEquals(oracleDBO.get(i).getItemName(), myDB.get(i).getItemName());
            Assert.assertEquals(oracleDBO.get(i).getItemSerialNumber(),myDB.get(i).getItemSerialNumber());

        asd= true;

    }


}
