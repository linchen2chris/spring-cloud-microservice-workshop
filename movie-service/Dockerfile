FROM java:8

VOLUME /tmp

ADD movie-service-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8001

ENTRYPOINT ["java","-jar", "/app.jar"]
