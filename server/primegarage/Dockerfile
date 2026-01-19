FROM eclipse-temurin:21-jdk

WORKDIR /backend-api

LABEL authors="gpego1"

ARG JAR_FILE=target/*.jar

COPY ./target/primegarage-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]