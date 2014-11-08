package com.multivision.ehrms.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;


/**
 * The Class CommonUtil.
 */
public class CommonUtil {


	/**
	 * Data upload.
	 * 
	 * @param request the request
	 * @param path the path
	 * @param fileName the file name
	 * @param formFile the form file
	 * 
	 * @return the string
	 * 
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public String dataUpload(HttpServletRequest request, String path,
			String fileName, FormFile formFile) throws FileNotFoundException,
			IOException, Exception {
		String value=File.separator+"usr"+File.separator+"share"+File.separator+"eHRMS"+File.separator+"upload"+path;
		FileOutputStream fos = null;
		byte[] fileData = formFile.getFileData();

		if (!new File(value).exists()) {
			new File(value).mkdirs();
		}
		try {
			fos = new FileOutputStream(value + fileName);
			fos.write(fileData);
			fos.flush();
		}

		catch (Exception e) {
			throw e;
		} finally {
			fos.close();
		}
		return value + fileName;
	}

	/**
	 * File download.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param path the path
	 * @param fileName the file name
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public void fileDownload(HttpServletRequest request,
			HttpServletResponse response, String path, String fileName)
			throws IOException, Exception {

		BufferedInputStream in = null;
		ServletOutputStream out = null;
		try {
			File filedownload = new File(path);
			long fileLen = filedownload.length();
			response.setContentType("application/pdf");
			response.setContentLength((int) fileLen);
			response.setHeader("Content-disposition", "attachment; filename="+File.separator
					+ fileName);
			FileInputStream fis = new FileInputStream(filedownload);
			in = new BufferedInputStream(fis);
			out = response.getOutputStream();
			byte[] buffer = new byte[4 * 1024];
			int data;
			while ((data = in.read(buffer)) != -1) {
				out.write(buffer, 0, data);
			}
			out.flush();

		} catch (Exception e) {
			throw e;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (Exception e) {
					throw e;
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
	}
	
	
	public void xlsDownload(HttpServletRequest request,
			HttpServletResponse response, String path, String fileName)
			throws IOException, Exception {

		BufferedInputStream in = null;
		ServletOutputStream out = null;
		try {
			File filedownload = new File(path);
			long fileLen = filedownload.length();
			response.setContentType("application/xls");
			response.setContentLength((int) fileLen);
			response.setHeader("Content-disposition", "attachment; filename="+File.separator
					+ fileName);
			FileInputStream fis = new FileInputStream(filedownload);
			in = new BufferedInputStream(fis);
			out = response.getOutputStream();
			byte[] buffer = new byte[4 * 1024];
			int data;
			while ((data = in.read(buffer)) != -1) {
				out.write(buffer, 0, data);
			}
			out.flush();

		} catch (Exception e) {
			throw e;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (Exception e) {
					throw e;
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
	}
	
}
