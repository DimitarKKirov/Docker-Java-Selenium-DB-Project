package localDataBaseCreationRelatedFiles.dataBaseConnectionProperties;

import org.knowm.yank.PropertiesUtils;

import java.io.File;
import java.util.Properties;

public interface Paths {

    File jsonData= new File("DataBase/CreationOfData/SqlCreationRequests/CorrectDummyData.json");
    File jsonDataOrcl = new File("DataBase/CreationOfData/SqlCreationRequests/WrongDummyData.json");

    String CorrectDummyData = jsonData.getAbsolutePath();
    String WrongDummyData = jsonDataOrcl.getAbsolutePath();

    Properties OracleConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/DataBaseConnectionProperties/OracleConnection.properties");
    Properties OracleSql = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/CreationOfData/SqlCreationRequests/OracleDataTableCreationRequest.properties");
    Properties MysqlConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/DataBaseConnectionProperties/MysqlConnection.properties");
    Properties MySql = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/CreationOfData/SqlCreationRequests/MysqlDataTableCreationRequest.properties");
    Properties PostgresConnection = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/DataBaseConnectionProperties/PostgresConnection.properties");
    Properties PostgresSql = PropertiesUtils.getPropertiesFromPath("./src/main/java/LocalDataBaseCreationRelatedFiles/CreationOfData/SqlCreationRequests/PostgresDataTableCreationRequest.properties");
}
