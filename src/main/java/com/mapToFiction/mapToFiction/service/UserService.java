package com.mapToFiction.mapToFiction.service;

import com.mapToFiction.mapToFiction.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDto);
    UserDTO updateUser(UserDTO userDto, Long id);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();

}
