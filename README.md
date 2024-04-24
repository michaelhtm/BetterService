## Info for getting it to run

### Hardcoded ports

#### Customer
Customer MVC: 8082  
Customer Microservice: 8083  

#### Scheduling
MVC: 8010
Microservice: 8011

#### Employee
MVC: 8884
Microservice: 8882

### JDK versions

Scheduling: 21  
Customer: 17  
(https://www.oracle.com/java/technologies/downloads/)  
(https://code.visualstudio.com/docs/java/java-project#_configure-runtime-for-projects)  

## Documentation

### Customer microservice usage

Find customers by ID or name:  
http://localhost:8083/customers?id=1  
http://localhost:8083/customers?name=John+Cena  

Returns JSON (Springboot default when using @RestController or @ResponseBody):

```
{"id":1,"name":"John Cena"}
```
or
```
{"id":-1,"name":"NONE"}
```
if the customer does not exist.

