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

    @PostMapping("register")
    public ResponseEntity<BaseResponse> postUser(@RequestBody UserRequest userRequest, BindingResult bindingResult) {
        requestValidation.validate(userRequest, bindingResult);
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(BaseResponse.builder().status(400).data(ConstantConfiguration.ERROR).build());
        BaseResponse baseResponse = userFacade.createUser(userRequest);
        return ResponseEntity.status(baseResponse.getStatus()).body(baseResponse);
    }
}
