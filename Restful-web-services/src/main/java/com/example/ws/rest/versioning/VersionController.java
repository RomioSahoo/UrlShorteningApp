package com.example.ws.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
//using URIs (URI Versioning)
	@GetMapping("/v1")
	public PersonV1 personv1() {
		return new PersonV1("Romio Sahoo");
	}
	
	@GetMapping("/v2")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Romio","Sahoo"));
	}
	
//using params	(Request Parameter Versioning)
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Romio Sahoo");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Romio","Sahoo"));
	}
	
//using headers	(Headers Versioning)
	@GetMapping(value="/person/header", headers="version=1")
	public PersonV1 headerv1() {
		return new PersonV1("Romio Sahoo");
	}
	
	@GetMapping(value="/person/header", headers="version=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Romio","Sahoo"));
	}
	
//using produces (Media type Versioning a.k.a "content negotiation" or "accept header")
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Romio Sahoo");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesv2() {
		return new PersonV2(new Name("Romio","Sahoo"));
	}
}
