FROM isahl/openjdk17

MAINTAINER LC

RUN mkdir -p /crush/gateway/logs  \
    /crush/gateway/temp  \
    /crush/skywalking/agent

WORKDIR /crush/gateway

ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

ADD ./target/crush-gateway.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            "-Dskywalking.agent.service_name=crush-gateway", \
            "-javaagent:/crush/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
