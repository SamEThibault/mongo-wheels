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

	// no argument constructor initializing fields to default values
	public Car()
	{
		id = "not found";
		dimensions = new Dimensions();
		engine = new Engine();
		fuelInfo = new FuelInfo();
		identification = new Identification();
	}

	// constructor, using bean copy constructors for deep copies of mutable objects
	public Car(String idIn, Dimensions dimensionsIn, Engine engineIn,
			   FuelInfo fuelInfoIn, Identification identificationIn)
	{
		// in this case, all instance variables are immutable so no copy constructor calls needed yet
		id = idIn;
		dimensions = dimensionsIn;
		engine = engineIn;
		fuelInfo = fuelInfoIn;
		identification = identificationIn;
	}

	// constructor with all instance variable values from all other objects
	public Car(int heightIn, int lengthIn, int widthIn, String driveLineIn, String engineTypeIn, boolean hybridIn, int numGearsIn,
			   String transmissionIn, int horsepowerIn, int torqueIn, int cityMpgIn, String fuelTypeIn, int highwayMpgIn,
			   String classificationIn, String IDIn, String makeIn, String modelYearIn, int yearIn)
	{
		dimensions = new Dimensions(heightIn, lengthIn, widthIn);

		engine = new Engine(driveLineIn, engineTypeIn, hybridIn, numGearsIn, transmissionIn,
							new EngineStats(horsepowerIn, torqueIn));

		fuelInfo = new FuelInfo(cityMpgIn, fuelTypeIn, highwayMpgIn);

		identification = new Identification(classificationIn, IDIn, makeIn, modelYearIn, yearIn);

	}

}
