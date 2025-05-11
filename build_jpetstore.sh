git clone https://github.com/mybatis/jpetstore-6
cp pom.xml jpetstore-6/
cp Dockerfile jpetstore-6/
cp applicationContext.xml jpetstore-6/src/main/webapp/WEB-INF/
docker build --platform linux/amd64 -t 192.168.1.122:5200/my-jpetstore jpetstore-6/
docker push 192.168.1.122:5200/my-jpetstore 
