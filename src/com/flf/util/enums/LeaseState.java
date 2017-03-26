 package com.flf.util.enums;

public enum LeaseState
{
	//租赁状态 0未租 1已租
	NOT_LEASE(0, "未租"),
	YES_LEASE(1, "已租");

	private final int code;
	private final String name;

	private LeaseState(int code, String name)
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
	
	public static LeaseState valueOfCode(int code)
	{
		for (LeaseState type : LeaseState.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+LeaseState.class.getName());
	}
}
