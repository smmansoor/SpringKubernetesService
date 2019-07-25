FROM docker-base-image

VOLUME /tmp

COPY target/${project.build.finalName}.jar app.jar

ENV JAVA_OPTS="-Xmx128m -Xms64m"
ENV SERVICE_NAME=${project.name}
ENV SPRING_PROFILES_ACTIVE="docker"
LABEL APP=${project.name}
LABEL DOMAIN="kubernetes-demo"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]