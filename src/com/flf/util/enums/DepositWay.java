 package com.flf.util.enums;

public enum DepositWay
{
	//压金方式0押一付一1押一付二 2押一付三3半年付4年付5两年付6三年付
	DEPOSIT_1_PAY_1(0, "押一付一"),
	DEPOSIT_1_PAY_2(1, "押一付二"),
	DEPOSIT_1_PAY_3(2, "押一付三"),
	PAY_HALF_YEAR(3, "半年付"),
	PAY_YEAR(4, "年付"),
	PAY_2_YEAR(5, "两年付"),
	PAY_3_YEAR(6, "三年付");

	private final int code;
	private final String name;

	private DepositWay(int code, String name)
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
	
	public static DepositWay valueOfCode(int code)
	{
		for (DepositWay type : DepositWay.values())
		{
			if (type.getCode() == code)
			{
				return type;
			}
		}
		throw new IllegalStateException("enums.type.invalidcode#"+code+"#"+DepositWay.class.getName());
	}
}
