FROM tomcat:latest

COPY /dist/ProjectManager.war /tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]