Installation
------------

**Create docker network**
``docker network create keycloak-network``

**Start keycloak**
``docker-compose up -d keycloak``

**Go to container**
``https://localhost:8080``


Build a .jar from a project
---------------------------

- Download the project in the `projects` directory
- Update the `<name-of-project>` in the `projects/docker-compose.yml` file
- `cd projects`
- `docker-compose run build`
- Copy the `...jar` file to the `providers` directory
- Restart keycloak with `docker-compose restart keycloak`