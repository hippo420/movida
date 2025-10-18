FROM openjdk:17-jre-slim

WORKDIR /app

COPY ./*.jar  movidar.jar

VOLUME /logs/movidar

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app/movidar.jar"]