package com.micro.sample.Axondemo1;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {
	
	@AggregateIdentifier
	private  String productId;
	private  String product;
	private  String price ;
	
	public ProductAggregate() {
		
	}
	
	@CommandHandler
    public ProductAggregate(CreateProductCommand command) {
		//TODO: Validation logic can be handled here
		ProductCreatedEvent event=new ProductCreatedEvent();
		
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent event) {
		this.price=event.getPrice();
		this.productId=event.getProductId();
		this.product=event.getProduct();
		
	}

}
