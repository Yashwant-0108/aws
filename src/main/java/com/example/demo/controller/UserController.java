package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@Controller
public class UserController 
{
	@Autowired
	UserService service;
	
	
	@GetMapping("/")
	public String viewHome()
	{
		return "Home";
	}
	
	@GetMapping("/Registration")
	public String viewRegistration()
	{
		return "Registration";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user )
	{
		service.saveUser(user);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
    public String viewUserList(Model model) 
	{
        List<User> listuser = service.ListAll();
        model.addAttribute("listuser", listuser);
        //System.out.print("Get / ");
        return "UserList";
    }
}
