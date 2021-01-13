package LocalDataBaseCreationRalatedFiles.DataBaseConnectionProperties;

import java.io.File;

public interface Paths {

    File jsonData= new File("DataBase/CreationOfData/SqlCreationRequests/ItemsFields.json");
    File jsonDataOrcl = new File("DataBase/CreationOfData/SqlCreationRequests/ItemsOrcl.json");

    String jsonPath= jsonData.getAbsolutePath();
    String orclPath = jsonDataOrcl.getAbsolutePath();
}
