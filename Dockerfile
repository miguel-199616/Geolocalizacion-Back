FROM maven:3.8.3-openjdk-17 AS build

ARG VERSION=latest
ARG JAR_PATH=/target/interview-0.1.0.jar.original

VOLUME /tmp
WORKDIR /
ADD . .
RUN microdnf install findutils

EXPOSE 8080

ENTRYPOINT ["sh","-c","mvn compile exec:java"]