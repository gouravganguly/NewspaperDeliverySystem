package com.laqr.NewspaperDeliverySystem.controller.admin;

import com.laqr.NewspaperDeliverySystem.model.User;
import com.laqr.NewspaperDeliverySystem.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/home")
    public String adminHomePage(
            ModelMap model,
            HttpSession session
    ) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        User currentUser = userService.getAdmin(username, password);
        if (currentUser != null) {
            model.addAttribute(currentUser);
            return "admin/home";
        } else {
            return "redirect:/";
        }
    }
}
