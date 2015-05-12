package com.dihaitech.wxshop.controller.servlet.kindeditor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.dihaitech.wxshop.common.Property;
import com.dihaitech.wxshop.util.FileUtil;

public class UploadJsonServlet extends HttpServlet {

	private static final long serialVersionUID = 5565834746077615484L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文件保存目录路径
		String savePath = Property.MISC_FILE_PATH + "/";

		// 文件保存目录URL
		String saveUrl = Property.MISC_APP_PATH + "/";

		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		// 最大文件大小 10M
		long maxSize = 10000000;

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = response.getWriter();
		if (!ServletFileUpload.isMultipartContent(request)) {
			pw.println(getError("请选择文件。"));
			return;
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			// pw.println(getError("上传目录不存在。"));
			// return;
			boolean res = uploadDir.mkdirs();
			if (!res)
				throw new IOException();
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			pw.println(getError("上传目录没有写权限。"));
			return;
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			pw.println(getError("目录名不正确。"));
			return;
		}
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			boolean res = saveDirFile.mkdirs();
			if (!res)
				throw new IOException();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			boolean res = dirFile.mkdirs();
			if (!res)
				throw new IOException();
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
//		System.out.println("0000000000000000000");

		MultiPartRequestWrapper wrapper = null;
		File[] files = null;
		String[] filenames = null;
		if (request instanceof MultiPartRequestWrapper)
			wrapper = (MultiPartRequestWrapper) request;
		if (null != wrapper) {
			files = wrapper.getFiles("imgFile");
			filenames = wrapper.getFileNames("imgFile");
		}
		
//		System.out.println("0000000000-------000000000");
		if (files != null && files.length > 0) {
//			System.out.println("0000000000---1111111111---000000000");
			for (int i = 0; i < files.length; i++) {
				File fileItem = files[i];
				String fileName = filenames[i];

				// long fileSize = fileItem.length();
				// if (!item.isFormField()) {
				// 检查文件大小
				if (fileItem.length() > maxSize) {
					pw.println(getError("上传文件大小超过限制。"));
					return;
				}
//				System.out.println("111111111111111" + fileName);
				// 检查扩展名
				String fileExt = fileName.substring(
						fileName.lastIndexOf('.') + 1).toLowerCase();

//				System.out.println("fileExt::::::::::::" + fileExt);
				if (!Arrays.<String> asList(extMap.get(dirName).split(","))
						.contains(fileExt)) {
					pw.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
							+ extMap.get(dirName) + "格式。"));
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_"
						+ new Random().nextInt(1000) + "." + fileExt;

				File uploadedFile = new File(savePath, newFileName);
				// item.write(uploadedFile);
				FileUtil.uploadFile(fileItem, uploadedFile);

//				System.out.println("222222222222222222");
				JSONObject obj = new JSONObject();
				obj.put("error", 0);
				obj.put("url", saveUrl + newFileName);
				// out.println(obj.toJSONString());
				pw.println(obj.toString());
				// }
			}
		}
		/*
		 * try { List items = upload.parseRequest(request);
		 * System.out.println("items.size:::::::::::" + items.size()); Iterator
		 * itr = items.iterator(); while (itr.hasNext()) { FileItem item =
		 * (FileItem) itr.next(); String fileName = item.getName(); long
		 * fileSize = item.getSize(); if (!item.isFormField()) { //检查文件大小
		 * if(item.getSize() > maxSize){ pw.println(getError("上传文件大小超过限制。"));
		 * return; } System.out.println("111111111111111"); //检查扩展名 String
		 * fileExt = fileName.substring(fileName.lastIndexOf(".") +
		 * 1).toLowerCase();
		 * if(!Arrays.<String>asList(extMap.get(dirName).split(
		 * ",")).contains(fileExt)){ pw.println(getError("上传文件扩展名是不允许的扩展名。\n只允许"
		 * + extMap.get(dirName) + "格式。")); return; }
		 * 
		 * SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); String
		 * newFileName = df.format(new Date()) + "_" + new
		 * Random().nextInt(1000) + "." + fileExt; try{
		 * System.out.println(savePath+newFileName); File uploadedFile = new
		 * File(savePath, newFileName); item.write(uploadedFile);
		 * }catch(Exception e){ pw.println(getError("上传文件失败。")); return; }
		 * 
		 * System.out.println("222222222222222222"); JSONObject obj = new
		 * JSONObject(); obj.put("error", 0); obj.put("url", saveUrl +
		 * newFileName); // out.println(obj.toJSONString());
		 * pw.println(obj.toString()); } } } catch (Exception e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */

	}

	private static String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		// return obj.toJSONString();
		return obj.toString();
	}

	public static void main(String[] args) {
		System.out.println(getError("kwg kwg 哈哈"));
	}
}
