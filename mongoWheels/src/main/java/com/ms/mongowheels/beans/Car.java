package com.ms.mongowheels.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
	
	@Id
	private String id;

	private int height;
	private int length;
	private int width;
	private int cityMpg;
	private int highwayMpg;
	private int year;
	private int hp;
	private int torque;
	private int numGears;
	private boolean hybrid;

	@NonNull
	private String driveLine;

	@NonNull
	private String engineType;

	@NonNull
	private String transmission;

	@NonNull
	private String fuelType;

	@NonNull
	private String classification;

	@NonNull
	private String info;

	@NonNull
	private String make;
}


