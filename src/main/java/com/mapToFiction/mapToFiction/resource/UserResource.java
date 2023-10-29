package com.mapToFiction.mapToFiction.resource;

import com.mapToFiction.mapToFiction.service.UserService;
import com.mapToFiction.mapToFiction.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        UserDTO result = userService.createUser(userDTO);
        return ResponseEntity.created(new URI("/api/users/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        UserDTO result = userService.updateUser(userDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{externalUserId}")
    public ResponseEntity<UserDTO> getCurrentUser(@PathVariable String externalUserId) {
        UserDTO user = userService.getCurrentUser(externalUserId);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        }

        return ResponseEntity.notFound().build();

    }
}
