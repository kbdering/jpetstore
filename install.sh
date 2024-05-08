kubectl apply -f jpetstore-deployment.yaml
kubectl apply -f jpetstore-service.yaml
kubectl create configmap jpetstore-sql --from-file=jpetstore-6/src/main/resources/database/
kubectl create configmap users-sql --from-file=user-load.sql
kubectl apply -f mysql-pvc.yaml
kubectl apply -f mysql-service.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f load-db-data.yaml
kubectl apply -f load-user-data.yaml
kubectl apply -f nginx-configmap.yaml
kubectl apply -f nginx-deployment.yaml
kubectl apply -f nginx-service.yaml

