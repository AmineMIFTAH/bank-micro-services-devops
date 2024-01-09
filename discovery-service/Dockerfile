FROM openjdk:17-oracle
LABEL authors="amine"
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

