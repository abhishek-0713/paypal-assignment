# PayPal-assignment
### PayPal Associate Software Engineer Coding Assignment


## Tech Stack
- Java
- AWS
- Spring Boot
- MySQL
- Maven


## API Endpoints

- Create Sprint
- Method : PostMapping
- Endpoint URL
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/sprint
```

- Add Task To Sprint
- Method : PutMapping
- Endpoint URL 
``` 
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/task 
```


- Change Assignee
- Method : PutMapping
- Endpoint URL  
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/change/assignee
```


- Change Status
- Method : PutMapping
- Endpoint URL 
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/task/changeStatus
```


- Get All Tasks By SprintId
- Method : GetMapping
- Endpoint URL  
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/tasks/sprintId
```


- Get All Tasks By AssigneeId
- Method : GetMapping
- Endpoint URL 
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/tasks/assigneeId
```


- Get All Sprints
- Method : GetMapping
- Endpoint URL  
```
http://paypal-env.eba-rfzrbmqg.ap-northeast-1.elasticbeanstalk.com/paypal/sprints
```
