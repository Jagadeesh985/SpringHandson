package app.jagadeesh.spring.springHandson.ui.controller;

import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page",required = false) String page,@RequestParam (value = "limit",defaultValue = "50") int limit){
        return "Get user was called with page="+ page + " limit="+ limit;
    }

    @GetMapping(value = "/{userId}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Jagadeesh");
        returnValue.setLastName("Monangi");
        returnValue.setEmail("Jaggu@gmail.com");
        returnValue.setPassword("1234");
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }


    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody NewUserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setPassword(userDetails.getPassword());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
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
