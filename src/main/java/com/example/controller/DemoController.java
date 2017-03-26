package com.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.User;
import com.example.server.service.UserService;

@Controller
@RequestMapping("demo")
@SessionAttributes("login")
public class DemoController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String index() {
		return "demo/index";
	}

	@GetMapping(value = "login")
	public String login(ModelMap model, HttpSession session) {
		User user = userService.checkCookie(session);
		if (user == null) {
			model.put("user", new User());
			return "demo/login";
		} else {
			User check = userService.findByName(user.getName());
			if (check != null && check.getId() > 0) {
				session.setAttribute("username", user.getName());
				session.setAttribute("password", user.getAge());
				model.addAttribute("users", userService.findAllUsers());
				return "demo/listuser";
			} else {
				model.put("error", "Invalid User!!");
				return "demo/login";
			}
		}

	}

	@PostMapping(value = "login")
	public String login(@ModelAttribute User user, ModelMap model, HttpSession session) {
		User check = userService.findByName(user.getName());
		if (check != null && check.getId() > 0) {
			session.setAttribute("username", user.getName());
			session.setAttribute("password", user.getAge());
			model.addAttribute("users", userService.findAllUsers());
			return "demo/listuser";
		} else {
			model.put("error", "Invalid User!!");
			return "demo/login";
		}
	}
	
	@GetMapping(value = "logout")
	public String logout(ModelMap model, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("password");
		return "demo/index";
	}

	@GetMapping(value = "listuser")
	public String listUser(ModelMap model) {
		model.addAttribute("users", userService.findAllUsers());
		return "demo/listuser";
	}

	@GetMapping(value = "addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "demo/adduser";
	}

	@PostMapping(value = "saveUser")
	public String saveUser(@Valid @ModelAttribute User user, Model model) {
		userService.saveUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "demo/listuser";
	}

	@GetMapping(value = "/deleteUser/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		userService.deleteUserById(id);
		return "redirect:/demo/listuser";
	}

	@RequestMapping("/editUser/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "demo/edituser";
	}

	@PostMapping(value = "updateUser")
	public String updateUser(@Valid @ModelAttribute User user, Model model) {
		userService.updateUser(user);
		model.addAttribute("users", userService.findAllUsers());
		return "demo/listuser";
	}

}
