package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

import java.io.IOException;

public class StartExistingContainers {
    public static void main(String[] args) throws IOException {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.startContainer("mydb");
        con.startContainer("mypostdb");
        con.startContainer("alonechrome");
        con.startContainer("alonefox");
        con.closeConnection();
    }
}
