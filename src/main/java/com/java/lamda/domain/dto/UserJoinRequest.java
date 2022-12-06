package com.java.lamda.domain.dto;

import com.java.lamda.domain.User;
import com.java.lamda.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinRequest {
    private String userName;
    private String password;
    private UserRole userRole;

   /* public User toEntity(String password) {
        return User.builder()
                .userName(this.userName)
                .password(password)
                .userRole(this.userRole);
    }*/
}
