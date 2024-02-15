FROM --platform=linux/arm64 amazoncorretto:17
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]