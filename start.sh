#!/bin/bash

docker run -p 3306:3306 --name mysql -d --net keycloak-network -e MYSQL_DATABASE=keycloak -e MYSQL_USER=keycloak -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=root_password mysql:5.7
docker run -p 8080:8080 --name keycloak -d --net keycloak-network -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -e KC_DB=mysql -e KC_DB_URL=jdbc:mysql://mysql:3306/keycloak -e KC_DB_USERNAME=keycloak -e KC_DB_PASSWORD=password quay.io/keycloak/keycloak:latest start-dev