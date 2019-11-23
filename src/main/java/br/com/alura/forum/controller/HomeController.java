package br.com.alura.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.forum.model.User;

@Controller
@CrossOrigin
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Hello World!");
		return "Hello World Usuario: "+ user.getName() +" Bem vindo ao curso de Spring Framework";
	}
}