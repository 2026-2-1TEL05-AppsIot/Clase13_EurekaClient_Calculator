FROM eclipse-temurin:17
EXPOSE 8020
COPY "target/Clase13_EurekaClient_Calculator-0.0.1-SNAPSHOT.jar" /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-jar","Clase13_EurekaClient_Calculator-0.0.1-SNAPSHOT.jar","--eureka.client.service-url.defaultZone=http://eureka-server:8761/eureka"]