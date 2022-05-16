package com.ms.mongowheels.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
@Document
public class Dimensions
{
	
	@Id
	private String id;
    private int height;
    private int length;
    private int width;

    // no argument constructor
    public Dimensions()
    {
        height = 0;
        length = 0;
        width = 0;
    }

    public Dimensions(int heightIn, int lengthIn, int widthIn)
    {
        height = heightIn;
        length = lengthIn;
        width = widthIn;
    }
    // ----------------- getter and setters ------------------
    public int getHeight()
    {
        return this.height;
    }

    public int getLength()
    {
        return this.length;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    // -------------------------------------------------------

}