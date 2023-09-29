package com.chatapp.controller;

import com.chatapp.dto.UserDTO;
import com.chatapp.dto.response.ApiResponse;
import com.chatapp.entities.UserEntity;
import com.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create new user
    @PostMapping("/")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {

        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //Update existing User
    @PutMapping("/{userId}") // path uri variable
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") Long uId) {
        UserDTO updatedUser = userService.updateUser(userDTO, uId);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete existing user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long uId) {
        userService.deleteUser(uId);

        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
//        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

    //Get All Users
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUser());
    }

    //Get User By Id (Single User)
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long uId) {

        UserDTO userById = userService.getUserById(uId);
        return ResponseEntity.ok(userById);
    }


}



