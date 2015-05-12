package com.dihaitech.wxshop.common;

/**
 * 系统公用属性类，属性对应product.properties中系统部分的属性
 * 
 * @author qiusen
 * 
 */
public class Property {

	/**
	 * 系统 web 路径 (eg: http://www.mysystem.com )
	 */
	public static String BASE;

	/** 每页显示的信息条目，默认显示20条信息每页。properties文件中读取 */
	public static int PAGESIZE = 10;

	/** Action的扩展名 */
	public static String ACTION_EXT;

	/** request字符集 */
	public static String CHARSET;

	/** 公司名称 */
	public static String COMP_NAME;

	/**
	 * 系统名称
	 */
	public static String SYSTEM_NAME;

	/**
	 * 一级域名
	 */
	public static String SYSTEM_TOP_DOMAIN;
	/**
	 * 文件保存路径
	 */
	public static String FILE_PATH;

	/**
	 * 文件访问路径
	 */
	public static String APP_PATH;

	/**
	 * 图片相对路径
	 */
	public static String IMG_RELATIVE_PATH;

	/**
	 * 其他文件保存路径
	 */
	public static String MISC_FILE_PATH;

	/**
	 * 其他文件访问路径
	 */
	public static String MISC_APP_PATH;

	/**
	 * 白色背景图位置,ImageMagick+jmagick图片处理时使用
	 */
	public static String BG_IMG_PATH;

	/**
	 * 产品图片压缩尺寸，格式如：800x800,600x600,300x300,100x100
	 */
	public static String PRODUCT_IMGSIZE_ARRAY;

	/**
	 * 产品图片文件地址
	 */
	public static String PRODUCT_IMGFILEPATH;

	/**
	 * 产品图片访问地址
	 */
	public static String PRODUCT_IMGAPPPATH;
	
	/**
	 * 默认数据源数据库名称
	 */
	public static String DEFAULT_SCHEMA;
	
	/**
	 * 文件上传物理根目录
	 */
	public static String FILE_UPLOAD_ROOTPATH;
	
	/**
	 * 文件访问地址
	 */
	public static String FILE_UPLOAD_ROOTURL;
	
	/**
	 * 图片存放的子目录
	 */
	public static String FILE_IMAG_UPLOADPATH;
	
	/**
	 * 允许图片上传的最大占用空间，单位：兆（M）
	 */
	public static String FILE_IMAG_MAXSIZE;
	
	/**
	 * 允许图片上传的文件格式 多种格式之间逗号分隔
	 */
	public static String FILE_IMAG_TYPES;
	
	
	/* 块相关内容 
	 * #块发布绝对地址
		block.publish.path=/myfile/workspaceutf8/acomp/webapp/block/
		#块引用地址
		block.include.path=/block/
		#自动块文件夹
		block.automatic.folder=automatic
		#手动块文件夹
		block.manual.folder=manual
		#友链块文件夹
		block.link.folder=link
	 * 
	 * */
	
	/**
	 * 块发布绝对地址
	 */
	public static String FILE_PUBLISH_PATH;
	
	/**
	 * 块文件夹
	 */
	public static String BLOCK_FOLDER;
	
	/**
	 * 块引用地址
	 */
	public static String BLOCK_INCLUDE_PATH;
	
	/**
	 * 自动块文件夹
	 */
	public static String BLOCK_AUTOMATIC_FOLDER;
	
	/**
	 * 手动块文件夹
	 */
	public static String BLOCK_MANUAL_FOLDER;
	
	/**
	 * 友链块文件夹
	 */
	public static String BLOCK_LINK_FOLDER;
	
	
	/*
	 * #管理中心接口地址
	 * managercenter.host=localhost
	 * #管理中心接口端口
	 * managercenter.port=19090
	 * #管理中心地址
	 * managercenter.url=http://localhost:8080/managercenter
	 * 
	 * */
	
	/**
	 * 管理中心接口地址
	 */
	public static String MANAGERCENTER_HOST;
	
	/**
	 * 管理中心接口端口
	 */
	public static int MANAGERCENTER_PORT;
	
	/**
	 * 管理中心地址
	 */
	public static String MANAGERCENTER_URL;

	public String getBASE() {
		return BASE;
	}

