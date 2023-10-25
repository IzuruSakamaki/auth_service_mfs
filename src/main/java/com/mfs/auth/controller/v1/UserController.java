package com.mfs.auth.controller.v1;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.user.UserRequest;
import com.mfs.auth.facade.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController extends BaseController {
    @Autowired
    UserFacade userFacade;

    @GetMapping("accessed")
    public ResponseEntity<String> trialAccessed() {
        return ResponseEntity.ok().build();
    }

    @PostAuthorize("hasAuthority('GENERAL')")
    @GetMapping("denied")
    public ResponseEntity<String> trialDenied() {
        return ResponseEntity.ok().build();
    }


//    @GetMapping
//    public ResponseEntity<List<UserModel>> getAllUser() {
//        return ResponseEntity.ok().body(userService.readAllUser());
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<UserModel> getUserById(@PathVariable final int id) {
//        return ResponseEntity.ok().body(userService.readUserById(id));
//    }

//    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping("register")
    public ResponseEntity<BaseResponse> postUser(@RequestBody UserRequest userRequest, BindingResult bindingResult) {
        userModelValidation.validate(userRequest, bindingResult);
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(BaseResponse.builder()
                .data(ConstantConfiguration.ERROR).timestamp(System.currentTimeMillis()).build());
        return ResponseEntity.ok().body(userFacade.createUser(userRequest));
    }

//    @PutMapping("{id}")
//    public ResponseEntity<String> putUser(@PathVariable final int id, @RequestBody final UserModel userModel, BindingResult bindingResult) {
//        userModelValidation.validate(userModel, bindingResult);
//        if (bindingResult.hasErrors()) return ResponseEntity.badRequest().body(ConstantConfiguration.ERROR);
//        return ResponseEntity.ok().body(userService.updateUser(userModel, id));
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable final int id) {
//        return ResponseEntity.ok().body(userService.deleteUser(id));
//    }
}
