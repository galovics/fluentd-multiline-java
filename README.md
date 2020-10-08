# Fluentd multiline logging with Java (EFK stack) 
## The purpose


## Running the example
First of all the example Spring Boot application needs to be compiled
```bash
$ ./gradlew clean build
```
Then you have to build the docker image
```bash
$ docker build -t fluentd-multiline-java:latest .
```
Side note, if you are building for a minikube environment, you can issue
the `eval $(minikube docker-env)` command to build the image for the
K8S registry.

The next thing is to deploy the application to Kubernetes
```bash
$ kubectl apply -f k8s/fluentd-multiline-java-deployment.yaml
```
Then deploy the EFK stack
```bash
$ kubectl apply -f k8s/efk-stack.yaml
```
