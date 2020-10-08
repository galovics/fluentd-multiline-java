FROM amazoncorretto:11-alpine-jdk
COPY build/libs/fluentd-multiline-java-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]