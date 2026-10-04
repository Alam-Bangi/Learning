 # Docker Commands Cheat Sheet

 ## 1\. Container Lifecycle Management

 These commands control the **creation, execution, state, and deletion** of containers.

 | Command | Syntax / Example | Use Case |
| --- | --- | --- |
| `docker run` | `docker run -d -p 80:80 --name web nginx` | Creates and starts a new container from an image. `-d` runs it in the background, while `-p` maps ports. |
| `docker start` | `docker start <container_id_or_name>` | Starts an existing stopped container without creating a new one. |
| `docker stop` | `docker stop <container_id_or_name>` | Gracefully stops a running container. |
| `docker restart` | `docker restart <container_id_or_name>` | Stops and starts a container again. |
| `docker kill` | `docker kill <container_id_or_name>` | Immediately stops a container by sending a `SIGKILL` signal. |
| `docker pause` | `docker pause <container_id_or_name>` | Suspends all processes running inside a container. |
| `docker unpause` | `docker unpause <container_id_or_name>` | Resumes a paused container. |
| `docker rm` | `docker rm <container_id_or_name>` | Removes a stopped container. |

---

 ## 2\. Image Management

 These commands are used to **create, download, upload, tag, and remove Docker images**.

 | Command | Syntax / Example | Use Case |
| --- | --- | --- |
| `docker build` | `docker build -t my-app:1.0 .` | Builds a custom image from a `Dockerfile` and assigns it a tag. |
| `docker images` | `docker images` | Lists locally available Docker images. |
| `docker pull` | `docker pull postgres` | Downloads an image from a container registry such as Docker Hub. |
| `docker push` | `docker push username/my-app:1.0` | Uploads an image to a container registry. |
| `docker rmi` | `docker rmi <image_id_or_name>` | Removes a local Docker image. |
| `docker tag` | `docker tag source-image:latest new-image:v1` | Creates a new tag/reference for an existing image. |
| `docker commit` | `docker commit <container_id> new-image` | Creates a new image from the current state of a container. |

---

 ## 3\. Monitoring, Inspection & Debugging

 These commands help you **monitor containers and troubleshoot problems**.

 | Command | Syntax / Example | Use Case |
| --- | --- | --- |
| `docker ps` | `docker ps -a` | Lists containers. `-a` includes stopped containers. |
| `docker exec` | `docker exec -it web bash` | Opens an interactive shell or runs a command inside a running container. |
| `docker logs` | `docker logs -f <container_name>` | Displays container logs. `-f` continuously follows new log output. |
| `docker inspect` | `docker inspect <object_name>` | Displays detailed low-level information about a Docker object in JSON format. |
| `docker stats` | `docker stats` | Shows real-time CPU, memory, network, and other resource usage. |
| `docker top` | `docker top <container_name>` | Displays processes currently running inside a container. |
| `docker cp` | `docker cp localfile.txt web:/app/` | Copies files or directories between the host and a container. |

---

 ## 4. Networking & Volumes

 These commands manage **container networking and persistent storage**.

 | Command | Syntax / Example | Use Case |
| --- | --- | --- |
| `docker network create` | `docker network create my-net` | Creates a custom Docker network for container-to-container communication. |
| `docker network ls` | `docker network ls` | Lists Docker networks. |
| `docker volume create` | `docker volume create db-data` | Creates a persistent Docker volume. |
| `docker volume ls` | `docker volume ls` | Lists Docker volumes. |

---

 ## 5\. System Maintenance & Authentication

 These commands are used for **registry authentication, system information, and cleanup**.

 | Command | Syntax / Example | Use Case |
| --- | --- | --- |
| `docker login` | `docker login` | Authenticates the Docker CLI with a container registry. |
| `docker system prune` | `docker system prune -a` | Removes unused Docker resources to reclaim disk space. |
| `docker info` | `docker info` | Displays detailed information about the Docker installation and Docker Engine. |

---

 # Quick Revision

 | Category | Important Commands |
| --- | --- |
| **Container Lifecycle** | `run`, `start`, `stop`, `restart`, `kill`, `pause`, `unpause`, `rm` |
| **Images** | `build`, `images`, `pull`, `push`, `rmi`, `tag`, `commit` |
| **Debugging** | `ps`, `exec`, `logs`, `inspect`, `stats`, `top`, `cp` |
| **Networking & Storage** | `network create`, `network ls`, `volume create`, `volume ls` |
| **Maintenance** | `login`, `system prune`, `info` |

### Commonly Remembered Flow

```
Dockerfile
    ↓
docker build
    ↓
Docker Image
    ↓
docker run
    ↓
Container
    ↓
docker stop / restart / pause
    ↓
docker rm
```

 **Tip:** Think of an **image as a blueprint** and a **container as a running instance of that blueprint**.