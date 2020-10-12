# Fluentd multiline logging with Java (EFK stack) 
## The purpose
The goal of this example project is to demonstrate a basic EFK setup 
that supports multiline logs in a Kubernetes environment.

The example comes with a fully functioning EFK setup and an
example Java, Spring Boot based application that produces
multiline logs and exception stacktraces.

The relevant article can be found here: https://arnoldgalovics.com/java-and-spring-boot-multiline-log-support-for-fluentd-efk-stack/

## Running the example
Build the docker image and the application
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
In case of minikube, set up tunneling since Kibana is exposed
via a LoadBalancer: `minikube tunnel`

Then access Kibana at the external IP of the LoadBalancer and the 5601 port.
