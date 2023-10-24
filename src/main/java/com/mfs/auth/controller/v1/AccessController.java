package com.mfs.auth.controller.v1;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.access.AccessRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/access")
public class AccessController extends BaseController {
    @PostMapping("generate")
    public ResponseEntity<Object> generateToken(@RequestBody final AccessRequest accessRequest, BindingResult bindingResult) {
        userModelValidation.validate(accessRequest, bindingResult);
        if (bindingResult.hasErrors()) return ResponseEntity.badRequest().body(ConstantConfiguration.ERROR);
        return ResponseEntity.ok().body(accessFacade.createAccess(accessRequest));
    }
}
