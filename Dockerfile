FROM quay.io/keycloak/keycloak:latest as builder

ENV KC_HEALTH_ENABLED=true
ENV KC_FEATURES=token-exchange
ENV KC_DB=mysql
RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:latest
COPY --from=builder /opt/keycloak/ /opt/keycloak/
WORKDIR /opt/keycloak

ADD --chown=keycloak themes /opt/keycloak/themes

ENV KC_HEALTH_ENABLED=true
ENV PROXY_ADDRESS_FORWARDING=true

CMD ["start"]