	public static void setBASE(String bASE) {
		BASE = bASE;
	}

	/**
	 * @return the dEFAULT_SCHEMA
	 */
	public static String getDEFAULT_SCHEMA() {
		return DEFAULT_SCHEMA;
	}

	/**
	 * @param dEFAULT_SCHEMA the dEFAULT_SCHEMA to set
	 */
	public static void setDEFAULT_SCHEMA(String dEFAULT_SCHEMA) {
		DEFAULT_SCHEMA = dEFAULT_SCHEMA;
	}

	public String getACTION_EXT() {
		return ACTION_EXT;
	}

	public static void setACTION_EXT(String aCTIONEXT) {
		ACTION_EXT = aCTIONEXT;
	}

	public String getCHARSET() {
		return CHARSET;
	}

	public static void setCHARSET(String cHARSET) {
		CHARSET = cHARSET;
	}

	public String getCOMP_NAME() {
		return COMP_NAME;
	}

	public static void setCOMP_NAME(String cOMPNAME) {
		COMP_NAME = cOMPNAME;
	}

	public static String getSYSTEM_TOP_DOMAIN() {
		return SYSTEM_TOP_DOMAIN;
	}

	public static void setSYSTEM_TOP_DOMAIN(String sYSTEM_TOP_DOMAIN) {
		SYSTEM_TOP_DOMAIN = sYSTEM_TOP_DOMAIN;
	}

	public String getSYSTEM_NAME() {
		return SYSTEM_NAME;
	}

	public static void setSYSTEM_NAME(String sYSTEMNAME) {
		SYSTEM_NAME = sYSTEMNAME;
	}

	public String getMISC_FILE_PATH() {
		return MISC_FILE_PATH;
	}

	public static void setMISC_FILE_PATH(String mISCFILEPATH) {
		MISC_FILE_PATH = mISCFILEPATH;
	}

	public String getMISC_APP_PATH() {
		return MISC_APP_PATH;
	}

	public static void setMISC_APP_PATH(String mISCAPPPATH) {
		MISC_APP_PATH = mISCAPPPATH;
	}

	public String getFILE_PATH() {
		return FILE_PATH;
	}

	public static void setFILE_PATH(String fILEPATH) {
		FILE_PATH = fILEPATH;
	}

	public String getAPP_PATH() {
		return APP_PATH;
	}

	public static void setAPP_PATH(String aPPPATH) {
		APP_PATH = aPPPATH;
	}

	public String getIMG_RELATIVE_PATH() {
		return IMG_RELATIVE_PATH;
	}

	public static void setIMG_RELATIVE_PATH(String iMGRELATIVEPATH) {
		IMG_RELATIVE_PATH = iMGRELATIVEPATH;
	}

	public String getBG_IMG_PATH() {
		return BG_IMG_PATH;
	}

	public static void setBG_IMG_PATH(String bGIMGPATH) {
		BG_IMG_PATH = bGIMGPATH;
	}

	public String getPRODUCT_IMGSIZE_ARRAY() {
		return PRODUCT_IMGSIZE_ARRAY;
	}

	public static void setPRODUCT_IMGSIZE_ARRAY(String pRODUCTIMGSIZEARRAY) {
		PRODUCT_IMGSIZE_ARRAY = pRODUCTIMGSIZEARRAY;
	}

	public String getPRODUCT_IMGFILEPATH() {
		return PRODUCT_IMGFILEPATH;
	}

	public static void setPRODUCT_IMGFILEPATH(String pRODUCTIMGFILEPATH) {
		PRODUCT_IMGFILEPATH = pRODUCTIMGFILEPATH;
	}

	public String getPRODUCT_IMGAPPPATH() {
		return PRODUCT_IMGAPPPATH;
	}

	public static void setPRODUCT_IMGAPPPATH(String pRODUCTIMGAPPPATH) {
		PRODUCT_IMGAPPPATH = pRODUCTIMGAPPPATH;
	}

	public static String getFILE_UPLOAD_ROOTPATH() {
		return FILE_UPLOAD_ROOTPATH;
	}

	public static void setFILE_UPLOAD_ROOTPATH(String fILE_UPLOAD_ROOTPATH) {
		FILE_UPLOAD_ROOTPATH = fILE_UPLOAD_ROOTPATH;
	}

