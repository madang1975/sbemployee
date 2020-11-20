FROM adoptopenjdk/openjdk8

RUN mkdir -p /opt/demo
COPY ./target/demo-0.0.1-SNAPSHOT.jar /opt/demo/demo-0.0.1-SNAPSHOT.jar
WORKDIR /opt/demo
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]