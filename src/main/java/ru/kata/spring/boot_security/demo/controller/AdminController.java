package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService user) {
        this.userService = user;
    }

    @GetMapping("/")
    public String showAdminRootPage(Model model) {
        model.addAttribute("users", userService.userList());
        return "users";
    }

    @GetMapping("/users")
    public String showAllUsersPage(Model model) {
        model.addAttribute("users", userService.userList());
        return "users";
    }

    @GetMapping("/show")
    public String showUserPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String showNewUserPage(@ModelAttribute("newUser") User newUser) {
        return "newUser.html";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("newUser") User newUser) {
        userService.addUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditUserPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping("/edited")
    public String editUser(@ModelAttribute("user") User editedUser, @RequestParam("id") long id) {
        userService.update(editedUser, id);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User deletedUser) {
        userService.delete(deletedUser);
        return "redirect:/admin/";
    }


}
