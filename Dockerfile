# 1단계: 빌드 (최신 Gradle 이미지를 사용하여 8.14+ 요구사항 충족)
FROM gradle:jdk21-alpine AS build
WORKDIR /app
COPY . .

# 최신 Gradle 이미지는 내부에 Gradle 8.14 이상이 들어있습니다.
RUN gradle clean bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]