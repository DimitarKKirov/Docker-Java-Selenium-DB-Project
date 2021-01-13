package Docker.DockerRunnerClasses;

import Docker.Daemon.DockerEnv;

public class StartExistingContainers {
    public static void main(String[] args) {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.startContainer("mydb");
        con.startContainer("oracle18");
        con.startContainer("mypostdb");
        con.startContainer("alonecrome");
        con.startContainer("alonefox");    }
}
