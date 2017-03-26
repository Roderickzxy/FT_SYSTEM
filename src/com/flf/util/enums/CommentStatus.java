 package com.flf.util.enums;

public enum CommentStatus
{
	
	NOT_LEASE(0, "停用"),
	YES_LEASE(1, "启用");

	private final int code;
	private final String name;

	private CommentStatus(int code, String name)
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
	
	public static CommentStatus valueOfCode(int code)
	{
		for (CommentStatus type : CommentStatus.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+CommentStatus.class.getName());
	}
}
