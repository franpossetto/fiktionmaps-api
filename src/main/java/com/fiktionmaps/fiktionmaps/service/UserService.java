package com.fiktionmaps.fiktionmaps.service;


import com.fiktionmaps.fiktionmaps.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO cityDTO);

    UserDTO update(Long id, UserDTO cityDTO);

    void delete(Long id);

    List<UserDTO> getAll();

    UserDTO getCurrentUser(String externalUserId);

}
