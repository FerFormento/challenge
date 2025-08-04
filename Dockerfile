FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/challenge-1.0.0.jar challenge-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "challenge-1.0.0.jar"]
