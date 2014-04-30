package com.miniaturesolutions.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniaturesolutions.pojo.InnerPojo;
import com.miniaturesolutions.pojo.TestPojo;

@Controller
public class RestController {

	@RequestMapping(value={"/testpojos"}, method=RequestMethod.GET)
	public String index(Map<String, Object> model) {

		List<TestPojo> pojos = new ArrayList<>();
		
		for( int i=0; i< 4;i++)
		{
			TestPojo test = new TestPojo();
			test.setName("hiya " + i);
			test.setId(i);
			pojos.add(test);
		}
		
		model.put("testPojos",pojos);
		
		return "testpojo/index";
	}
	
	@RequestMapping(value={"/testpojo/create"}, method=RequestMethod.GET)
	public String create(Map<String, Object> model) {

		TestPojo pojo = new TestPojo();
		pojo.setMessage("");
		
		setRestData(pojo, model);
		
		return "testpojo/show";
	}

	@RequestMapping(value={"/testpojo/{id}"}, method=RequestMethod.GET)
	public String show(@PathVariable("id") long id, Map<String, Object> model) {

		TestPojo pojo = new TestPojo();
		pojo.setId(id);
		pojo.setMessage("pojo show existing");
		
		setRestData(pojo, model);
		
		return "testpojo/show";
	}

	@RequestMapping(value="/testpojo", method=RequestMethod.POST)
	public String create( TestPojo pojo, BindingResult br, Map<String, Object> model){


		pojo.setId(999999L);
		pojo.setMessage("pojo created");
		
		setRestData(pojo, model);
		
		return "testpojo/show";
	}

	@RequestMapping(value="/testpojo/{id}", method=RequestMethod.PUT)
	public String update( TestPojo pojo, @PathVariable("id") long id, BindingResult br, Map<String, Object> model){
		pojo.setId(id);
		pojo.setMessage("pojo updated");
		
		setRestData(pojo, model);
		
		return "testpojo/show";
	}

	@RequestMapping(value="/testpojo/{id}", method=RequestMethod.DELETE)
	public String delete( TestPojo pojo, @PathVariable("id") long id, BindingResult br, Map<String, Object> model){

		pojo.setId(-1L);
		pojo.setMessage("pojo deleted");
		
		//setRestData(pojo, model);
		
		//return "testpojo/show";
		return "redirect:/testpojos";
	}
	
	private Map<String, Object> setRestData(TestPojo pojo, Map<String, Object> model) {
	
		model.put("testPojo",pojo);
		String restMethod = "POST";
		String url = "/testpojo";
		
		if (pojo.getId() != -1) {
			restMethod = "PUT";
			url = url + "/" + pojo.getId(); 
		}
		model.put("restmethod", restMethod);
		model.put("submission_url",url);
		
		return model;
	}
}
