package database.remoteDatabaseStepDefinitions;

import database.DAO.TablesMysql;
import database.DAO.TablesPostgres;
import database.config.Master;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ComparingDBDataCountSteps {
    private int countSQL;
    private int countORCL;
    private boolean ask;

    @Given("user extracts the data from DB {string}")
    public void userExtractsTheDataFromDBMysql(String databaseName) {
        TablesMysql Test = new TablesMysql(Master.getMaster().MysqlDriver());
        Test.sqlConnection(databaseName);
        int a = Test.getCount();
        int b = Test.getItemDetailsCount();
        int c = Test.getLoadItemCount();
        countSQL = a+b+c;
        Test.closeConnectionMy();


    }

    @Given("the data from {string} DB")
    public void userExtractsTheDataFromDBOracle(String databaseName) {
        TablesPostgres TestORCL = new TablesPostgres(Master.getMaster().postgresDriver());
        TestORCL.oracleConnection(databaseName);
        int ab = TestORCL.getCountOracle();
        int bc = TestORCL.getItemDetailsCountOracle();
        int cd = TestORCL.getLoadItemCountOracle();
        countORCL = ab+bc+cd;
        TestORCL.closeConnectionOracle();


    }

    @When("the user compares the data")
    public void comparesData() {
        if (countSQL==countORCL){
            ask=true;
        }else {
            ask=false;
        }

    }

    @Then("the data is equal")
    public void equalOrNot() {
        Assert.assertTrue(ask);
    }

}
