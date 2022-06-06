package com.nttdata.createProduct.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.createProduct.config.CustomerApiProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.scheduler.Schedulers;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerApiClient {
	
	private final WebClient webClient;
	private final CustomerApiProperties customerApiProperties;
	
	public List<CustomerResponse> getList() throws InterruptedException{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<CustomerResponse> result=new ArrayList<>();
		//cambiar url
		webClient.get().uri(customerApiProperties.getBaseUrl()+"/client/all")
		.accept(MediaType.TEXT_EVENT_STREAM)
		.retrieve()
		.bodyToFlux(CustomerResponse.class)
		.publishOn(Schedulers.fromExecutor(executor))
		.subscribe(customerResponse->result.add(customerResponse));
		executor.awaitTermination(1, TimeUnit.SECONDS);
		log.info("Customer list"+ result);
		return result;
	}
}
