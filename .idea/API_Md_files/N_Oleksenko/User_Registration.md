# Test Design: *CWEB-1.1*

## Test Design Inputs

### Requirements

Chatty allows to register the user

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And chatty server base URI: "http://chatty.telran-edu.de:8089" is set
And user does not exist 
```

| role            |
|-----------------|
| "admin", "user" |

### Test Scenarios

#### Scenario Positive:
**CWEB-1.1** Verify the creation of user with minimal valid symbols
```gherkin
Given initial setup
When Autotest Framework create user to server via Post http method (endpoint "/api/auth/register") with form data at server
Then server returns accessToken, refreshToken, expiration

```

