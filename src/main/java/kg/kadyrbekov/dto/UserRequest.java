package kg.kadyrbekov.dto;

import lombok.Data;

import javax.validation.constraints.Email;
@Data
public class UserRequest {

    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private String newName;
}
