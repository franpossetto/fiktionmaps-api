package com.mapToFiction.mapToFiction.service.impl;

import com.mapToFiction.mapToFiction.mapper.UserMapper;
import com.mapToFiction.mapToFiction.model.User;
import com.mapToFiction.mapToFiction.repository.UserRepository;
import com.mapToFiction.mapToFiction.service.UserService;
import com.mapToFiction.mapToFiction.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDto){
        User user = userMapper.toEntity(userDto);
        User createdUser = userRepository.save(user);
        return userMapper.toDto(createdUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found for id " + id);
        }
        User user = userMapper.toEntity(userDto);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id){
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found for id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
