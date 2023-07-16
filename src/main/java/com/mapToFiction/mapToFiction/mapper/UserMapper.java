package com.mapToFiction.mapToFiction.mapper;

import com.mapToFiction.mapToFiction.model.Location;
import com.mapToFiction.mapToFiction.model.User;
import com.mapToFiction.mapToFiction.service.dto.LocationDTO;
import com.mapToFiction.mapToFiction.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
