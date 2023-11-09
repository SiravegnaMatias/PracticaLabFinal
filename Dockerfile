FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM eclipse-temurin:17-jdk-alpine
ARG jar_file=target/*.jar
COPY ${jar_file} app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]
