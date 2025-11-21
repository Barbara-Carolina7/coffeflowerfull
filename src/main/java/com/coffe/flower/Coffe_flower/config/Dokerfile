# ----------------------------------------------------
# 1. ETAPA DE CONSTRUCCIÓN (BUILD STAGE)
# Utiliza la imagen de Maven con Java 21 para compilar el proyecto.
# Nombrado como 'builder' para referenciarlo después.
# ----------------------------------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de Maven para descargar dependencias primero (mejora el caché)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente restante
COPY src ./src

# Compila y empaqueta la aplicación en un JAR ejecutable
# El nombre del JAR se basa en tu pom.xml: naves-0.0.1-SNAPSHOT.jar
RUN mvn clean package -DskipTests


# ----------------------------------------------------
# 2. ETAPA DE EJECUCIÓN (RUNTIME STAGE)
# Utiliza solo el Java Runtime Environment (JRE) para reducir el tamaño final de la imagen.
# ----------------------------------------------------
FROM eclipse-temurin:21-jre-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR ejecutable de la etapa de construcción anterior y lo renombra a 'app.jar'
COPY --from=builder /app/target/naves-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto por defecto (aunque SERVER_PORT=${PORT} en Render lo sobrescribe)
EXPOSE 8080

# Comando para ejecutar la aplicación JAR
# El ENTRYPOINT debe ser una lista para un entorno más robusto
ENTRYPOINT ["java", "-jar", "app.jar"]