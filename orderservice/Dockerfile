FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd && apk add bash && apk add curl
EXPOSE 8080
ARG JAR_FILE=target/orderservice-0.0.1-SNAPSHOT.jar
COPY startOrderService.sh .
RUN chmod +x startOrderService.sh
ADD ${JAR_FILE} order-service.jar
ENTRYPOINT ["./startOrderService.sh"]
