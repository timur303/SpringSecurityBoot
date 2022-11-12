package kg.kadyrbekov.mapper;

import kg.kadyrbekov.dto.UserRequest;
import kg.kadyrbekov.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEditeMapper {

    public User create(UserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setPassword(userRequest.getPassword());
        user.setEnabled(user.isEnabled());
        return user;
    }

}
