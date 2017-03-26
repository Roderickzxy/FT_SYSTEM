package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>${className}Entity<br>
 */
public class ${className}{
	
	private Page page;//分页用
	
	${feilds}
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}

