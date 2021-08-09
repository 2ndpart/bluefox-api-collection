FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/bfox-api-collection.jar ./
EXPOSE 8080
ENTRYPOINT java $SYS_PROPS -jar bfox-api-collection.jar

# Note : run it with `docker build -t <your_image_name> -f src/docker/Dockerfile .`
