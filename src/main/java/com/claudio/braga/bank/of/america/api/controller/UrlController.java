package com.claudio.braga.bank.of.america.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudio.braga.bank.of.america.domain.model.Url;
import com.claudio.braga.bank.of.america.domain.model.UrlShortener;
import com.claudio.braga.bank.of.america.domain.model.repository.UrlRepository;

@RestController
@RequestMapping("/urls")
public class UrlController {
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private UrlShortener urlShortener;
	
	@GetMapping
	public List<Url> getUrl(){
		
		return urlRepository.findAll();
	}
	
	@GetMapping("/description")
	public List<Url> getUrlByDescription(@RequestParam String description){
		List<Url> urls = urlRepository.findByDescriptionContaining(description);
		return urls;
	}
	
	@GetMapping("/customalias")
	public String getCustomAlias(@RequestParam String customAlias){
		Url url = urlRepository.findByCustomAlias(customAlias);
		String resp = url.getOriginalUrl();
		
		String redirect = "<html>\r\n" + 
				"<head>\r\n" + 
				"  <meta http-equiv=\"refresh\" content=\"0; URL="+resp+"\" />\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"  <p>If you are not redirected in five seconds, <a href=\""+resp+"\">click here</a>.</p>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		return redirect;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Url createUrl(@Valid @RequestBody Url url){
		Integer msg = urlShortener.decode(url.getOriginalUrl());
		url.setCustomAlias(urlShortener.encode(msg));
		
		if(url.getCustomAlias().equals("")) {
			msg = urlShortener.decode2(url.getOriginalUrl());
			url.setCustomAlias(urlShortener.encode2(msg));
		}
		
		Url urlsaved = urlRepository.save(url);
		return urlsaved;
	}
	
}
