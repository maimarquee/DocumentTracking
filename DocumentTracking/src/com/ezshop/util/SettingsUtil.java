package com.ezshop.util;

import com.mytechnopal.util.BaseSettingsUtil;
import com.mytechnopal.util.StringUtil;

public class SettingsUtil extends BaseSettingsUtil {
	private static final long serialVersionUID = 1L;

	//current settings path
	public static final String SETTINGS_PROPERTY_PATH = "com.ezshop.property.Settings";
	
	public static final String BUILD_SERIAL_NUM = StringUtil.getResourceBundleValue("BUILD_SERIAL_NUM", SETTINGS_PROPERTY_PATH);
	
	public static final String OWNER_CODE = StringUtil.getResourceBundleValue("OWNER_CODE", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_NAME = StringUtil.getResourceBundleValue("OWNER_NAME", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_NAME_SHORTCUT = StringUtil.getResourceBundleValue("OWNER_NAME_SHORTCUT", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_ADDRESS = StringUtil.getResourceBundleValue("OWNER_ADDRESS", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_CONTACT_NUMBER = StringUtil.getResourceBundleValue("OWNER_CONTACT_NUMBER", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_WEBSITE = StringUtil.getResourceBundleValue("OWNER_WEBSITE", SETTINGS_PROPERTY_PATH);
	public static final String OWNER_LOGO = StringUtil.getResourceBundleValue("OWNER_LOGO", SETTINGS_PROPERTY_PATH);
	
	public static final String DEFAULT_CITY = StringUtil.getResourceBundleValue("DEFAULT_CITY", SETTINGS_PROPERTY_PATH);
	public static final String DEFAULT_RELIGION = StringUtil.getResourceBundleValue("DEFAULT_RELIGION", SETTINGS_PROPERTY_PATH);
	
	public static final String USER_GROUP_GUEST_CODE = StringUtil.getResourceBundleValue("USER_GROUP_GUEST_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_ADMIN_CODE = StringUtil.getResourceBundleValue("USER_GROUP_ADMIN_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_STUDENT_CODE = StringUtil.getResourceBundleValue("USER_GROUP_STUDENT_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_GUARDIAN_CODE = StringUtil.getResourceBundleValue("USER_GROUP_GUARDIAN_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_TEACHER_CODE = StringUtil.getResourceBundleValue("USER_GROUP_TEACHER_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_STAFF_CODE = StringUtil.getResourceBundleValue("USER_GROUP_STAFF_CODE", SETTINGS_PROPERTY_PATH);
	public static final String USER_GROUP_SUPPLIER_CODE = StringUtil.getResourceBundleValue("USER_GROUP_SUPPLIER_CODE", SETTINGS_PROPERTY_PATH);
	
	public static final String FOOTER = OWNER_WEBSITE + " | " + StringUtil.getResourceBundleValue("FOOTER", SETTINGS_PROPERTY_PATH);
}
