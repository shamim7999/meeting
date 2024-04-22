package org.dsi.meeting.controllers;

import lombok.AllArgsConstructor;
import org.dsi.meeting.models.User;
import org.dsi.meeting.services.UserSevice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserSevice userSevice;


    @ModelAttribute("users")
    public List<User> sendUsers() {
        return userSevice.findAllUsers();
    }

    @GetMapping({"/", "/index"})
    public String sendHome() {
        return "index";
    }

    @GetMapping("/add-user")
    public String addUser() {
        return "add-user";
    }

    @PostMapping("/process-add-user")
    public String processAddUser(@ModelAttribute User user) {
        userSevice.saveUser(user);
        return "redirect:/add-user";
    }

    @GetMapping("/process-delete-user")
    public String processDeleteUser(@RequestParam Long userId) {
        userSevice.deleteUser(userId);
        return "redirect:/add-user";
    }
}
