# 1단계: 빌드
FROM gradle:8.7-jdk21-alpine AS build
WORKDIR /app
COPY . .
# 앞에 cat이나 EOF 같은 게 있으면 안 됩니다!
RUN gradle clean bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]