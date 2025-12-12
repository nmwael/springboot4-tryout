# springboot4-tryout
demo repo

_Build project with maven clean install_

```shell
mvn -Pnative clean package
``` 
local test

```shell
java -Dspring.aot.enabled=true -jar /workspaces/springboot4-tryout/target/demo-0.0.1-SNAPSHOT.jar
``` 

## Build

### Buildpacks

Then use buildpacks to generate minimal image
```shell
pack build --builder paketobuildpacks/builder-noble-java-tiny \
    --docker-host inherit \
    --path target/demo-0.0.1-SNAPSHOT.jar \
    --env 'BP_NATIVE_IMAGE=true' \
    demo:0.0.1-SNAPSHOT
``` 

### GraalVM

Install GraalVm
```shell
sdk install java 25-graal
``` 
 
 mvn -Pnative native:compile


## Documentation

[Spring Restdocs](https://docs.spring.io/spring-restdocs/docs/current/reference/htmlsingle/)


## Inspect file system

list stopped containers
> podman  ps -a

> export / copy content
podman cp 1f2c55b9ef1a:/ ./test