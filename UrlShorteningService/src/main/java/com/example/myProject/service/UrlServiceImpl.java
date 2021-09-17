package com.example.myProject.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.myProject.model.Url;
import com.example.myProject.model.UrlDto;
import com.example.myProject.repository.UrlRepository;
import com.google.common.hash.Hashing;

@Component
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private UrlRepository urlRepository;

	@Override
	public Url generateShortLink(UrlDto urlDto) {
		if (StringUtils.isNotEmpty(urlDto.getUrl())) {
			String encodedUrl = encodedUrl(urlDto.getUrl());
			Url urlToPersist = new Url();
			urlToPersist.setCreationDate(LocalDateTime.now());
			urlToPersist.setOriginalUrl(urlDto.getUrl());
			urlToPersist.setShortLink(encodedUrl);
			urlToPersist
					.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(), urlToPersist.getCreationDate()));
			Url urlToReturn=persistShortLink(urlToPersist);
			
			if(urlToReturn!= null)
				return urlToReturn;
			
			return null;
		}
		return null;
	}

	private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
		if(StringUtils.isBlank(expirationDate))
		{
			return creationDate.plusSeconds(60);
		}
		LocalDateTime expirationDateToReturn=LocalDateTime.parse(expirationDate);
		return expirationDateToReturn;
		
	}

	private String encodedUrl(String url) {
		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encodedUrl = Hashing.murmur3_32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
		return encodedUrl;
	}

	@Override
	public Url persistShortLink(Url url) {
		Url urlToReturn=urlRepository.save(url);
		return urlToReturn;
	}

	@Override
	public Url getEncodedUrl(String url) {
		Url urlToReturn=urlRepository.findByShortLink(url);
		return urlToReturn;
	}

	@Override
	public void deleteShortLink(Url url) {
		urlRepository.delete(url);

	}

}
