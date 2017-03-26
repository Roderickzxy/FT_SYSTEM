 package com.flf.util.enums;

public enum TradeAreaType
{
	    
	WALKING_STREET(0, "歩行街"),
	SQUARE(1, "广场"),
	CINEMA(2, "电影院"),
	STREETS(3, "街市"),
	OTHER(4, "其它");

	private final int code;
	private final String name;

	private TradeAreaType(int code, String name)
	{
		this.code = code;
		this.name = name;
	}

	public int getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}
	
	public static TradeAreaType valueOfCode(int code)
	{
		for (TradeAreaType type : TradeAreaType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+TradeAreaType.class.getName());
	}
}
