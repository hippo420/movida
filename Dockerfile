FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY ./*.jar  movidar.jar

VOLUME /logs/movidar

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app/movidar.jar"]