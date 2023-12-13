FROM tomcat:latest

COPY .dist/ProjectManager.war tomcat/webapps/

EXPOSE 8080