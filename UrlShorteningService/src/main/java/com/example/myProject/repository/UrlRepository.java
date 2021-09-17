package com.example.myProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myProject.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	public Url findByShortLink(String shortLink);
}
