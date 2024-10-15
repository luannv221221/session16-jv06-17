package com.ra.model.service.user;

import com.ra.model.dto.user.UserLoginDTO;
import com.ra.model.entity.User;

public interface UserService {
    boolean register(User user);
    User login(UserLoginDTO userLoginDTO);

}
