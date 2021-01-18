package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

public class StopExistingContainers {
    public static void main(String[] args) {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.stopContainer("mydb");
        con.stopContainer("mypostdb");
        con.stopContainer("alonechrome");
        con.stopContainer("alonefox");
    }
}
