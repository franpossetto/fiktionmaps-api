package com.mapToFiction.mapToFiction.service.dto;

import com.mapToFiction.mapToFiction.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String externalUserId;
    private String name;
    private String email;
    private String password;
    private User.Role role;
    private List<SceneDTO> scenes;
}

