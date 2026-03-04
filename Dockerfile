# 1단계: Build 단계 (선택 사항이지만 일관성을 위해 추천)
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

# 2단계: Run 단계
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 빌드된 jar 파일을 복사 (파일명은 build.gradle의 settings 확인)
COPY build/libs/*.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]