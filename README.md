# Deployment model

## Requirements

- Microservices are developed on top of Vert.x
- Communication between services should exist
- Orchestartion should be done via Minikube with Istio/Envoy

## Business logic 
User need to get information for entertainment section. 
User will get 1 random interesting fact and weather.

## Communication model
![vertx](https://user-images.githubusercontent.com/12434689/52917359-815c4a00-32fb-11e9-8ba9-a27680ea99d8.png)

User flow:
#User call Info service for getting info for entertainment section
#Info service call Weather service to return cuttern tempereture and short description

## Technical details

### Stack
As for requirements 2 Services will be implemented on top of Vert.x (Java 1.8)
Docker is used as container provider
Minikube/Kubernetes + Istio is for deployment on local environment

### Architecture
Rest API is provided by each service. Communication from service to service is also via REST.

## Deployment
![vertx2](https://user-images.githubusercontent.com/12434689/52917617-b4eca380-32fe-11e9-9dc2-8520560191cb.png)

Startdart for Istio deployment architecture is used.
Each service has additional container called Envoy. It's used as a proxy to communicate between services and use service mesh.
For example, Grafana can be used as monitoring application because we have all needed statictics provided by Istio.

Was done:
1) Implemented 2 Rest services on top of Vert.x
2) Created images for each of them and pused to Docker hub
3) Installed Minikube + Istio environment
4) Created Kubernetes deployment schema 
5) Created Tech design doc
