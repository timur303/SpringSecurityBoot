package kg.kadyrbekov.model.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence"
            , sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private boolean enabled = true;

    @ManyToMany(targetEntity = Role.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
            , fetch = FetchType.EAGER)
    @JoinTable(name = "roles_users", joinColumns = {@JoinColumn(name = "users_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    List<Role> roleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role:roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
