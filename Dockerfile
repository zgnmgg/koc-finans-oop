FROM openjdk:11

COPY build/libs/api-service-1.0-SNAPSHOT.jar /opt/app/api-service-1.0-SNAPSHOT.jar

CMD java -jar -Dspring.profiles.active=$ENV /opt/app/api-service-1.0-SNAPSHOT.jar
