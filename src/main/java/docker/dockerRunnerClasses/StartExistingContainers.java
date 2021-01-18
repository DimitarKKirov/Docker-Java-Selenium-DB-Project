package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

public class StartExistingContainers {
    public static void main(String[] args) {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.startContainer("mydb");
        con.startContainer("mypostdb");
        con.startContainer("alonechrome");
        con.startContainer("alonefox");
    }
}
