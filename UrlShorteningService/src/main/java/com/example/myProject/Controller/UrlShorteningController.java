package com.example.myProject.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProject.model.Url;
import com.example.myProject.model.UrlDto;
import com.example.myProject.model.UrlErrorResponseDto;
import com.example.myProject.model.UrlResponseDto;
import com.example.myProject.service.UrlService;

@RestController
public class UrlShorteningController {

	@Autowired
	private UrlService urlService;
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto){
		
		Url urlToReturn=urlService.generateShortLink(urlDto);
		
		if(urlToReturn!=null)
		{
			UrlResponseDto urlResponseDto=new UrlResponseDto();
			urlResponseDto.setOriginalUrl(urlToReturn.getOriginalUrl());
			urlResponseDto.setExpirationDate(urlToReturn.getExpirationDate());
			urlResponseDto.setShortLink(urlToReturn.getShortLink());
			return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
		}
		
		UrlErrorResponseDto urlErrorResponseDto=new  UrlErrorResponseDto();
		urlErrorResponseDto.setStatus("404");
		urlErrorResponseDto.setError("There was an error while processing your request. Please try again after some time.");
		return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
	}
	
	@GetMapping("/{shortLink}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException
	{
		//to handles cases if shortLink contains any garbage when user put any random garbage value in URL
		if(StringUtils.isEmpty(shortLink))
		{
			UrlErrorResponseDto urlErrorResponseDto=new UrlErrorResponseDto();
			urlErrorResponseDto.setStatus("400");
			urlErrorResponseDto.setError("Invalid Url");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
		}
		
		
		//to check shortUrl exist in the database or not
		Url urlToReturn=urlService.getEncodedUrl(shortLink);
		if(urlToReturn==null)
		{
			UrlErrorResponseDto urlErrorResponseDto=new UrlErrorResponseDto();
			urlErrorResponseDto.setStatus("400");
			urlErrorResponseDto.setError("Url does not exist or it might have expired");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
		}
		
		//To Handle cases if URL exist in database but might get expired
		if(urlToReturn.getExpirationDate().isBefore(LocalDateTime.now()))
		{
			urlService.deleteShortLink(urlToReturn);
			UrlErrorResponseDto urlErrorResponseDto=new UrlErrorResponseDto();
			urlErrorResponseDto.setStatus("200");
			urlErrorResponseDto.setError("Url Expired!! Please try generating a fresh one");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
		}

		response.sendRedirect(urlToReturn.getOriginalUrl());
		
		return null;
		
	}
}
