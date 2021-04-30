package com.claudio.braga.bank.of.america.api.exceptionhandler;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {
	
	private Integer status;
	
	private OffsetDateTime dateHour;
	
	private String Title;	

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public OffsetDateTime getDateHour() {
		return dateHour;
	}
	
	public void setDateHour(OffsetDateTime dateHour) {
		this.dateHour = dateHour;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		Title = title;
	}
}
