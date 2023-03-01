FROM openjdk:8-jdk-alpine
WORKDIR .

COPY ./target/outsouring-system-hangzhou*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
