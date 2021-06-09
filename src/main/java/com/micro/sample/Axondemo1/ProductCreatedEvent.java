package com.micro.sample.Axondemo1;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class ProductCreatedEvent {
	
	private  String productId;
	private  String product;
	private  String price ;

}
