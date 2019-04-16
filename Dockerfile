FROM maven:3.6.0-jdk-11-slim

WORKDIR /code

ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:go-offline", "-B"]

ADD src/main /code/src/main
RUN ["mvn", "package", "-Dmaven.test.skip=true"]

CMD java -Xmx256m -jar /code/target/event-producer.jar