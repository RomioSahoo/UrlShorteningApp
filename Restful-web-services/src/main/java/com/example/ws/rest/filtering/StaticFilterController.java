package com.example.ws.rest.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilterController {

	@GetMapping("/name")
	public StaticFilterBean retrieveName() {
		return new StaticFilterBean("Romio", "Ranjan", "Sahoo");
	}

	@GetMapping("/names")
	public List<StaticFilterBean> retrieveAll() {
		return Arrays.asList(new StaticFilterBean("Romio", "Ranjan", "Sahoo"), new StaticFilterBean("Soumya", "Ranjan", "Sahoo"));
	}
}
