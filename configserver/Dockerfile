FROM openjdk:8-jdk-alpine
EXPOSE 8888
VOLUME ["config-properties"]
ARG JAR_FILE=target/configserver-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} configserver.jar
ENTRYPOINT ["java","-jar","configserver.jar"]
