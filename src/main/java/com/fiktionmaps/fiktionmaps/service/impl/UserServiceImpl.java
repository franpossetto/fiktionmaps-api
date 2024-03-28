package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.config.JwtService;
import com.fiktionmaps.fiktionmaps.mapper.UserMapper;
import com.fiktionmaps.fiktionmaps.model.User;
import com.fiktionmaps.fiktionmaps.repository.UserRepository;
import com.fiktionmaps.fiktionmaps.service.UserService;
import com.fiktionmaps.fiktionmaps.service.dto.UserDTO;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, JwtService jwtService){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public UserDTO create(UserDTO userDto){
        User user = userMapper.toEntity(userDto);
        //user.setEmailVerified(true);
        User createdUser = userRepository.save(user);
        return userMapper.toDto(createdUser);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDto){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found for id " + id);
        }
        User user = userMapper.toEntity(userDto);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id){
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found for id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDTO getCurrentUser(String externalUserId) {
        return userMapper.toDto(userRepository.findByExternalUserId(externalUserId));
    }

    @Override
    public UserDTO getUserFromToken(String token) {
        String firebaseId = null;
        try {
            firebaseId = jwtService.extractUserId(token);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
        return userMapper.toDto(userRepository.findByExternalUserId(firebaseId));
    }
}
