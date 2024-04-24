package app.jagadeesh.spring.springHandson.userservice.implement;

import app.jagadeesh.spring.springHandson.Utils;
import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;
import app.jagadeesh.spring.springHandson.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImplement implements UserService {

    Utils util;

    @Autowired
    public UserServiceImplement(Utils util){
        this.util = util;
    }

    @Override
    public Map<String,Object> createUser(NewUserDetailsRequestModel userDetails,Map<String,UserRest> users){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setPassword(userDetails.getPassword());

        String userId = util.getRandomGeneratedUserId();
        returnValue.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId,returnValue);
        Map<String, Object> result = new HashMap<>();
        result.put("users", users);
        result.put("userId", userId);
        return result;
    }
}
