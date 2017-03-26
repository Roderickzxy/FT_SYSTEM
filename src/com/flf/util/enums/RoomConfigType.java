 package com.flf.util.enums;

public enum RoomConfigType
{
	//房间配置：宽带，冰箱，电视，阳台，床
	BROADBAND(0, "宽带"),
	REFRIGERATOR(1, "冰箱"),
	TV(2, "电视"),
	BALCONY(3, "阳台"),
	BED(4, "床");

	private final int code;
	private final String name;

	private RoomConfigType(int code, String name)
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
	
	public static RoomConfigType valueOfCode(int code)
	{
		for (RoomConfigType type : RoomConfigType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+RoomConfigType.class.getName());
	}
}
