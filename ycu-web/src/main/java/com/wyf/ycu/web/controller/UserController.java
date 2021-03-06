package com.wyf.ycu.web.controller;

import com.wyf.ycu.web.model.User;
import com.wyf.ycu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = this.userService.getUserList();
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "user/userAdd";
	}

	@RequestMapping("/add")
	public String add(User user){
		this.userService.save(user);
		return "redirect:/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model,Long id){
		User user = this.userService.findUserById(id);
		model.addAttribute("user",user);
		return "user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(User user){
		this.userService.edit(user);
		return "redirect:/list";
	}
	@RequestMapping("/delete")
	public String delete(Long id){
		this.userService.delete(id);
		return "redirect:/list";
	}
}

