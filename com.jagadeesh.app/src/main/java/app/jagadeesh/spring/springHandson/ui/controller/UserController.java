package app.jagadeesh.spring.springHandson.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page",required = false) String page,@RequestParam (value = "limit",defaultValue = "50") int limit){
        return "Get user was called with page="+ page + " limit="+ limit;
    }

    @GetMapping(value = "/{userId}")
    public String getUser(@PathVariable String userId){
        return "Get user was called with userId = "+userId;
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
