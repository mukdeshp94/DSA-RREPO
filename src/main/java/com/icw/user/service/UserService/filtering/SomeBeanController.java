package com.icw.user.service.UserService.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.*;

@RestController
public class SomeBeanController {

	@GetMapping("/getbean")
	public MappingJacksonValue getBean()
	{
		SomeBean bean=new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingjacksonvalue=new MappingJacksonValue(bean);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
	
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
				
				mappingjacksonvalue.setFilters(filters);
		return mappingjacksonvalue;
		
	}
	@GetMapping("/getallbean")
	public List<SomeBean> getAllBean()
	{
		List<SomeBean> allBean=Arrays.asList(new SomeBean("value1", "value2", "value3"));
		
		return allBean;
		
	}
}
