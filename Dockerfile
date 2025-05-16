FROM openjdk:21-jdk

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 컨테이너로 복사
COPY ./build/libs/spring-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너가 실행될 때 JAR 파일을 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 외부에 노출할 포트
EXPOSE 8080
