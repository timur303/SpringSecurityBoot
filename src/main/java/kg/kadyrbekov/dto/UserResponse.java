package kg.kadyrbekov.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private boolean enabled = true;

}
