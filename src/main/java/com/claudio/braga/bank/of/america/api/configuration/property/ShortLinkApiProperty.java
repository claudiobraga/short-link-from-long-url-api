package com.claudio.braga.bank.of.america.api.configuration.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("shortlinkapi")
public class ShortLinkApiProperty {
	
	private final Security security = new Security();
	
	public Security getSecurity() {
		return security;
	}

	public static class Security{
		
		private boolean anableHttps;
		
		private String originAllowed = "http://localhost:8080";

		public String getOriginAllowed() {
			return originAllowed;
		}

		public void setOriginAllowed(String originAllowed) {
			this.originAllowed = originAllowed;
		}

		public boolean isAnableHttps() {
			return anableHttps;
		}

		public void setAnableHttps(boolean anableHttps) {
			this.anableHttps = anableHttps;
		}
	}

}
