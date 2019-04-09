# PENCAS.UY - ORGANIZATION

## Description

PencasUY Core Application runs the core environment for the plattform in OpenShift-Online

## Content

* backend-web ... Web project for Backend
* datatype ... Datatypes project
* ear ... Ear project
* frontend-web ... Web project for Frontend
* frontend-web-rest ... Rest project for Mobile App
* logic ... Logic project (ejb)
* logic-client ... Logic client project to be used in web project (jar)
* persistance ... Persistance project (jpa)
* persistance-client ... Persistance client project to be used in logic project (jar)
* pom.xml ... Main project configuration
* secret.yaml ... OpenShift secret file to consume gitlab.fing.edu.uy
* project.yaml ... The main project file

## Instalation

1. Create a project in OpenShift
The name MUST be pencasuy-organization
```
oc new-project pencasuy-organization
```
2. Create the secret to consume the git project
```
oc create -f secret.yaml
```
3. Create the project processing the template file
```
oc process -f project.yaml | oc create -f -
```
This last step, builds the source code with the s2i strategy, adding the env parameters and push the result image to the registry.
Then runs a new deploy for that image.
