# Utiliser une image Tomcat officielle
FROM tomcat:10.1-jdk17

# Copier la configuration modifiée
COPY config/server.xml /usr/local/tomcat/conf/server.xml

# Copier le fichier WAR dans Tomcat
COPY target/core-api.war /usr/local/tomcat/webapps/core-api.war

# Exposer le port 8090
EXPOSE 8090

# Lancer Tomcat
CMD ["catalina.sh", "run"]
