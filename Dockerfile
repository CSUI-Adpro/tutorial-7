FROM gradle:7.6-jdk17

WORKDIR /app
COPY ./build/libs/tutorial-7-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","tutorial-7-0.0.1-SNAPSHOT.jar"]
