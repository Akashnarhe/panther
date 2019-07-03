package com.demoh2.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demoh2.example.entity.Demo;
import com.demoh2.example.model.User;
import com.demoh2.example.utility.ExcelUtility;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping(value="/userlistreport")
	public ModelAndView userListReport(HttpServletRequest request, HttpServletResponse response) {
		
		List<User> list = new ArrayList<>();
		
		list.add(new User(1,"Akash","Narhe","akash.dnarhe@gmail.com",862));
		list.add(new User(2,"Suraj","Deshmukh","suraj.deshmukh@gmail.com",962));
		list.add(new User(3,"Mayank","Dandhare","mayank.dandhare@gmail.com",762));
		list.add(new User(4,"Alok","Kumar","alok.kumar@gmail.com",662));
		list.add(new User(5,"Ronil","Shah","ronil.shah@gmail.com",562));
		list.add(new User(6,"Vinay","Nair","akash.dnarhe@gmail.com",462));
		Demo demo = new Demo();
		demo.toString();
		return new ModelAndView(new ExcelUtility(), "userList", list);
	}
}
