FROM java:8

VOLUME /tmp

ADD user-service-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8000

ENTRYPOINT ["java","-jar", "/app.jar"]
