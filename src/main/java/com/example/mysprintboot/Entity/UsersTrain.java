package com.example.mysprintboot.Entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USERS_TRAIN")
public class UsersTrain {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seqence")
    @SequenceGenerator(name = "user_sequnce", sequenceName = "user_seq_sequance", initialValue = 1,allocationSize = 1)

    private long id;
    //    map col in DB to model name = "name in DB"
    @Column(name="firstname")
    private String firstname;

    private String lastname;

    private int age;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
