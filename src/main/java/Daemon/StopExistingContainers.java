package Daemon;

public class StopExistingContainers {
    public static void main(String[] args) {
        DockerEnv con = new DockerEnv();
        con.connect();
        con.stopContainer("mydb");
        con.stopContainer("oracle18");
        con.stopContainer("mypostdb");
        con.stopContainer("alonecrome");
        con.stopContainer("alonefox");
    }
}
