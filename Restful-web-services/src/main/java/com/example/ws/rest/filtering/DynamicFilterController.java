package com.example.ws.rest.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterController {

	@GetMapping("/dname")
	public MappingJacksonValue retriveName() {
		DynamicFilterBean dynamicBean = new DynamicFilterBean("Romio", "Ranjan", "Sahoo");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");

		FilterProvider filters = new SimpleFilterProvider().addFilter("nameBean", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBean);
		
		mapping.setFilters(filters);
		
		return mapping;
	}

	@GetMapping("dnames")
	public MappingJacksonValue retriveAll() {
		List<DynamicFilterBean> list = Arrays.asList(new DynamicFilterBean("Romio", "Ranjan", "Sahoo"),
				new DynamicFilterBean("Soumya", "Ranjan", "Sahoo"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName");

		FilterProvider filters = new SimpleFilterProvider().addFilter("nameBean", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}
}
