package com.wyf.ycu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(String msg){
		return "[hello]"+msg;
	}

}
