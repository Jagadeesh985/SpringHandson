package app.jagadeesh.spring.springHandson.ui.controller;

import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.request.UpdateUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;
import app.jagadeesh.spring.springHandson.ui.model.response.UserServiceException;
import app.jagadeesh.spring.springHandson.userservice.UserService;
import app.jagadeesh.spring.springHandson.userservice.implement.UserServiceImplement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    Map<String,UserRest> users;

    @GetMapping
    public String getUser(@RequestParam(value = "page",required = false) String page,@RequestParam (value = "limit",defaultValue = "50") int limit){
        return "Get user was called with page="+ page + " limit="+ limit;
    }

    @GetMapping(value = "/{userId}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

//        String name = null;
//        int len = name.length();
//        if(true) throw new UserServiceException("This is the custom service exception");

        if(users.containsKey(userId))
        {
            UserRest userDetails = users.get(userId);
            return new ResponseEntity<UserRest>(userDetails, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody NewUserDetailsRequestModel userDetails){
        UserRest returnValue = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
    }

    @PutMapping(value ="/{userId}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel updatedUserDetails){
        if(users.containsKey(userId)){
            UserRest userDetails = users.get(userId);
            userDetails.setFirstName(updatedUserDetails.getFirstName());
            userDetails.setLastName(updatedUserDetails.getLastName());
            users.put(userId,userDetails);
            return new ResponseEntity<UserRest>(userDetails,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
            users.remove(userId);
            return ResponseEntity.noContent().build();
    }
}
