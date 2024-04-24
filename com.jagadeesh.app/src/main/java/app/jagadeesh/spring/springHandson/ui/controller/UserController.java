package app.jagadeesh.spring.springHandson.ui.controller;

import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page",required = false) String page,@RequestParam (value = "limit",defaultValue = "50") int limit){
        return "Get user was called with page="+ page + " limit="+ limit;
    }

    @GetMapping(value = "/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Jagadeesh");
        returnValue.setLastName("Monangi");
        returnValue.setEmail("Jaggu@gmail.com");
        returnValue.setPassword("1234");
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }


    @PostMapping
    public String createUser(){
        return "Create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete user was called";
    }
}
