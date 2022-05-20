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
@Document(collection="carsv5")
public class Car {
	
	@Id
	private String id;

	private int height;
	private int length;
	private int width;
	private String driveLine;
	private String engineType;
	private boolean hybrid;
	private int numGears;
	private String transmission;
	private int cityMpg;
	private String fuelType;
	private int highwayMpg;
	private String make;
	private int year;
	private int hp;
	private int torque;
}


