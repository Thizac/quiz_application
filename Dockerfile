FROM openjdk:8
ADD target/quiz_application-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar quiz_application-0.0.1-SNAPSHOT.jar