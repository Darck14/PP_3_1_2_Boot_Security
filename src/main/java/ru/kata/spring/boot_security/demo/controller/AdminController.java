package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("user",userService.listUsers());
        return "admin_page";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin_show_user";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "new_user_form";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user, @RequestParam List<String> roleNames) {
        userService.add(user, roleNames);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin_user_edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute ("user") User user, @RequestParam List<String> roleNames) {
        userService.update(user, roleNames);
        return "redirect:/admin";
    }
}
