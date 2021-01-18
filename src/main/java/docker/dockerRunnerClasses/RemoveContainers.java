package docker.dockerRunnerClasses;

import docker.dockerDaemonOperationsAndConnection.DockerEnv;

public class RemoveContainers {
    public static void main(String[] args) {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.removeContainer("mydb");
        con.removeContainer("mypostdb");
        con.removeContainer("alonechrome");
        con.removeContainer("alonefox");
    }
}
