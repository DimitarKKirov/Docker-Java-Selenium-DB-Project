package database.remoteDatabaseStepDefinitions;


import database.DAO.TablesMysql;
import database.DAO.TablesPostgres;
import database.config.Master;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import localDataBaseCreationRelatedFiles.POJOForTables.Items;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ComparingDataRowsSteps {

    ArrayList<Items> myDB = new ArrayList<>();
    ArrayList<Items> oracleDBO = new ArrayList<>();


    @Given("user extracts data from {int} of {string} Database")
    public void extractingDataFromMySQLDB(int idMysql,String databaseName) {
        TablesMysql mySQLDB = new TablesMysql(Master.getMaster().MysqlDriver());
        mySQLDB.sqlConnection(databaseName);
            myDB.add(mySQLDB.getItemById(idMysql));

        System.out.println(oracleDBO.size());
        mySQLDB.closeConnectionMy();
    }

    @Given("{int} from {string} Database")
    public void extractingDataFromOracleDB(int idOracle,String databaseName) {
        TablesPostgres DB = new TablesPostgres(Master.getMaster().postgresDriver());
        DB.oracleConnection(databaseName);
            oracleDBO.add(DB.getItemByIdOracle(idOracle));

        System.out.println(oracleDBO.size());
        DB.closeConnectionOracle();
    }


    @Then("the user compares the rows data and its the same")
    public void comparingListsWithData() {
            Assert.assertEquals(oracleDBO.get(0).getItemName(), myDB.get(0).getItemName());
            Assert.assertEquals(oracleDBO.get(0).getItemsSerialNumber(),myDB.get(0).getItemsSerialNumber());


    }


}
