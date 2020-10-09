FROM amazoncorretto:11-alpine-jdk as baseimage
RUN mkdir -p /app
WORKDIR /app
COPY . .
RUN ./gradlew clean build

FROM amazoncorretto:11-alpine-jdk
COPY --from=baseimage /app/build/libs/fluentd-multiline-java-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]