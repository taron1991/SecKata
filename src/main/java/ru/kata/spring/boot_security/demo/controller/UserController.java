package ru.kata.spring.boot_security.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

/*
@Controller
@RequestMapping("/api")*/
public class UserController {

	/*private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		model.addAttribute("userList", userService.userList());
		return "userList";
	}

	@GetMapping("/showUser")
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user, Model model) {
		userService.addUser(user);
		model.addAttribute("userList", userService.userList());
		return "redirect:/api/users";
	}

	@GetMapping("/update")
	public String update(Model model){
		model.addAttribute("user", new User());
		return "update";

	}

	@GetMapping("/delUser")
	public String showDeleteForm(Model model) {
		model.addAttribute("userIdForm", new User());
		return "del";
	}

	@PostMapping("/del")
	public String delete(@ModelAttribute User userIdForm) {
		userService.delById(userIdForm.getId());
		return "redirect:/api/users";
	}*/


	
}