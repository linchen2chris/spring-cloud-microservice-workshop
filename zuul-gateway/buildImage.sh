mvn clean package spring-boot:repackage && cp Dockerfile target/ && cd target && docker build -t zuul-gateway .
