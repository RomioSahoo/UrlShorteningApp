package com.example.myProject.service;

import org.springframework.stereotype.Service;

import com.example.myProject.model.Url;
import com.example.myProject.model.UrlDto;

@Service
public interface UrlService {

	public Url generateShortLink(UrlDto urlDto);
	public Url persistShortLink(Url url);
	public Url getEncodedUrl(String url);
	public void deleteShortLink(Url url);
}
