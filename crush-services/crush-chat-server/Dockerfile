FROM isahl/openjdk17
# FROM findepi/graalvm:java17-native

MAINTAINER lc

RUN mkdir -p /crush/chat/server/logs \
    /crush/chat/server/temp \
    /crush/skywalking/agent

WORKDIR /crush/chat/server

ENV SERVER_PORT=9201

EXPOSE ${SERVER_PORT}

ADD ./target/crush-chat-server.jar ./app.jar

# java.security.egd=file:/dev/./urandom  加快随机数产生过程
# 如果不需要skywalking，注释两行参数skywalking.agent.service_name/javaagent
ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            "-Dskywalking.agent.service_name=crush-chat-server", \
            "-javaagent:/crush/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
