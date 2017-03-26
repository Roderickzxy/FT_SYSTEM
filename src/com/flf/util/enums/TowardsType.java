 package com.flf.util.enums;

public enum TowardsType
{
	//朝向：南向，北向，东向，西向，东南向，西南向，西北向，其它
	SOUTH(0, "南向"),
	NORTH(1, "北向"),
	EAST(2, "东向"),
	WEST(3, "西向"),
	EAST_SOUTH(4, "东南向"),
	WEST_SOUTH(5, "西南向"),
	WEST_NORTH(6, "西北向"),
	OTHER(7, "其它");

	private final int code;
	private final String name;

	private TowardsType(int code, String name)
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
	
	public static TowardsType valueOfCode(int code)
	{
		for (TowardsType type : TowardsType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+TowardsType.class.getName());
	}
}
