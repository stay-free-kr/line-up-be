cat > ~/line-up-be/Dockerfile <<EOF
# 1단계: 빌드 (Gradle이 이미 설치된 이미지를 사용)
FROM gradle:8.7-jdk21-alpine AS build
WORKDIR /app

# 소스 코드 복사
COPY . .

# gradlew 대신 이미 설치된 gradle 명령어로 빌드! (jar 파일 체크 안 함)
RUN gradle clean bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EOF