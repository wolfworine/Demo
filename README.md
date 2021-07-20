# Demo
~~~
comandos para mysql
docker pull mysql

docker run -p 3306:3306 --name mysql8 -v /Users/Cesar-Laptop/dockerVolumes/mysql8:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=teste -d mysql:latest --character-set-server=utf8 --collation-server=utf8_unicode_ci

docker exec -it mysql8 mysql -uroot -p
~~~
~~~
comandos microservicios

mvn clean

mvn package

java -jar 
java -jar .\target\demo-0.0.1-SNAPSHOT.jar
~~~
~~~
localhost:8085/demo/

{ "messageText":"Pruebas", "messageType":"Warning" }
~~~
