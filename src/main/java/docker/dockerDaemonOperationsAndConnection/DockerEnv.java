package docker.dockerDaemonOperationsAndConnection;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


/**
 * This class is used for setting the needed docker environment with images and containers
 * This class uses Docker-Java library to achieve its goals
 * Docker-Java is used in order operations to be made in Docker
 * without the usage of Docker CLI (writing commands in Windows command prompt)
 * base class for Docker connection and command execution
 * https://docs.docker.com/engine/reference/commandline/dockerd/
 * More info for the Docker-Java library - https://www.baeldung.com/docker-java-api
 * https://github.com/docker-java/docker-java
 */
public class DockerEnv {

    private DockerClient dockerClient;


    /**
     * creating connection to docker daemon locally,by changing the host you can change the docker daemon client
     * In order this to happen the port of the DAEMON must be exposed, for Windows Docker there is option in
     * Settings->General Tab->Expose daemon on tcp://localhost:2375 without TLS : this is ok for local use
     * not recommended for remote, if possible Expose the port with TLS
     */
    public void connect() {
        DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
        dockerClient = DockerClientBuilder.getInstance(standard).build();


    }

    /**
     * method for docker client builder to close the connection
     *
     * @throws IOException for example if there is no established connection with the docker daemon
     */

    public void closeConnection() throws IOException {
        dockerClient.close();
        System.out.println("connection to docker is closed");
    }

    /**
     * if there is a container we can remove it by sending the command with the name of the container
     *
     * @param name by stating the name of the container the method will remove it if found any
     *             with that name
     */
    public void removeContainer(String name) {
        dockerClient.removeContainerCmd(name).exec();
        System.out.println("container " + name + " is removed (deleted)");
    }


    /**
     * if there is a container we can stop it by sending the command with the name of the container
     *
     * @param name by stating the name of the container the method will stop it if found any
     *             with that name
     */
    public void stopContainer(String name) {
        dockerClient.stopContainerCmd(name).exec();
        System.out.println("container " + name + " is stopped");
    }


    /**
     * if there is a container we can start it by sending the command with the name of the container
     *
     * @param name by stating the name of the container the method will start it if found any
     *             with that name
     */
    public void startContainer(String name) {
        dockerClient.startContainerCmd(name).exec();
        System.out.println("container " + name + " is started");
    }


    /**
     * the method is pulling an image and creating a container with set name
     * method for downloading image and creating web browser chrome standalone container,
     * the method image usage are hardcoded to - "selenium/standalone-chrome-debug" with tag "latest"
     *
     * @param containerName setting the name of the created container, name must be with lowercase
     * @param ports         exposing ports for connection to the container via web driver for example,the
     *                      syntax is local machine:container - 8080:5432
     * @param vncPort       exposing ports for VNC connection (default VNC password: secret) for
     *                      visually following the test execution if needed
     *                      The VNC is supported in "selenium/standalone-chrome-debug" docker image
     */
    public void standaloneChromeDebug(String containerName, String ports, String vncPort) {
        try {
            System.out.println("Downloading and creating container " + containerName);
            dockerClient.pullImageCmd("selenium/standalone-chrome-debug")
                    .withTag("latest")
                    .start()
                    .awaitCompletion(120, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PortBinding one = PortBinding.parse(ports);
        PortBinding two = PortBinding.parse(vncPort);
        dockerClient.createContainerCmd("selenium/standalone-chrome-debug")
                .withPortBindings(one, two)
                .withName(containerName)
                .exec();
        dockerClient.startContainerCmd(containerName).exec();
        System.out.println("Container is up and running " + containerName);
    }

    // method for downloading image and creating web browser firefox standalone container,
    // ports and name of container are flexible

    /**
     * the method is pulling an image and creating a container with set name, name must be with lowercase
     * method for downloading image and creating web browser firefox standalone container,
     * the method image usage are hardcoded to - "selenium/standalone-firefox-debug" with tag "latest"
     *
     * @param containerName setting the name of the created container
     * @param ports         exposing ports for connection to the container via web driver for example,the
     *                      syntax is local machine:container - 8080:5432
     * @param vncPort       exposing ports for VNC connection (default VNC password: secret) for
     *                      visually following the test execution if needed
     *                      The VNC is supported in "selenium/standalone-chrome-debug" docker image
     */
    public void standaloneFireFoxDebug(String containerName, String ports, String vncPort) {
        try {
            System.out.println("Downloading and creating container " + containerName);
            dockerClient.pullImageCmd("selenium/standalone-firefox-debug")
                    .withTag("latest")
                    .start()
                    .awaitCompletion(120, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PortBinding one = PortBinding.parse(ports);
        PortBinding two = PortBinding.parse(vncPort);
        Volume volume = new Volume("/dev/shm/dev/shm");
        dockerClient.createContainerCmd("selenium/standalone-firefox-debug")
                .withVolumes(volume)
                .withPortBindings(one, two)
                .withName(containerName)
                .exec();
        dockerClient.startContainerCmd(containerName).exec();
        System.out.println("Container is up and running " + containerName);
    }


    /**
     * the method is pulling and creating a containers from two docker files for databases
     *
     * @param dockerFile  absolute path to the first dockerfile, example of method usage:
     *                    DockerEnv con = new DockerEnv();
     *                    File mysql = new File("localPath\\Dockerfile");
     *                    File postgres = new File("localPath\\Dockerfile");
     *                    con.createDBContainers(mysql, "mydb","8080:3306" , postgres, "mypostdb", "8081:5432");
     * @param name        setting a name for the first created container, name must be with lowercase
     * @param port1       exposed port for the first created container, syntax - local machine:container
     * @param dockerFile2 absolute path to the second dockerfile, example of method usage: see the example
     *                    of the first dockerfile
     * @param secondName  setting a name for the second created container
     * @param port2       exposed port for the first created container, syntax - local machine:container
     */
    public void createDBContainers(File dockerFile, String name, String port1, File dockerFile2, String secondName, String port2) {
        System.out.println("Downloading and creating containers " + name + ", " + secondName);
        dockerClient.buildImageCmd()
                .withTags(Collections.singleton(name))
                .withDockerfile(dockerFile)
                .start()
                .awaitImageId();
        dockerClient.createContainerCmd(name)
                .withName(name)
                .withPortBindings(PortBinding.parse(port1))
                .exec();

        dockerClient.startContainerCmd(name).exec();

        dockerClient.buildImageCmd().withForcerm(true)
                .withDockerfile(dockerFile2)
                .withTags(Collections.singleton(secondName))
                .start()
                .awaitImageId();
        dockerClient.createContainerCmd(secondName)
                .withName(secondName)
                .withPortBindings(PortBinding.parse(port2))
                .exec();
        dockerClient.startContainerCmd(secondName).exec();
        dockerClient.removeImageCmd("mysql/mysql-server").exec();
        dockerClient.removeImageCmd("postgres").exec();
        System.out.println("Containers are up and running " + name + ", " + secondName);
    }


}
