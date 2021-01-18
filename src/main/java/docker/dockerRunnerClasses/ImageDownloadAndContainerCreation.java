package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

import java.io.File;

public class ImageDownloadAndContainerCreation {

    public static void main(String[] args){
        DockerEnv con = new DockerEnv();
        con.connect();
        File mysql = new File(".\\src\\main\\java/docker\\mySqlDockerfileAndSQLFile\\Dockerfile");
        File postgres = new File(".\\src\\main\\java\\docker\\postgresDockerfileAndSQLFile\\Dockerfile");
        con.createDBContainers(mysql, "mydb","8080:3306" , postgres, "mypostdb", "8081:5432");
        con.standaloneChromeDebug("alonecrome","4445:4444","4446:5900");
        con.standaloneFireFoxDebug("alonefox","4444:4444","4443:5900");



    }
}
