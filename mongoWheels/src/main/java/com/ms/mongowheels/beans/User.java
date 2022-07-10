package com.ms.mongowheels.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private String userName;
	private String encryptedPassword;
	private Long userId;
	
}