# 1단계: Build 단계
FROM gradle:8.14-jdk21-alpine AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# 2단계: Run 단계
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 빌드된 jar 파일을 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
