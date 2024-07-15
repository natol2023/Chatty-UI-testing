# Test Design: *Create_Post*

## Test Design Inputs

### Requirements

Chatty allows the user to create a new post

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And chatty server base URI: "http://chatty.telran-edu.de:8989" is set
And new user with valid name (length from 3 to 20 symbols included, only Latin letters) is created
And new user is added to server via Post http method (endpoint "/api/auth/register", body)
And added user id is returned
```
|status|                             
|-----------------------------------|
|"OK", "Bad Request", "Unauthorized"|

### Test Scenarios

#### Scenario Positive:
**Create_Post** Verify user can create a new post
```gherkin
Given initial setup
When Autotest Framework create new post via Post http method (endpoint "/api/posts", body) to server
Then the post is created
```

### Test Clean Up
```gherkin
Given test scenario is completed
When Autotest Framework deletes added post via Delete http method, endpoint "/api/users/" + id
Then post is deleted
When Autotest Framework deletes added user via Delete http method, endpoint "/api/posts/" + id
Then user is deleted
```
