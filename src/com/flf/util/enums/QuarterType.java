 package com.flf.util.enums;

public enum QuarterType
{
	FIRST(1, "第一季度"),
	SECOND(2, "第二季度"),
	THIRD(3, "第三季度"),
	FOURTH(4, "第四季度");

	private final int code;
	private final String name;

	private QuarterType(int code, String name)
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
	
	public static QuarterType valueOfCode(int code)
	{
		for (QuarterType type : QuarterType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+QuarterType.class.getName());
	}
}
