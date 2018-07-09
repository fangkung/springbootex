# Spring Boot Example
User Management Application using static data
- Spring boot 1.5.2
- Thymeleaf

# Table of Contents
* [Quick Start](#quick-start)
* [File Structure](#file-structure)

### Quick Start
```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone --depth 1 https://github.com/fangkung/springbootex.git

# change directory to our repo
cd springbootex

# install the repo with mvn
mvn install

# start the server
mvn spring-boot:run

# the app will be running on port 8080
# User for login - user:Sam - password:30
```

### File Structure
```
springbootex
 ├──src                                                    * our source files
 │   ├──main
 │   │   ├──java.com.example
 │   │   │   ├──controller
 │   │   │   │   └──DemoController.java                     * Controller class route path.
 │   │   │   ├──dao
 │   │   │   │   ├──UserDao.java                            * Interface for manage static data.
 │   │   │   │   └──UserDaoImpl.java                        * Imprementation class.
 │   │   │   ├──model
 │   │   │   │   └──User.java                               * User model.
 │   │   │   ├──server
 │   │   │   │   └──service
 │   │   │   │       ├──UserService.java                    * Interface business user service.
 │   │   │   │       └──UserServiceImpl.java                * Imprementation class.
 │   │   │   └──DemoApplication.java                        * Application main enterance.
 │   │   └──recources
 │   │       ├──templates/demo                              * Static assets (thymeleaf&html templates).
 │   │       │   ├──adduser.html                            * Add user page.
 │   │       │   ├──edituser.html                           * Edit user page.
 │   │       │   ├──index.html                              * First index page.
 │   │       │   ├──listuser.html                           * List user page.
 │   │       │   └──login.html                              * Login page.
 │   │       └──application.properties                      * Application variables are configured here.
 │   └──test                                                * Junit test folder.
 └──pom.xml                                                 * What maven uses to manage it's dependencies.
```
___

# License
 [MIT](/LICENSE)