/**
 * Copyright(C) 2020 Luvina Software Company
 * ,Constant,15-07-2020, HuyLQ
 * 	
 */
package manageuser.utils;
public class Constant {
	/*
	 * 
	 */
	public static final String TBL_USER = DataBaseProperties.getValueByKey("TBL_USER");
	public static final String DATABASE = DataBaseProperties.getValueByKey("DATABASE");
	public static final String PASSWORD_DB= DataBaseProperties.getValueByKey("PASSWORD");
	public static final String CL_DRIVER = DataBaseProperties.getValueByKey("CL_DRIVER");
	public static final String USER_DB = DataBaseProperties.getValueByKey("USER_DB");
	public static final String URL = DataBaseProperties.getValueByKey("URL")+DATABASE;
	public static final int ADMIN_RULE = 1;
	public static final String PROPERTIES_MESSAGE_PATH = "/manageuser/utils/MessageError.properties";
	public static final String PROPERTIES_DATABASE_PATH = "/manageuser/utils/DatatBase.properties";
	public static final String MST_GROUP = DataBaseProperties.getValueByKey("MST_GROUP");
	public static final String TBL_DETAIL_USER_JAPAN = DataBaseProperties.getValueByKey("TBL_DETAIL_USER_JAPAN");
	public static final String MST_JAPAN = DataBaseProperties.getValueByKey("MST_JAPAN");
}
