package app.jagadeesh.spring.springHandson.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "First name cannot be null")
    @Size(min=2,message = "First name size should be greater than or equal to 2")
    private String firstName;

    @NotNull
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
