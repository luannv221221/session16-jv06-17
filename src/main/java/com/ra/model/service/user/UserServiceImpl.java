package com.ra.model.service.user;

import com.ra.model.dao.user.UserDAO;
import com.ra.model.dto.user.UserLoginDTO;
import com.ra.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public boolean register(User user) {
        // ma hoa mat khau
//        System.out.println(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        return userDAO.create(user);
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        User userLogin = userDAO.findUserByEmail(userLoginDTO.getEmail());
        // check email
        if(userLogin != null){
            // check bat
            if(BCrypt.checkpw(userLoginDTO.getPassword(),userLogin.getPassword())){
                return userLogin;
            }
        }
        return null;
    }
}
