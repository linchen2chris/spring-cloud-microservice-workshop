FROM java:8

VOLUME /tmp

ADD zipkin-server-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 9411

ENTRYPOINT ["java","-jar", "/app.jar"]
