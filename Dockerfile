FROM eclipse-temurin:17-jdk-alpine as build

RUN apk add --no-cache maven

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM eclipse-temurin:17

COPY --from=build /app/target/payment-gateway-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]