mvn -f C:\Users\brice\brice\Dev\Sites\Gestion5\pom.xml clean install -Ptest 
Copy-Item -Path C:\Users\brice\brice\Dev\Sites\Gestion5\Gestion5-presentation\target\Gestion5-presentation.war -Destination C:\Users\brice\brice\@\Software\apache-tomcat-9.0.45\webapps\ -PassThru
