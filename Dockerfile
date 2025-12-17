FROM amazoncorretto:21
WORKDIR /app
LABEL authors="BEN & CO"
COPY target/Expenditure-Project-0.0.1-SNAPSHOT.jar ExpenditureProject.jar
ENTRYPOINT ["java", "-jar", "ExpenditureProject.jar"]
