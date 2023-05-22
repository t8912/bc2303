## Steps to create Maven Sprint Boot Project
### Step 1: Create project in VSCode
#### - Shift + CMD + P -> Type "spring create maven"
#### - group id -> com.codewave.demo
#### - artifict id -> demo-initial-practice
#### - Dependency -> lombok, devTools, Spring Web

### Step 2: Remove unnecessary setting files
#### - remove .mvn/ HELP.md/ mvnw/ mvnw.cmd
#### - In main & test, remove unnecessary directory "demoinitialpractice". Finally, package become "com.codewave.demo".
#### - In main/resources, remove folder "static" & "templates"

### Step 3: Health Check pom.xml, ensure the setting is same as your input
#### Compile & install to make sure everything is correct
##### Command: mvn clean install

### Step 4: If compile & install success, start to code.
#### 4.1 Create controller class & interface (AbcController.java & AbcOperations.java)
##### /controller/impl/AbcController.java -> a class to implement interface
##### /controller/AbcOperations.java -> interface

#### 4.2 Add abstract method in the controller interface and the implementation in controller class
##### In the implementation, remember to add @Override

#### 4.3 Add Add @GetMapping for the URI in controller interface
#### Add @Controller, @ResponseBody, @RequestMapping in Controller class
#### For RequestMapping, basepath + version, /demo/practice/api/v1
#### Compile & Install

#### 4.4 Test by Postman
##### Start your local Spring Boot Server by command "mvn spring-boot:run"
##### Execute Request in Postman
###### http://localhost:8080/demo/practice/api/v1/greeting

#### 4.5 Change the port for the application
##### Revise /main/resources/application.properties to application.yml
##### Add "server:" & "port: 8081" to update the default port 8080 to 8081

### Step 5: Add Types in model folder
#### Lombok for every types, @Data (aware the usage of the set of annotations)
#### @AllArgsConstructor, @NoArgsConstructor, @Builder