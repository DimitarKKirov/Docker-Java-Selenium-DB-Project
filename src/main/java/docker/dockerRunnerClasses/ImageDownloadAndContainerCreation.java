package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

import java.io.File;

public class ImageDownloadAndContainerCreation {

    public static void main(String[] args) throws InterruptedException {
        DockerEnv con = new DockerEnv();
        con.connect();
        File oracleDB = new File(".\\src\\main\\java\\docker\\oracleDockerfileAndSQLFile\\Dockerfile");
        File mysql = new File(".\\src\\main\\java/docker\\mySqlDockerfileAndSQLFile\\Dockerfile");
        File postgres = new File(".\\src\\main\\java\\docker\\postgresDockerfileAndSQLFile\\Dockerfile");
        File jenkins = new File(".\\src\\main\\java\\Jenkins\\Dockerfile");
//        con.createDBContainers(mysql, "mydb","8080:3306" , postgres, "mypostdb", "8081:5432");
//        con.standaloneChromeDebug("alonecrome","4445:4444","4446:5900");
//        con.standaloneFireFoxDebug("alonefox","4444:4444","4443:5900");
//        con.pullOracleDB("pvargacl/oracle-xe-18.4.0");
        con.imageFromOracleDockerFile(oracleDB,"myoracle");
        con.createContainer("myoracle","oracle18","1521:1521");
        con.startContainer("oracle18");
//        con.imageFromDockerFileToJenkinsContainer(jenkins,"jenkins","8888:8080","50000:50000");
//        con.getDockerLogs("jenkins");




    }
}
