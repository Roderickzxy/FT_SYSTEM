 package com.flf.util.enums;

public enum PropertyTypeType
{
	//物业类型：公寓，普通住宅，别墅，酒店公寓，其他
	APARTMENT(0, "公寓"),
	COMMON_RESIDENCE(1, "普通住宅"),
	VILLA(2, "别墅"),
	HOTEL_APARTMENT(3, "酒店公寓"),
	OTHER(4, "其他");

	private final int code;
	private final String name;

	private PropertyTypeType(int code, String name)
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
	
	public static PropertyTypeType valueOfCode(int code)
	{
		for (PropertyTypeType type : PropertyTypeType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+PropertyTypeType.class.getName());
	}
}
