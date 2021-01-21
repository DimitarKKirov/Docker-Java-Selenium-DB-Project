package localDataBaseCreationRelatedFiles.dataBaseConnectionProperties;

import org.knowm.yank.PropertiesUtils;

import java.io.File;
import java.util.Properties;

public interface Paths {

    File jsonData= new File("DataBase/CreationOfData/SqlCreationRequests/CorrectDummyData.json");
    File jsonDataOrcl = new File("DataBase/CreationOfData/SqlCreationRequests/WrongDummyData.json");

    String CorrectDummyData = jsonData.getAbsolutePath();
    String WrongDummyData = jsonDataOrcl.getAbsolutePath();

    Properties OracleConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/dataBaseConnectionProperties/OracleConnection.properties");
    Properties OracleSql = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/creationOfData/sqlTablesCreationRequests/OracleDataTableCreationRequest.properties");
    Properties MysqlConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/dataBaseConnectionProperties/MysqlConnection.properties");
    Properties MySql = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/creationOfData/sqlTablesCreationRequests/MysqlDataTableCreationRequest.properties");
    Properties PostgresConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/dataBaseConnectionProperties/PostgresConnection.properties");
    Properties PostgresSql = PropertiesUtils.getPropertiesFromPath("./src/main/java/localDataBaseCreationRelatedFiles/creationOfData/sqlTablesCreationRequests/PostgresDataTableCreationRequest.properties");
}
