FROM openjdk:8
MAINTAINER Rushikesh Jachak rushikesh.jachak@iiitb.org
COPY ./target/SPE_Calculator-1.0-SNAPSHOT.jar ~/
WORKDIR ~/
CMD ["java", "-jar", "SPE_Calculator-1.0-SNAPSHOT.jar"]
