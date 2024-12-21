FROM ubuntu:latest
LABEL authors="BHADRIKA RAVAL"

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

ENTRYPOINT ["top", "-b"]