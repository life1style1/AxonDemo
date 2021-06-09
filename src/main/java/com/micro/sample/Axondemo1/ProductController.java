package com.micro.sample.Axondemo1;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.model.CreateProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.sample.Axondemo1.CreateProductCommand;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private CommandGateway gateway;
	
	@PostMapping
	public ResponseEntity createProduct(@RequestBody CreateProductModel model) {
		
		CreateProductCommand command=CreateProductCommand.builder()
				.price("$123")
				.productId(UUID.randomUUID().toString())
				.product("Shoe")
				.build();
		
		String s=gateway.sendAndWait(command);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
