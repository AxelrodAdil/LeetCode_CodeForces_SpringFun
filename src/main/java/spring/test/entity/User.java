package spring.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // the keyword USER is reserved keyword in PostgreSQL

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "user_age")
    private Long userAge;
}
