package com.mfs.auth.controller.v1;

import com.mfs.auth.entity.UserModel;
import com.mfs.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUser() {
        return ResponseEntity.ok().body(userService.readAllUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable final int id) {
        return ResponseEntity.ok().body(userService.readUserById(id));
    }

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok().body(userService.createUser(userModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> putUser(@PathVariable final int id, @RequestBody final UserModel userModel) {
        return ResponseEntity.ok().body(userService.updateUser(userModel, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable final int id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }
}
