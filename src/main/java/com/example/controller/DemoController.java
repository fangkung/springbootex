package com.example.controller;

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

import com.example.dao.UserDao;
import com.example.model.User;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private UserDao dao;

	@GetMapping
	public String index() {
		return "demo/index";
	}

	@GetMapping(value = "listuser")
	public String listUser(ModelMap model) {
		model.put("users", dao.findAllUsers());
		return "demo/listuser";
	}

	@GetMapping(value = "addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "demo/adduser";
	}

	@PostMapping(value = "saveUser")
	public String saveUser(@Valid @ModelAttribute User user, Model model) {
		dao.saveUser(user);
		model.addAttribute("users", dao.findAllUsers());
		return "demo/listuser";
	}

	@GetMapping(value = "/deleteUser/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		dao.deleteUserById(id);
		return "redirect:/demo/listuser";
	}

	@RequestMapping("/editUser/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = dao.findById(id);
		model.addAttribute("user", user);
		return "demo/edituser";
	}

	@PostMapping(value = "updateUser")
	public String updateUser(@Valid @ModelAttribute User user, Model model) {
		dao.updateUser(user);
		model.addAttribute("users", dao.findAllUsers());
		return "demo/listuser";
	}

}
