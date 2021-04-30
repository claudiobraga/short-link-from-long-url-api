package com.claudio.braga.bank.of.america.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudio.braga.bank.of.america.domain.exception.ShortLinkException;
import com.claudio.braga.bank.of.america.domain.model.Url;
import com.claudio.braga.bank.of.america.domain.model.UrlShortener;
import com.claudio.braga.bank.of.america.domain.model.repository.UrlRepository;

@Service
public class CreateShortUrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	UrlShortener urlShortener;
	
	public Url createShortLink (Url url) {
		
		Integer msg = UrlShortener.decode(url.getOriginalUrl());
		url.setCustomAlias(urlShortener.encode(msg));
		
		Url shortLinkExist = urlRepository.findByCustomAliasLike(url.getCustomAlias());
		if (shortLinkExist != null || url.getCustomAlias().equals("")) {
			
			throw new ShortLinkException("The Short Link for this URL, Exist Already!");
			
		}
		return urlRepository.save(url);
		
	}

}
