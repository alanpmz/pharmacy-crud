FROM openjdk:21-jdk-slim
WORKDIR /app

COPY . .

RUN javac -d out src/main/java/**/*.java

CMD ["java", "-cp", "out", "Main"]
