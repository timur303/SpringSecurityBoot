package kg.kadyrbekov.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rols")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_sequence")
    @SequenceGenerator(name = "role_sequence",sequenceName = "role_seq",allocationSize = 1)
    private Long id;
    private String roleName;
    private String password;
}
