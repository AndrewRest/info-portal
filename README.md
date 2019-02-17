# Deployment model

## Requirements

- Microservices developed on top of Vert.x
- Communication between services should exist
- Orchestartion should be done via Minikube with Istio/Envoy

## Business logic 
User need to get information for entertaiment section. 
User will get 1 random interesting fact and weather.

## Communication model



```bash
ffmpeg -threads 1 -re -f avfoundation -i "1:0" -f rawvideo -s 1920x1080 -r 30 -an -pix_fmt yuv420p - | \
ffmpeg -threads 1 -f rawvideo -pix_fmt yuv420p -s 1920x1080 -r 30 -an -i - -an -c:v libx264 \
-vprofile baseline -pass 1 -preset ultrafast -g 5 -b:v 10M -f mpegts udp://192.168.0.101:1234
```
