FROM java:8
EXPOSE 8080
ADD target/registration_app.jar registration_app.jar
ENTRYPOINT ["java", "-jar", "registration_app.jar"]