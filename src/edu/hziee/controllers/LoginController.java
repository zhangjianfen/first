package edu.hziee.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView get(){
		ModelAndView mav = new ModelAndView("/login/login");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView post(@RequestParam String userName, 
			@RequestParam String password,@RequestParam String returnUrl
			,HttpSession session){
		ModelAndView mav = new ModelAndView("");
		if( userName.equals("admin") && password.equals("123456")){
			session.setAttribute("userName", userName);
			String url = returnUrl.replace("/myspring", "");
			mav.setViewName("redirect:"+url);
		}
		else{
			mav.addObject("error", "用户或者密码错误！");
			mav.setViewName("/login/login");
		}
		
		return mav;
	}
}
