# Build Specification
```yml
version: 0.2

phases:
  install:
    runtime-versions:
      java: corretto17
  pre_build:
    commands:
      - echo Nothing to do in the pre_build phase...
  build:
    commands:
      - echo Build started on `date`
      - mvn install
      - mvn clean package
  post_build:
    commands:
      - echo Build completed on `date`
artifacts:
  files:
    - target/webservice-app.jar
  discard-paths: yes
```
this is the build spec i used in aws codebuild to build the application. it is a simple build spec that installs the java runtime, then it runs the maven install and maven clean package commands to build the application. after that it creates an artifact of the jar file that is created in the target folder.