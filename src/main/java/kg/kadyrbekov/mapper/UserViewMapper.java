package kg.kadyrbekov.mapper;

import kg.kadyrbekov.dto.UserResponse;
import kg.kadyrbekov.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserViewMapper {

        public UserResponse viewMapper(User user){
            if(user== null){
                return null;
            }
            UserResponse userResponse = new UserResponse();
            if(user.getId()!=null){
                userResponse.setId(Long.valueOf(String.valueOf(user.getId())));
            }

            userResponse.setId(user.getId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setEmail(user.getEmail());
            userResponse.setPassword(user.getPassword());
            userResponse.setAddress(user.getAddress());
            userResponse.setEnabled(user.isEnabled());
            return userResponse;
        }
}
