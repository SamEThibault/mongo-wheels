package com.ms.mongowheels.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class Car {
	
	@Id
	private String id;

	@NonNull
	private Dimensions dimensions;

	// this instance includes engine stats object as a field
	@NonNull
	private Engine engine;


	@NonNull
	private FuelInfo fuelInfo;

	@NonNull
	private Identification identification;




}
