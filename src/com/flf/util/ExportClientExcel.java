package com.flf.util;



import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.flf.entity.Customer;
import com.flf.entity.Transactionflow;

/*************************************************
 * 功能描述：批量客户交易流水（Excel报告）
 * @author  郑少涛
 * @version 1.0 2015-01-15
 *************************************************/
public class ExportClientExcel {

//	BaseDAO dao = null;//数据连接类
//		List<TbClient> clientList=null;//结果列表
	
//	//构造函数
//	public ExportClientExcel(BaseDAO dao, String filePath, List<TbClient> clientList) {
//		this.dao = dao;
//		this.filePath = filePath;
//		this.clientList = clientList;
//	}
	
	//处理逻辑业务
	public static boolean createExcel(List<Transactionflow> transactionflowList,Customer customer) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		HSSFWorkbook wb = null;
		FileOutputStream fileOut = null;
		
		//操作工作表（循环工作表--第二行以下）
		String index="";
		String tradate="";
		String tratime="";
		String bankname="";
		String operate="";
		String curtype="";
		String amount="";
		String status ="成功";
		
        try {
        	//获取Workbook对像
            wb = new HSSFWorkbook();
            //创建工作表
            HSSFSheet sheet = wb.createSheet("客户交易流水");
            //256表示一个半角字符的宽度
      		short charUnitWidth = 260;
            //设置表格默认列宽度
  	        sheet.setColumnWidth((short)0,(short)(charUnitWidth*20));
  	        sheet.setColumnWidth((short)1, (short)(charUnitWidth*18));
  	        sheet.setColumnWidth((short)2,(short) (charUnitWidth*20));
  	        sheet.setColumnWidth((short)3,(short)(charUnitWidth*12));
  	        sheet.setColumnWidth((short)4,(short)(charUnitWidth*30));
  	        sheet.setColumnWidth((short)5,(short)(charUnitWidth*30));
  	        sheet.setColumnWidth((short)6,(short)(charUnitWidth*15));
  	        sheet.setColumnWidth((short)7,(short)( charUnitWidth*10));
  	        
  	        //设置工作表样式
		    ExcelStyles excelStyles = new ExcelStyles(wb); //创建EXCEL样式生成器
		    HSSFCellStyle smallTitleStyle=null;
		    HSSFCellStyle smallTitleStyle1 = excelStyles.getNormalStyle();
		    
		    //创建标题行
            HSSFRow  row = sheet.createRow(0);//第0行是标题
		    row.setHeight((short)(charUnitWidth*2));
			HSSFCell cell = row.createCell((short)0);
		    HSSFCellStyle titleStyle = excelStyles.getBlackFont_Title_18();
		    cell.setCellStyle(titleStyle);
		    cell.setCellValue("客户交易流水");//标题（此处修改成自己的表头标题）
		    Region region = new Region();
		    region.setRowFrom(0);
		    region.setRowTo(0);
		    region.setColumnFrom((short)0);
		    region.setColumnTo((short)2);
		    sheet.addMergedRegion(region);
		    
//		 
//		    sheet.addMergedRegion(new Region());//标题占8个单元格（合并单元格，和列数对应）
//		   //小标题行
/*		    HSSFRow row1 = sheet.createRow(1);//第0行是标题
		    row1.setHeight((short)(charUnitWidth*2));
		    HSSFCell cell1 = row1.createCell(0);
		    cell1.setCellStyle(excelStyles.getSunBoldB());
//		    sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
		    cell1.setCellValue("班级："+arrange.getClassCourse().getCourseClass().getClassName().replaceAll(" ", ""));
		    Cell cell2 = row1.createCell(4);
		    cell2.setCellStyle(excelStyles.getSunBoldB());
		    sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, 6));
		    cell2.setCellValue("作业题目："+arrange.getItem().getTopic().replaceAll(" ", ""));
           */ 
		    //设置Excel工作表的title数组
        	String rowsTitle[]=new String[]{"序号","日期","成交时间","银行名称","操作","货币单位","发生金额","状态"};
        	int rowTitleLen=rowsTitle.length;
        	
        	//设置工作表表头
        	row = sheet.createRow(1);//第一行
        	row.setHeight((short)(charUnitWidth*2.5));
		    smallTitleStyle = excelStyles.getSunBold();	
		    for(short i=0;i<rowTitleLen;i++){ 
    			cell = row.createCell(i);
    	        cell.setCellStyle(smallTitleStyle);
    	        HSSFRichTextString text = new HSSFRichTextString(rowsTitle[i]);
    	        cell.setCellValue(text);
    		}
    		
    		//循环生成数据行
	        if (transactionflowList != null && transactionflowList.size() > 0) {
	        	int rows = transactionflowList.size();
		        for (short r = (short)1; r <=rows; r++) {//循环每一行
		        	row = sheet.createRow(r+1);//得到单元格第二行（此处要注意：第一行数据应该套在表格的第二行上）
		        	row.setHeight((short)(charUnitWidth*1.8));
		        	
		        	//写入Excel工作表
		        	Transactionflow tempInfo = transactionflowList.get(r-1);
		        	if(tempInfo!=null){
			        	if(tempInfo.getTradate()!=null)tradate = bartDateFormat.format(tempInfo.getTradate()).toString();//成交日期
			        	if(tempInfo.getTratime()!=null)tratime = sdf.format(tempInfo.getTratime()).toString();//成交时间
			        	if(tempInfo.getBankname()!=null)bankname = tempInfo.getBankname();//银行名称
			        	if(tempInfo.getOperate()!=null)operate=tempInfo.getOperate();//操作
			        	if(tempInfo.getCurtype()!=null)curtype=tempInfo.getCurtype();//货币单位
			        	if(tempInfo.getAmount()!=null)amount=tempInfo.getAmount().toString();//发送金额
			        	if(tempInfo.getStatus()!=null)status=tempInfo.getStatus();//发送金额
					       
		        	}
		        	
		        	//设置数据里面单元样式
		        	HSSFCell data[] = new HSSFCell[rowTitleLen];
		      	for (short j = (short)0; j < rowTitleLen; j++) {
		        		data[j] = (HSSFCell) row.createCell((short)j);
		        		data[j].setCellType (HSSFCell.CELL_TYPE_STRING);
		        	    data[j].setCellStyle(smallTitleStyle1);
			        	}
		        	//单元格赋值
		        	data[0].setCellValue(r);//序号
		        	data[1].setCellValue(tradate);//交易日期
		        	data[2].setCellValue(tratime);//交易时间
		        	data[3].setCellValue(bankname);//银行名称
		        	data[4].setCellValue(operate);//操作
		        	data[5].setCellValue(curtype);//货币单位
		        	data[6].setCellValue(amount);//发生金额
		        	data[7].setCellValue(status);//状态
		        }
	        }

	        //写入工作表
	        if(CommonConstant.HOME_PATH!=null&&!CommonConstant.HOME_PATH.equals("")){
	        	fileOut = new FileOutputStream(new File(CommonConstant.HOME_PATH+ File.separator+customer.getName()+"_交易流水.xls"));
	        	wb.write(fileOut);
	        }
			fileOut.close(); 
		
         } catch (Exception e) {  
           e.printStackTrace();  
        }  
        return true;
	}
}
