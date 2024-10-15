package com.ra.controller;

import com.ra.model.dto.user.UserLoginDTO;
import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String register(Model model, User user){
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register")
    public String handlerRegister(@ModelAttribute("user") User user){
        if(userService.register(user)){
            return "redirect:/";
        }
        return "register";
    }
    @GetMapping("/login")
    public String login(Model model, UserLoginDTO userLoginDTO){
        model.addAttribute("user",userLoginDTO);
        return "login";
    }
    @PostMapping("/login")
    public String handlerLogin(@ModelAttribute("user") UserLoginDTO userLoginDTO,
                               HttpSession session){
        User userLogin = userService.login(userLoginDTO);
        if(userLogin != null){
            // luu vao Session
            session.setAttribute("userLogin",userLogin);
            return "redirect:/";
        }
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userLogin");
        return "redirect:/";
    }
}
