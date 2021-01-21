package dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

import java.io.IOException;

public class RemoveContainers {
    public static void main(String[] args) throws IOException {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.removeContainer("mydb");
        con.removeContainer("mypostdb");
        con.removeContainer("alonechrome");
        con.removeContainer("alonefox");
        con.closeConnection();

    }
}
