# 1단계: 빌드 (JDK 21 사용)
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
# 프로젝트 전체 복사
COPY . .
# Gradle 빌드 실행 (gradle-wrapper.jar가 이제 서버에 있으므로 작동함)
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# 1단계에서 만든 jar만 가져옴
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]