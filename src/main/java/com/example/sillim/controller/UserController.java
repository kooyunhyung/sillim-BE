package com.example.sillim.controller;

import com.example.sillim.dto.ResponseDto;
import com.example.sillim.entity.Board;
import com.example.sillim.entity.User;
import com.example.sillim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sillim")
public class UserController {
    private final UserService userService;

    // Login (user)
    @PostMapping("/user/login")
    public ResponseDto loginUser(@RequestBody User userParam) {
        try {
            Optional<User> user = userService.findByLogin(userParam);
            if (user.isPresent()) {
                return new ResponseDto<>(200, user);
            } else {
                return new ResponseDto<>(404);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(500);
        }
    }


    // Create (user)
    @PostMapping("/user")
    public ResponseDto createUser(@RequestBody User userParam) {
        try {
            if (userParam != null) {
                userService.save(userParam);
                return new ResponseDto<>(200, Optional.of(userParam));
            } else {
                return new ResponseDto<>(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(500);
        }
    }

    // Read All (user)
    @GetMapping("/user")
    public Optional<List<User>> getUsers() {
        try {
            Optional<List<User>> users = userService.findAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Read One (user)
    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable int id) {
        try {
            Optional<User> user = userService.findOne(id);
            if (user.isPresent()) {
                return new ResponseEntity<>(new ResponseDto<>(200, user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update (user)
    @PostMapping("/user/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        try {
            userService.update(id, updatedUser);

            return new ResponseEntity<>(new ResponseDto<>(200, Optional.of(updatedUser)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete (user)
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable int id) {
        try {
            Optional<User> existingUser = userService.findOne(id);
            if (existingUser.isPresent()) {
                userService.delete(id);
                return new ResponseEntity<>(new ResponseDto<>(200), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
