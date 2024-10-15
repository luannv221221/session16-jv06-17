package com.ra.controller.admin;

import com.ra.model.dto.user.UserLoginDTO;
import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/logon")
    public String logon(Model model, UserLoginDTO userLoginDTO){
        model.addAttribute("user",userLoginDTO);
        return "admin/logon";
    }
    @PostMapping("/logon")
    public String handleLogon(@ModelAttribute("user") UserLoginDTO userLoginDTO,
                              RedirectAttributes redirectAttributes,
                              HttpSession session){
        User user = userService.login(userLoginDTO);
        if(user != null){
            if(user.getRole() == 1){
                session.setAttribute("admin",user);
                return "redirect:/admin";
            }
        }
        redirectAttributes.addFlashAttribute("err","Sai CMNR");
        return "redirect:/logon";
    }
}
