 package com.flf.util.enums;

public enum HouseTypeType
{
	//一室，二室，三室，四室，四室以上
	ONE_ROOM(0, "一室"),
	TWO_ROOM(1, "二室"),
	THREE_ROOM(2, "三室"),
	FOUR_ROOM(3, "四室"),
	FOUR_OVER_ROOM(4, "四室以上");

	private final int code;
	private final String name;

	private HouseTypeType(int code, String name)
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
	
	public static HouseTypeType valueOfCode(int code)
	{
		for (HouseTypeType type : HouseTypeType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+HouseTypeType.class.getName());
	}
}
