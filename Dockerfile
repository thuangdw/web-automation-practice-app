# in terminal: podman pull docker.io/library/amazoncorretto:17-alpine

FROM docker.io/library/amazoncorretto:17-alpine
RUN apk add --no-cache python3
WORKDIR /app
COPY src/main/resources/webapp /app/webapp
EXPOSE 8080
WORKDIR /app/webapp
CMD ["python3", "-m", "http.server", "8080"]
