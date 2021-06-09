package com.micro.sample.Axondemo1;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProductCommand {
	@TargetAggregateIdentifier
	private final String productId;
	private final String product;
	private final String price ;


}
