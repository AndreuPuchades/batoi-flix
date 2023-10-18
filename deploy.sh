#!/bin/bash
# Compilamos la aplicacion y creamos el ejecutable en target/xxxxx.jar
./mvnw clean package -DskipTests

# Copiamos la carpeta deploy al servidor
scp -r -P 443 deploy daw@46.105.158.240:~

# Copiamos la aplicacion compilada al servidor
scp -P 443 ./target/BatoiFlix-0.0.1-SNAPSHOT.jar daw@46.105.158.240:~/deploy/batoiflix.jar

# Lanzamos el entorno de produccion
ssh -p 443 daw@46.105.158.240 "cd deploy && docker-compose down && docker-compose up --build -d"

# Contraseña
admin-grupo4