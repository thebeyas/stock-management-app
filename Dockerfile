# Java 17 tabanlı bir imaj kullanıyoruz
FROM openjdk:17-jdk-slim

# Uygulama jar dosyanızın adını buraya ekleyin
ARG JAR_FILE=target/benimpos.jar

# JAR dosyasını konteyner içine kopyalayın
COPY ${JAR_FILE} app.jar

# Uygulamayı başlatın
ENTRYPOINT ["java","-jar","/app.jar"]
