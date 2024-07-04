# Test Design: *Update_Post*

## Test Design Inputs

### Requirements

Chatty allows the user to edit posts

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And chatty server base URI: "http://chatty.telran-edu.de:8989" is set
And new user with valid name (length from 3 to 20 symbols included, only Latin letters) is created
And new user is added to server via Post http method (endpoint "/api/auth/register", body)
And added user id is returned
And user create new post via Post http method (endpoint "/api/posts", body) to server
And the post is created
And added post id is returned
```
|status|                             
|-----------------------------------|
|"OK", "Bad Request", "Unauthorized"|

### Test Scenarios

#### Scenario Positive:
**Update_Post** Verify post can be updated by user
```gherkin
Given initial setup
When Autotest Framework updates post via Put http method (endpoint "/api/posts", body) with form data at server
Then server returns updated post: new data and new status
And Autotest Framework compares new post with post  from server. Assert they're equal  ?????  нужны ли эти строки?
And Autotest Framework compares new status with post status from server. Assert they're equal  ??????   нужны ли эти строки?
```

### Test Clean Up
```gherkin
Given test scenario is completed
When Autotest Framework deletes added post via Delete http method, endpoint "/api/users/" + id
Then post is deleted
When Autotest Framework deletes added user via Delete http method, endpoint "/api/posts/" + id
Then user is deleted
```
