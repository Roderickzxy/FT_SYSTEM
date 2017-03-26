package codeGenerate.factory;

import codeGenerate.CommonPageParser;
import codeGenerate.CreateBean;
import codeGenerate.def.CodeResourceUtil;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;

public class CodeGenerateFactory
{
  private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);
  private static String url = CodeResourceUtil.URL;
  private static String username = CodeResourceUtil.USERNAME;
  private static String passWord = CodeResourceUtil.PASSWORD;

  private static String buss_package = CodeResourceUtil.bussiPackage;
  private static String projectPath = getProjectPath();

  
  public static void codeGenerate(String tableName, String codeName, String controllerEntityPackage, String keyType){
	  codeGenerate(tableName, codeName,"", controllerEntityPackage, keyType);
  }
  
  
  public static void codeGenerate(String tableName, String codeName, String entityPackage, String controllerEntityPackage, String keyType)
  {
    CreateBean createBean = new CreateBean();
    createBean.setMysqlInfo(url, username, passWord);

    String className = createBean.getTablesNameToClassName(tableName);
    className = className.substring(2);//去掉表格前面的tb
    String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

    String srcPath = projectPath + CodeResourceUtil.source_root_package + "\\";

    String pckPath = srcPath + CodeResourceUtil.bussiPackageUrl + "\\";

    String webPath = projectPath + CodeResourceUtil.web_root_package + "\\jsp\\";
    String entityPath=(entityPackage==null||"".equals(entityPackage))?"": entityPackage + "\\";
    String cPath=(controllerEntityPackage==null||"".equals(controllerEntityPackage))?"": controllerEntityPackage + "\\";
    
    String beanPath = "entity\\" + entityPath + className + ".java";
    String servicePath = "service\\" + entityPath + className + "Service.java";
    String serviceImplPath = "service\\impl\\" + entityPath + className + "ServiceImpl.java";
    String controllerPath = "controller\\" + className + "Controller.java";
    String sqlMapperPath = "mybatis\\" + entityPath + className + "Mapper.xml";
    String javaMapperPath = "mapper\\" + entityPath + className + "Mapper.java";
    webPath = webPath + entityPath;

    String jspPath = lowerName + ".jsp";

    VelocityContext context = new VelocityContext();
    context.put("className", className);
    context.put("lowerName", lowerName);
    context.put("codeName", codeName);
    context.put("tableName", tableName);
    context.put("bussPackage", buss_package);
    context.put("entityPackage", entityPackage==""?null:entityPackage);
    context.put("controllerEntityPackage", controllerEntityPackage==""?null:controllerEntityPackage);
    context.put("keyType", keyType);
    try
    {
      context.put("feilds", createBean.getBeanFeilds(tableName));
    } catch (Exception e) {
      e.printStackTrace();
    }

    try
    {
      Map sqlMap = createBean.getAutoCreateSql(tableName);
      context.put("columnDatas", createBean.getColumnDatas(tableName));
      context.put("SQL", sqlMap);
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    CommonPageParser.WriterPage(context, "EntityTemplate.ftl", pckPath, beanPath);
    CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", pckPath, servicePath);
    CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", pckPath, serviceImplPath);
    CommonPageParser.WriterPage(context, "MapperTemplate.xml", srcPath, sqlMapperPath);
    CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", pckPath, controllerPath);
    CommonPageParser.WriterPage(context, "EntityMapperTemplate.ftl", pckPath, javaMapperPath);

   // CommonPageParser.WriterPage(context, "jspTemplate.ftl", webPath, jspPath);

    log.info("----------------------------\u4EE3\u7801\u751F\u6210\u5B8C\u6BD5---------------------------");
  }

  public static String getProjectPath()
  {
    String path = System.getProperty("user.dir").replace("\\", "/") + "/";
    return path;
  }
}