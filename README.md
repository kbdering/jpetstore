JPetstore for Kubernetes Deployments 

Core Changes: 
  - MySQL support
  - Custom Container build
  - Moveout from mvn cargo to tomcat container for runtime

Prerequisites (beyond standard prerequisits for Mybatis JPetstore: 
 - MySQL database (can be installed on Kubernetes)
 - Local docker-registry

./build_jpetstore.sh builds the artifact with modified parameters and pushes it to the local registry. Currently the registry address is hardcoded.
To use your own registry, modify build_jpetstore.sh and the jpetstore-deployment as well 

./install.sh deploys all the services to Kubernetes to a default namespace. Default replicas is 3



