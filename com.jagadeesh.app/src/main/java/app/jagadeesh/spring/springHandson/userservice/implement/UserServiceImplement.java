package app.jagadeesh.spring.springHandson.userservice.implement;

import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;
import app.jagadeesh.spring.springHandson.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImplement implements UserService {

    Map<String,UserRest> users;

    @Override
    public UserRest createUser(NewUserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setPassword(userDetails.getPassword());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId,returnValue);
        return returnValue;
    }
}
