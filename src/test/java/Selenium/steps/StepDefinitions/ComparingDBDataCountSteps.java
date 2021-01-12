package Selenium.steps.StepDefinitions;

import DataBase.src.test.java.DAO.TablesMysql;
import DataBase.src.test.java.DAO.TablesOracle;
import DataBase.src.test.java.Driver.Master;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ComparingDBDataCountSteps {
    private int countSQL;
    private int countORCL;
    private boolean ask;

    @Given("user extracts the data from DB Mysql")
    public void userExtractsTheDataFromDBMysql() {
        TablesMysql Test = new TablesMysql(Master.getMaster().MysqlDriver());
        Test.sqlConnection();
        int a = Test.getCount();
        int b = Test.getItemDetailsCount();
        int c = Test.getLoadItemCount();
        countSQL = a+b+c;
        Test.closeConnectionMy();


    }

    @Given("the data from Oracle DB")
    public void userExtractsTheDataFromDBOracle() {
        TablesOracle TestORCL = new TablesOracle(Master.getMaster().OracleDriver());
        TestORCL.oracleConnection();
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
