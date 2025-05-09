# Gunakan Maven image dengan JDK 17
FROM maven:3.9.9 AS builder

# Buat direktori kerja
WORKDIR /app

# Copy semua file ke image
COPY . .

# Build aplikasi
RUN mvn clean install -DskipTests

# ==============================

# Image baru untuk menjalankan aplikasi (lebih ringan)
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy hasil build dari stage sebelumnya
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]
