FROM openjdk:17
ADD target/spring-boot-project.jar spring-boot-project.jar
ENTRYPOINT [ "java","-jar","/spring-boot-project.jar"]