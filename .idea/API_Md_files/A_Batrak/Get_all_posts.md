# Test Design: *Get all posts*

## Test Design Inputs

### Requirements

Chatty allows to find an existing information about all Posts

## Test Procedure

### Test Setup

```gherkin
Given Autotest Framework is launched
And social networks server base URI: "http://chatty.telran-edu.de:8089" is set
And all posts  are found
And all posts are added to server via Post http method (endpoint "GET /api/posts/{id}", body)
And added post id is returned
```

|status|
|-----------------------------|
| "OK", "Bad Request", "Unauthorized" |

### Test Scenarios

#### Scenario Positive:
**Get_all_posts** Verify user can found all posts
```gherkin
Given initial setup
When Autotest Framework gets post via Get http method (endpoint "GET /api/posts/{id}", id
in path) from server
Then server returns posts information
And  Autotest Framework compares information about created in precondition post and
returned all posts  from precondition. Assert they're equal
```

