package com.miniaturesolutions.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miniaturesolutions.pojo.InnerPojo;
import com.miniaturesolutions.pojo.TestPojo;

@Controller
public class HomeController {

@RequestMapping(value={"/","/test", "/test*"}, method=RequestMethod.GET)
  public String test(Map<String, Object> model) {
	
	TestPojo test = new TestPojo();
	test.setMessage("hiya");
	model.put("testPojo",test);
    return "home";
  }

	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String handlePost( TestPojo pojo, BindingResult br, Map<String, Object> model){
	
		pojo.setName("Wibble");

		model.put("testPojo",pojo);
		return "home";
	}
}
