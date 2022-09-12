FROM openjdk:19-alpine
ADD target/*.jar w34.jar
EXPOSE 5050
ENTRYPOINT ["java", "-jar", "w34.jar"]