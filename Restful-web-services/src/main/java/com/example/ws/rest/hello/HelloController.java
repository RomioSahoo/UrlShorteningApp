package com.example.ws.rest.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource;

	// @RequestMapping(method=RequestMethod.GET, path="/hello")
	@GetMapping("/hello")
	public String hello() {
		System.out.println("returning the string");
		return "Hello";
	}

	@GetMapping("/helloBean")
	public HelloBean helloBean() {
		System.out.println("returning the bean in json format");
		return new HelloBean("hello Bean");
	}

	@GetMapping("/helloBean/{name}")
	public HelloBean helloBeanPathVariable(@PathVariable String name) {
		return new HelloBean(String.format("Hello, %s", name));
	}

	// this can be used while using SesionLocaleResolver
//	@GetMapping("/hello-internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}

	//this can be used while using AcceptHeaderLocaleResolver class
	@GetMapping("/hello-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