	public static String getFILE_UPLOAD_ROOTURL() {
		return FILE_UPLOAD_ROOTURL;
	}

	public static void setFILE_UPLOAD_ROOTURL(String fILE_UPLOAD_ROOTURL) {
		FILE_UPLOAD_ROOTURL = fILE_UPLOAD_ROOTURL;
	}

	public static String getFILE_IMAG_UPLOADPATH() {
		return FILE_IMAG_UPLOADPATH;
	}

	public static void setFILE_IMAG_UPLOADPATH(String fILE_IMAG_UPLOADPATH) {
		FILE_IMAG_UPLOADPATH = fILE_IMAG_UPLOADPATH;
	}

	public static String getFILE_IMAG_MAXSIZE() {
		return FILE_IMAG_MAXSIZE;
	}

	public static void setFILE_IMAG_MAXSIZE(String fILE_IMAG_MAXSIZE) {
		FILE_IMAG_MAXSIZE = fILE_IMAG_MAXSIZE;
	}

	public static String getFILE_IMAG_TYPES() {
		return FILE_IMAG_TYPES;
	}

	public static void setFILE_IMAG_TYPES(String fILE_IMAG_TYPES) {
		FILE_IMAG_TYPES = fILE_IMAG_TYPES;
	}

	

	public static String getFILE_PUBLISH_PATH() {
		return FILE_PUBLISH_PATH;
	}

	public static void setFILE_PUBLISH_PATH(String fILE_PUBLISH_PATH) {
		FILE_PUBLISH_PATH = fILE_PUBLISH_PATH;
	}

	public static String getBLOCK_FOLDER() {
		return BLOCK_FOLDER;
	}

	public static void setBLOCK_FOLDER(String bLOCK_FOLDER) {
		BLOCK_FOLDER = bLOCK_FOLDER;
	}

	public static String getBLOCK_INCLUDE_PATH() {
		return BLOCK_INCLUDE_PATH;
	}

	public static void setBLOCK_INCLUDE_PATH(String bLOCK_INCLUDE_PATH) {
		BLOCK_INCLUDE_PATH = bLOCK_INCLUDE_PATH;
	}

	public static String getBLOCK_AUTOMATIC_FOLDER() {
		return BLOCK_AUTOMATIC_FOLDER;
	}

	public static void setBLOCK_AUTOMATIC_FOLDER(String bLOCK_AUTOMATIC_FOLDER) {
		BLOCK_AUTOMATIC_FOLDER = bLOCK_AUTOMATIC_FOLDER;
	}

	public static String getBLOCK_MANUAL_FOLDER() {
		return BLOCK_MANUAL_FOLDER;
	}

	public static void setBLOCK_MANUAL_FOLDER(String bLOCK_MANUAL_FOLDER) {
		BLOCK_MANUAL_FOLDER = bLOCK_MANUAL_FOLDER;
	}

	public static String getBLOCK_LINK_FOLDER() {
		return BLOCK_LINK_FOLDER;
	}

	public static void setBLOCK_LINK_FOLDER(String bLOCK_LINK_FOLDER) {
		BLOCK_LINK_FOLDER = bLOCK_LINK_FOLDER;
	}

	public static int getPAGESIZE() {
		return PAGESIZE;
	}

	public static void setPAGESIZE(int pAGESIZE) {
		PAGESIZE = pAGESIZE;
	}

	public static String getMANAGERCENTER_HOST() {
		return MANAGERCENTER_HOST;
	}

	public static void setMANAGERCENTER_HOST(String mANAGERCENTER_HOST) {
		MANAGERCENTER_HOST = mANAGERCENTER_HOST;
	}

	public static int getMANAGERCENTER_PORT() {
		return MANAGERCENTER_PORT;
	}

	public static void setMANAGERCENTER_PORT(int mANAGERCENTER_PORT) {
		MANAGERCENTER_PORT = mANAGERCENTER_PORT;
	}

	public static String getMANAGERCENTER_URL() {
		return MANAGERCENTER_URL;
	}

	public static void setMANAGERCENTER_URL(String mANAGERCENTER_URL) {
		MANAGERCENTER_URL = mANAGERCENTER_URL;
	}

}
