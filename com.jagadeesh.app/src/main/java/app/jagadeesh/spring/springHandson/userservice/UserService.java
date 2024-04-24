package app.jagadeesh.spring.springHandson.userservice;

import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;

import java.util.Map;

public interface UserService {
    Map<String, Object> createUser(NewUserDetailsRequestModel userDetails, Map<String,UserRest> users);
}
