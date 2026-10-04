## Docker Compose Commands Cheat Sheet

 ### 1. Stack Lifecycle & Deployment

 | Command | Example | Use Case |
| --- | --- | --- |
| `docker compose up` | `docker compose up -d` | Builds, creates, and starts all services defined in the Compose file. `-d` runs containers in detached mode. |
| `docker compose down` | `docker compose down -v` | Stops and removes containers and networks. `-v` also removes named volumes, which can delete persistent database data. |
| `docker compose build` | `docker compose build --no-cache` | Builds service images from their Dockerfiles without starting containers. |
| `docker compose start` | `docker compose start web` | Starts previously created but stopped containers without recreating them. |
| `docker compose stop` | `docker compose stop` | Gracefully stops running containers while preserving containers and volumes for later restart. |
| `docker compose restart` | `docker compose restart` | Restarts services. It does **not** recreate containers or apply changed environment/configuration settings. |
| `docker compose create` | `docker compose create` | Creates containers without starting them. |

### 2\. Observability, Logs & Debugging

 | Command | Example | Use Case |
| --- | --- | --- |
| `docker compose ps` | `docker compose ps` | Lists containers and their current status for the Compose project. |
| `docker compose logs` | `docker compose logs -f api` | Displays service logs. `-f` continuously follows new log output. |
| `docker compose exec` | `docker compose exec db psql` | Runs a command inside an already-running container. |
| `docker compose run` | `docker compose run web npm test` | Creates a temporary container to run a one-off command such as tests or migrations. |
| `docker compose top` | `docker compose top` | Displays processes currently running inside Compose containers. |
| `docker compose images` | `docker compose images` | Lists images used by the services in the Compose project. |
| `docker compose cp` | `docker compose cp ./conf web:/etc/` | Copies files or directories between the host and a container. |
| `docker compose events` | `docker compose events --json` | Streams Docker events related to the Compose project. |

### 3\. Configuration & Registry Management

 | Command | Example | Use Case |
| --- | --- | --- |
| `docker compose config` | `docker compose config` | Validates and renders the fully resolved Compose configuration. |
| `docker compose pull` | `docker compose pull` | Downloads newer service images from configured registries. |
| `docker compose push` | `docker compose push` | Pushes service images to their configured container registries. |
| `docker compose rm` | `docker compose rm -f` | Removes stopped service containers. |
| `docker compose ls` | `docker compose ls` | Lists Compose projects currently known to the Docker engine. |

### Quick Grouping

 - **Start/stop:** `up`, `start`, `stop`, `restart`
- **Build:** `build`
- **Remove:** `down`, `rm`
- **Inspect:** `ps`, `top`, `images`, `config`
- **Debug:** `logs`, `exec`, `run`, `events`
- **Files:** `cp`
- **Registry:** `pull`, `push`
- **Projects:** `ls`

 **Important:** `docker compose down -v` can remove named volumes containing database data, so use it carefully.