# 1단계: 빌드 (확실하게 Gradle 8.12 이상 버전 사용)
FROM gradle:8.12.1-jdk21-alpine AS build
WORKDIR /app
COPY . .

# 빌드 실행
RUN gradle clean bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]