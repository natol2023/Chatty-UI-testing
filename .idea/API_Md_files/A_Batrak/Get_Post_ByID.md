
# Test Design: *Get Post By Id*

## Test Design Inputs

### Requirements

 Chatty allows to find an existing information about Post by Id

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And social networks server base URI: "http://chatty.telran-edu.de:8089" is set
And new post with random Id is found
and random <status>  is created
And new post is added to server via Post http method (endpoint "GET /api/posts/{id}", body)
And added post id is returned
```

| status           |
|------------------|
| "OK", "Bad Request", "Unauthorized" |

### Test Scenarios

#### Scenario Positive:
**Get_Post_ByID** Verify user can  found by Post id
```gherkin
Given initial setup
When Autotest Framework gets post via Get http method (endpoint "/api/posts/{id}", id
in path) from server
Then server returns post information
And  Autotest Framework compares information about created in precondition post and
returned post by id from precondition. Assert they're equal
```


