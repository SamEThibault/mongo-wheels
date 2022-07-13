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
@Document(collection="discussion")
public class Post {
	
	@Id
	private String id;
	@NonNull
	private String username;
	@NonNull
	private String message;
	
	private String date;
	

}
