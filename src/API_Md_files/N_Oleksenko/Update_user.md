# Test Design: *CWEB-1.3*

## Test Design Inputs

### Requirements

CWEB-1.3 Chatty allows to update user information

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And chatty server base URI: "http://chatty.telran-edu.de:8089" is set
And new user with random user name (length from 8 to 100 symbols included, only Latin letters)
and user <role>  is created
And new user is added to server via Post http method (endpoint "/api/auth/register, body)
And added user accessToken, refreshToken, expiration are returned
```

| role            |
|-----------------|
| "admin", "user" |

### Test Scenarios

#### Scenario Positive:
**CWEB-1.3** Verify user name can be updated
```gherkin
Given initial setup
When Autotest Framework updates user name via Put http method (endpoint "/api/users" + id, id
in path) from server
And Autotest Framework gets user via Get http method (endpoint "/api/me") from server
Then server returns updated user information: new name
And Autotest Framework compares new name with user name from server. Assert they're equal
```

### Test Clean Up
```gherkin
Given test scenario is completed
When Autotest Framework deletes added user via Delete http method, endpoint "/api/users" + id,
api_key in header "special-key"
Then user  is deleted
```
