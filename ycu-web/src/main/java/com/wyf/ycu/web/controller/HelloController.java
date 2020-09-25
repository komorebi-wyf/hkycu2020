package com.wyf.ycu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/hi")
	public String sayHi(Model model,
						@RequestParam(value="name", required = false,
								defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

}
