package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class ForAdmin {

    private final UserService user;

    @Autowired
    public ForAdmin(UserService user) {
        this.user = user;
    }

    @GetMapping("/")
    public String showAdminRootPage(Model model) {
        model.addAttribute("users", user.userList());
        return "users";
    }

    @GetMapping("/users")
    public String showAllUsersPage(Model model) {
        model.addAttribute("users", user.userList());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUserPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", user.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String showNewUserPage(@ModelAttribute("newUser") User newUser) {
        return "newUser.html";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("newUser") User newUser) {
        user.addUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String showEditUserPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", user.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User editedUser, @PathVariable("id") long id) {
        user.update(editedUser, id);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User deletedUser) {
        user.delete(deletedUser);
        return "redirect:/admin/";
    }


}
