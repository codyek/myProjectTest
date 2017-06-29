package com.myland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myland.exception.MyException;

//@RestController
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
	    return "Hello World!123";
	}
	
	@RequestMapping("/helloAB")
	@ResponseBody
	public String helloAB() {
	    return "Hello World!aaa";
	}
	
	@RequestMapping("/host")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "show";
    }
	
	@RequestMapping("/erpage")
    public String error(ModelMap map) {
        map.addAttribute("errorMsg", "sdfsdf111");
        map.addAttribute("url", "http://blog.didispace.com");
        return "errMsg";
    }
	
	@RequestMapping("/ex")
	@ResponseBody
	public String ex() throws Exception{
		String x = null;
		String y = "2";
		y = x;
		int mub = 0;
		mub = y.indexOf("2");
		return "ex output "+mub;
	}
	
	@RequestMapping("/er")
	@ResponseBody
	public String ex1() throws MyException{
		String x = null;
		String y = "2";
		y = x;
		int mub = 0;
		try {
			mub = y.indexOf("2");
		} catch (Exception e) {
			throw new MyException("localerr="+e.getMessage());
		}
		return "ex output "+mub;
	}
}
