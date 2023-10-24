package com.mfs.auth.service.access;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.access.AccessModel;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessServiceImpl implements AccessService {
    @Autowired
    AccessRepository accessRepository;

    @Override
    public String createAccess(AccessModel accessModel) {
        try {
            accessRepository.save(accessModel);
        } catch (Exception e) {
            return ConstantConfiguration.ERROR;
        }
        return ConstantConfiguration.SUCCESS;
    }
}
