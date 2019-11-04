FROM openjdk:8-jre-alpine

# Maintainer
MAINTAINER "valaxytech"
RUN mkdir /app
# copy war file on to container
COPY target/*.jar /app/app.jar
CMD java -jar /app/app.jar
