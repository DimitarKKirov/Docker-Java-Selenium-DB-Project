package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

import java.io.IOException;

public class StopExistingContainers {
    public static void main(String[] args) throws IOException {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.stopContainer("mydb");
        con.stopContainer("mypostdb");
        con.stopContainer("alonechrome");
        con.stopContainer("alonefox");
        con.closeConnection();
    }
}
