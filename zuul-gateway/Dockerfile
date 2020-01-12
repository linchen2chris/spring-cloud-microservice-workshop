FROM java:8

VOLUME /tmp

ADD zuul-gateway-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8040

ENTRYPOINT ["java","-jar", "/app.jar"]
