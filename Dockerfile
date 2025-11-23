# in terminal: podman pull docker.io/library/amazoncorretto:17-alpine

# working
# FROM docker.io/library/amazoncorretto:17-alpine
# RUN apk add --no-cache python3
# WORKDIR /app
# COPY src/main/resources/webapp /app/webapp
# EXPOSE 8080
# WORKDIR /app/webapp
# CMD ["python3", "-m", "http.server", "8080"]


# Use node slim to serve static files
FROM node:18-alpine

WORKDIR /usr/src/app

# Install a simple static server (http-server)
RUN npm install -g http-server

# Copy site contents (make sure index.html and other pages are in this directory)
COPY . /usr/src/app

# Expose port used by http-server
EXPOSE 8080

# Start static server on port 8080
CMD ["http-server", "-p", "8080", "-a", "0.0.0.0", "--cors"]
