# Todo list

## Description
This is a simple todo list application that uses Crud operations to manage a list of tasks. This backend uses a RESTful API to manage the crud operations to the tasks that are stored in a database.
It will also use frontend to interact with the backend to perform the crud operations and give the user a better experience instead of using  a browser or java console to interact with the backend.

## Pipeline process
This is what i used to in my Project
### GitHub Actions
- **Function**: GitHub Actions is used to build and test the application to ensure it's ready for deployment.
- **Workflow**: When a new push is made to the main branch in the GitHub repository, a GitHub Actions workflow is triggered to build and run tests on the application.
- note that github actions is not meant to deploy to aws, it is only used to build and test the application before creating a pipeline via aws to deploy the application to the cloud.
I used this so that i can identify any errors in the code before deploying it to the cloud.
### CodeBuild
- **Function**: CodeBuild takes the latest push from the GitHub repository and then builds the application according to the specifications defined in the buildspec file built into the codeBuild service. Here is the [BuildSpec](BuildSpec.md)
- like the description above, i used codebuild to listen to pushes to the main branch and then build the application and run tests on it to ensure that it is ready to be sent to codepipeline for deployment.
i created a custom buildspec file to define the build process and the commands that codebuild should run to build the application.

### CodePipeline
- **Function**: CodePipeline takes the built artifacts from CodeBuild and orchestrates the deployment process.
- **Pipeline Stages**: Configure different stages in the pipeline for building, testing, approval, and deploying the application.
- I created the codepipeline to listen to the codebuild service so that it can take the built artifacts and deploy them to the cloud. this is the final step in the pipeline process and it is the step that deploys the application to Elastic Beanstalk.

### Elastic Beanstalk
- **Function**: Elastic Beanstalk takes the backend code from the codepipeline and deploys it to the cloud.
- **Connection to Frontend**: The deployed application on Elastic Beanstalk is connected to the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side using Fetch, Post, Patch, and Delete requests.
- Elastic beanstalk is where i am hosting the application, i use the generated url and combine the spring boot endpoints to create a full url that has the crud operations that the frontend can use to interact with the backend.

This is the pipeline process that i used to deploy the application to the cloud, i used github actions to build and test the application and identify errors in the code, then i used codebuild to pull the latest push to the main branch and build the application and run tests on it, then i used codepipeline to listen to the codebuild and deploy the application to the cloud using elastic beanstalk where it is going to be hosted on.
## Technologies
- ***Java jdk 17***: This is the language that the application is written in.
- ***Spring Boot***: This is the framework that the application is built on.
- ***Maven***: This is the build tool that the application uses.
- ***AWS***: This is the cloud provider that the application will be deployed to.
- ***MongoDB***: This is the database that the application uses to store the tasks.

## installation and usage
- ***Installation***: This project will be hosted for a short period of time on the Elastic Beanstalk, when the project is live you can access the application via the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side.
Otherwise, you can clone this and the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend) side and run the application locally.
if you are using it locally you will be forced to change the url in the javascript files to the localhost url like so:
```javascript file
change from this
http://molndaltodolist-env.eba-ej3fe9gt.eu-north-1.elasticbeanstalk.com/todo/add
to this
http://localhost:5000/todo/add
```
+ ***Usage***: The application is simple to use, you can add a task, delete a task, update a task, and get all the tasks. The application is also connected to the [Frontend](https://github.com/Jafar-Hussein/AwsTodolist_Frontend)
so you can use the application via the frontend side instead of a browser.

## Thoughts
I think this was a learning experience for me, I have never used AWS before and I have never used a pipeline before so this was a great learning experience for me. Also learning to connect aws to the other projects gave me a better understanding of the importance of the pipeline and how it can be used to deploy applications to the cloud.
Working hands on with aws has given me a deeper knowledge of cloud services and how to deploy applications to the cloud.

## badges
![badmath](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![badmath](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![badmath](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

