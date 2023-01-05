Starting the containers
-----------------------

**Create keycloak network**
``docker network create keycloak-network``

**Start containers, krijg het op deze manier niet aan de praat**
``docker-compose run keycloak -d``

**Run shell script to start containers**
``sh start.sh``

**Visit container, may take some time for it to start up**
``http://localhost:8080/``

**Run shell script to stop container**
``sh stop.sh``
