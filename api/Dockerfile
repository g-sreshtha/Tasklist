FROM amazoncorretto:21-alpine-jdk
EXPOSE 8080
ARG TEST_SKIP=false
COPY . .
RUN if [ "$TEST_SKIP" = "false" ]; then ./gradlew build --refresh-dependencies --stacktrace; else ./gradlew build -x test --refresh-dependencies --stacktrace; fi
CMD ["java", "-jar", "build/libs/assignment5-0.0.1-SNAPSHOT.jar"]
