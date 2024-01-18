FROM gradle:7.4.2-jdk17 as builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
RUN gradle build --no-daemon

FROM openjdk:17-slim
EXPOSE 8761
COPY --from=builder /home/gradle/project/build/libs/*.jar /app/registry-service.jar
ENTRYPOINT ["java", "-jar", "/app/registry-service.jar"]
