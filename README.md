# Todo list

## Description
This is a simple todo list application that uses Crud operations to manage a list of tasks. This backend uses a RESTful API to manage the crud operations to the tasks that are stored in a database.

## Pipeline process
### GitHub Actions
- **Function**: GitHub Actions is used to build and test the application to ensure it's ready for deployment.
- **Workflow**: When a new push is made to the main branch in the GitHub repository, a GitHub Actions workflow is triggered to build and run tests on the application.
- **Significance**: GitHub Actions serves as the initial step to verify code quality before it's passed on to AWS services for deployment.
- note that github actions is not meant to deploy to aws, it is only used to build and test the application before creating a pipline via aws to deploy the application to the cloud.
### CodeBuild
- **Function**: CodeBuild takes the latest push from the GitHub repository and then builds the application according to the specifications defined in the buildspec file built into the codeBuild service. Here is the [BuildSpec](BuildSpec.md) 
- **Build Specification**: A build specification (buildspec.yml) defines the build process, including commands to install dependencies, build, and test the application.
- **Compilation and Testing**: CodeBuild compiles the code, runs tests, and generates build artifacts to be used in the next step of the CI/CD process.

### CodePipeline
- **Function**: CodePipeline takes the built artifacts from CodeBuild and orchestrates the deployment process.
- **Pipeline Stages**: Configure different stages in the pipeline for building, testing, approval, and deploying the application.
- **Integrations**: CodePipeline can integrate with other AWS services and external tools to automate the entire CI/CD process.

### Elastic Beanstalk
- **Function**: Elastic Beanstalk takes the backend code from the codepipeline and deploys it to the cloud.
- **Scalability and Management**: Elastic Beanstalk automatically manages the infrastructure and can scale resources based on the application load.
- **Connection to Frontend**: The deployed application on Elastic Beanstalk is connected to the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side using Fetch, Post, Patch, and Delete requests.

## Technologies
- ***Java jdk 17***: This is the language that the application is written in.
- ***Spring Boot***: This is the framework that the application is built on.
- ***Maven***: This is the build tool that the application uses.
- ***AWS***: This is the cloud provider that the application will be deployed to.
- ***MongoDB***: This is the database that the application uses to store the tasks.

## installation and usage
- ***Installation***: This project will be hosted for a short period of time on the Elastic BeansTalk, when the project is live you can access the application via the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side.
Otherwise you can clone this and the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side and run the application locally.
if you are using it locally you will be force to change the url in the javascript files to the localhost url like so:
```javascript file
change from this
http://molndaltodolist-env.eba-ej3fe9gt.eu-north-1.elasticbeanstalk.com/todo/add
to this
http://localhost:5000/todo/add
```
+ ***Usage***: The application is simple to use, you can add a task, delete a task, update a task, and get all the tasks. The application is also connected to the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend)
so you can use the application via the frontend side instead of a browser.

## Thougths
I think this was a learning experience for me, I have never used AWS before and I have never used a pipeline before so this was a great learning experience for me. Also learning to connect aws to the other projects gave me a better understanding of the imortance of the pipeline and how it can be used to deploy applications to the cloud.
Working hands on with aws has me a deeper knowledge of cloud services and how to deploy applications to the cloud.

## badges
![badmath](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![badmath](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![badmath](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

