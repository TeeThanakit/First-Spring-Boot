package com.example.mysprintboot.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRoleDto {
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private List<Long> roleIds;
}
