FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=builder build/libs/*.jar  movidar.jar


VOLUME /logs/movidar

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/movidar.jar"]