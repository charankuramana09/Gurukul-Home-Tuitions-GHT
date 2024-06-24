

FROM  openjdk:17-alpine

WORKDIR  /app

COPY  target/Gurukul-Home-Tuitions-0.0.1-SNAPSHOT.jar  /app/Gurukul-Home-Tuitions-0.0.1-SNAPSHOT.jar

EXPOSE  5555

CMD  [ "java", "-jar", "Gurukul-Home-Tuitions-0.0.1-SNAPSHOT.jar" ]
