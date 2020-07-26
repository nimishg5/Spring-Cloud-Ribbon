package com.example.userapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonAutoConfiguration {
	
	@Autowired
	IClientConfig ribbonClient;
	
	@Bean
	public IPing ping (IClientConfig ribbonClient) {
		return new PingUrl();
	} 
	
	@Bean
	public IRule rule (IClientConfig ribbonClient) {
		return new AvailabilityFilteringRule();
	}

}
