FROM bellsoft/liberica-openjdk-alpine:21

# 빌드된 JAR 파일을 컨테이너로 복사
COPY ./build/libs/*.jar app.jar

# 컨테이너가 실행될 때 JAR 파일을 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]

# 외부에 노출할 포트
EXPOSE 8080
