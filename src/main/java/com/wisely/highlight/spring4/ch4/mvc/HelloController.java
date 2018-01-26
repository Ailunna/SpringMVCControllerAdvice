package com.wisely.highlight.spring4.ch4.mvc;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anno")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("TestJavaConfig", "say hello from controller by mvc 4");
		return "index";
	}
	@RequestMapping(value="/getjson", produces= {"application/json;charset=UTF-8"})
	public DemoObj getjson(DemoObj obj) {
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}
	
	@RequestMapping(value="/getxml", produces= {"application/xml;charset=UTF-8"})
	public DemoObj getxml(DemoObj obj) {
		return new DemoObj(obj.getId()+1, obj.getName()+"qq");
	}

	@RequestMapping(produces="text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:"+request.getRequestURL()+" can access";		
	}
	
	@RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access, str: "+str;		
	}
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	 public String sayHelloAgain(ModelMap model) {
	 model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
	 return "welcome";
	 }
	@RequestMapping(value="/requestParam", produces="text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		return "url:" + request.getRequestURL()+" can access, id: "+id;
	}
	
	@RequestMapping(value="/obj", produces="application/json;charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj obj, HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access, obj id: "+obj.getId()+" obj name:"+obj.getName();
	}
	
	@RequestMapping(value= {"/name1", "/name2"}, produces="text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access";
	}
	
	@RequestMapping(value="/advice")
	public String getSomething(@ModelAttribute("msg")String msg, DemoObj obj) {
		throw new IllegalArgumentException("I'm sorry, parameter is wrong, please input again. it is come from @ModelAttribute:"+msg);
	}
}
