FROM tomcat:latest

COPY /dist/ProjectManager.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]