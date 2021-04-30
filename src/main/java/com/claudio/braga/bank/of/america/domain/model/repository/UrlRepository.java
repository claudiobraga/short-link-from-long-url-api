package com.claudio.braga.bank.of.america.domain.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudio.braga.bank.of.america.domain.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	
	List<Url> findByDescriptionContaining(String description);
	
	Url findByCustomAlias(String customalias);
	
	Url findByCustomAliasLike(String customAlias);
}
