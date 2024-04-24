package app.jagadeesh.spring.springHandson.userservice;

import app.jagadeesh.spring.springHandson.ui.model.request.NewUserDetailsRequestModel;
import app.jagadeesh.spring.springHandson.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(NewUserDetailsRequestModel userDetails);
}
