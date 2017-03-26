 package com.flf.util.enums;

public enum FitmentType
{
	//毛坯，简装，精装，豪装，其它
	RAW(0, "毛坯"),
	SIMPLE(1, "简装"),
	DELICACY(2, "精装"),
	LUXURY(3, "豪装"),
	OTHER(4, "其它");

	private final int code;
	private final String name;

	private FitmentType(int code, String name)
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
	
	public static FitmentType valueOfCode(int code)
	{
		for (FitmentType type : FitmentType.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+FitmentType.class.getName());
	}
}
