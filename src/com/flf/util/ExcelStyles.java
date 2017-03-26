package com.flf.util;



import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/** Excel样式定义常量类 */
public class ExcelStyles {
	
	//256表示一个半角字符的宽度
	short charUnitWidth = 260;
	
	HSSFWorkbook book = null;
	
	/** 黑体18点标题样式 */
	HSSFCellStyle blackFont_title_18 = null;
	
	/** 宋体14点标题样式 */
	HSSFCellStyle sunBlod_10 = null;
	
	/** 普通单元格样式 */
	HSSFCellStyle normalStyle = null;	
	
	/** 自定义构造函数 */
	public ExcelStyles(HSSFWorkbook book){
		this.book = book;
	}
	
	/** 创建黑体18点标题样式 */
	public HSSFCellStyle getBlackFont_Title_18(){
		blackFont_title_18 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("黑体");
	    font.setBoldweight((short) (charUnitWidth*10));
	    font.setFontHeight((short) (charUnitWidth*1.5));
	    blackFont_title_18.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    blackFont_title_18.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    blackFont_title_18.setFont(font);		
		return blackFont_title_18;
	}
	
	/** 创建红色体14点标题样式 */
	public HSSFCellStyle getredtitle(){
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
		font.setBoldweight((short) (charUnitWidth*10));
	    font.setFontHeight((short) (charUnitWidth));
	    font.setColor(HSSFColor.RED.index);
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    sunBlod_10.setFont(font);		
		return sunBlod_10;
	}
	
	
	/** 创建宋体朝14点加粗样式 */
	public HSSFCellStyle getSunBold(){
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short) (charUnitWidth*10));
	    font.setFontHeight((short) (charUnitWidth));
	    sunBlod_10.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
	    sunBlod_10.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
	    sunBlod_10.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		return sunBlod_10;
	}
	
	/** 创建宋体朝14点加粗样式 */
	public HSSFCellStyle getSunBoldB(){
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short) (charUnitWidth*10));
	    font.setFontHeight((short) (charUnitWidth));
	    sunBlod_10.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 指定单元格居中对齐
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
	    sunBlod_10.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
	    sunBlod_10.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		return sunBlod_10;
	}
	
	/** 黑体无背景创建宋体朝14点加粗样式 */
	public HSSFCellStyle getBold(){
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short) (charUnitWidth*10));
	    font.setFontHeight((short) (charUnitWidth));
	    sunBlod_10.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
		return sunBlod_10;
	}
	
	
	/** 创建普通单元格样式 */
	public HSSFCellStyle getNormalStyle(){
		normalStyle = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short)0);
	    font.setFontHeight((short) (charUnitWidth));
	    normalStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    normalStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	    normalStyle.setBottomBorderColor(HSSFColor.BLACK.index);
	    normalStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    normalStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    normalStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    normalStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    normalStyle.setWrapText(true);//自动换行
	    normalStyle.setFont(font);		
		return normalStyle;
	}
	
	/** 红字无边框样式 有背景色*/
	public HSSFCellStyle getredBold(){
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short) (charUnitWidth*2.5));
	    font.setFontHeight((short) (charUnitWidth*1));
	    font.setColor(HSSFColor.RED.index);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
		return sunBlod_10;
	}
	
	/** 红字有边框样式 有背景色*/
	public HSSFCellStyle getredBoldB(){
		//normalStyle = book.createCellStyle();
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
	    font.setBoldweight((short) (charUnitWidth*2.5));
	    font.setFontHeight((short) (charUnitWidth*1));
	    font.setColor(HSSFColor.RED.index);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_LEFT);
	    sunBlod_10.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
	    sunBlod_10.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
		return sunBlod_10;
	}
	/** 红字有边框样式无背景色 */
	public HSSFCellStyle getredB(){
		//normalStyle = book.createCellStyle();
		sunBlod_10 = book.createCellStyle();
		HSSFFont font = book.createFont();
		font.setFontName("宋体");
		font.setBoldweight((short)0);
	    font.setFontHeight((short) (charUnitWidth*1));
	    font.setColor(HSSFColor.RED.index);
	    sunBlod_10.setWrapText(true);//自动换行
	    sunBlod_10.setFont(font);	
	    sunBlod_10.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderRight(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setBorderTop(HSSFCellStyle.BORDER_THIN);
	    sunBlod_10.setAlignment(HSSFCellStyle.ALIGN_LEFT);
	    sunBlod_10.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐 
	    sunBlod_10.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
		return sunBlod_10;
	}
}
