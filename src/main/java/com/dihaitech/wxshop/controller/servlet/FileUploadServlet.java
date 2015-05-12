package com.dihaitech.wxshop.controller.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.dihaitech.wxshop.common.Property;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1102734277035137464L;

	private String rootPath;
	private String imgUploadPath;
	private String fileURL;
	private int fileMaxSize;
	private String fileTypes;

	public void init() throws ServletException {
		// 文件服务器分配的地址
		rootPath = Property.FILE_UPLOAD_ROOTPATH;
		// 用于存放上传文件的地址
		imgUploadPath = Property.FILE_IMAG_UPLOADPATH;
		// 用于存放上传后的访问地址
		fileURL = Property.FILE_UPLOAD_ROOTURL;
		// 获取文件大小(单位:M);
		fileMaxSize = new Integer(Property.FILE_IMAG_MAXSIZE);
		// 获取图片文件类型
		fileTypes = Property.FILE_IMAG_TYPES;
		
		//图片的访问地址
		fileURL = fileURL + imgUploadPath;
		//图片上传的物理路径
		imgUploadPath = rootPath + File.separator + imgUploadPath;
		
		// 文件夹不存在就自动创建：
		if (!new File(rootPath).isDirectory())
			new File(rootPath).mkdirs();
		if (!new File(imgUploadPath).isDirectory())
			new File(imgUploadPath).mkdirs();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 输出信息
		String message = "";
		// 文件真实存放的地址(带文件名)
		String realFilePath = "";
		String realFileUrl = "";
		String newFileName = "";
		String oldFileName = "";

		PrintWriter pw = response.getWriter();

		MultiPartRequestWrapper multiWrapper = null;
		if (request instanceof MultiPartRequestWrapper) {
			multiWrapper = (MultiPartRequestWrapper) request;
			Enumeration<String> fileParameterNames = multiWrapper.getFileParameterNames();
			while (fileParameterNames != null && fileParameterNames.hasMoreElements()) {
				String inputName = (String) fileParameterNames.nextElement();
				String[] contentType = multiWrapper.getContentTypes(inputName);
				if (isNonEmpty(contentType)) {
					String[] fileName = multiWrapper.getFileNames(inputName);
					if (isNonEmpty(fileName)) {
						File[] files = multiWrapper.getFiles(inputName);
						if (files != null) {
							for (int index = 0; index < files.length; index++) {
								
								if (files[index].length() > (fileMaxSize * 1024 * 1024)) {
									message = "上传文件大小超过" + fileMaxSize + "M限制。";
									break;
								}
								// 检查扩展名
								String fileExt = fileName[index].substring(
										fileName[index].lastIndexOf('.') + 1).toLowerCase();
								if(!fileTypes.contains(fileExt)){
									message = "上传的图片文件扩展名不允许，请上传: "+fileTypes+" 格式的图片";
									break;
								}
								//生成文件的唯一名
								SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
								oldFileName = fileName[index];
								newFileName = df.format(new Date()) + "_"
										+ new Random().nextInt(1000) + "." + fileExt;
								realFileUrl = fileURL + "/" + newFileName;
								realFilePath = imgUploadPath + File.separator + newFileName;
								File dstFile = new File(imgUploadPath + File.separator + newFileName);
								this.copy(files[index], dstFile);
							}
						}else{
							message = "上传失败：上传文件不存在";
						}
					}else{
						message = "上传失败";
					}
				}else{
					message = "上传失败";
				}
			}
		}else{
			message = "上传失败";
		}
		JSONObject result = new JSONObject();
		//message如果为空，则表示上传成功
		result.put("message", message);
		result.put("filePath", realFileUrl);
		result.put("fileRealPath", realFilePath);
		result.put("newFileName", newFileName);
		result.put("oldFileName", oldFileName);
		pw.println(result.toString());
	}

	private static boolean isNonEmpty(Object[] objArray) {
		boolean result = false;
		for (int index = 0; index < objArray.length; index++) {
			if (objArray[index] != null) {
				result = true;
				break;
			}
		}
		return result;
	}

	private void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(src), 1024);
			out = new BufferedOutputStream(new FileOutputStream(dst), 1024);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
