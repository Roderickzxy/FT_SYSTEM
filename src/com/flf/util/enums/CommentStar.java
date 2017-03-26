 package com.flf.util.enums;

public enum CommentStar
{
	STAR1(1, "1颗星"),
	STAR2(2, "2颗星"),
	STAR3(3, "3颗星"),
	STAR4(4, "4颗星"),
	STAR5(5, "5颗星");

	private final int code;
	private final String name;

	private CommentStar(int code, String name)
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
	
	public static CommentStar valueOfCode(int code)
	{
		for (CommentStar type : CommentStar.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+CommentStar.class.getName());
	}
}
