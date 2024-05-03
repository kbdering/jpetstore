git clone https://github.com/mybatis/jpetstore-6
cp pom.xml jpetstore-6/
cp applicationContext.xml jpetstore-6/src/main/webapp/WEB-INF/
docker build -t localhost:5200/my-jpetstore jpetstore-6/
docker push localhost:5200/my-jpetstore 
