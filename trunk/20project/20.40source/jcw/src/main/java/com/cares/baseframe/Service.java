package com.cares.baseframe;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



public class Service {
	
	
	  public static void main(String[] args) throws IOException {
		  RestTemplate restTemplate = new RestTemplate();
		  MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		  form.add("Content-Type", "multipart/form-data");
		  /* form.add("method", "bag.uploadRemark");
		  form.add("appKey", "00001");
		  form.add("v", "1.0");
		  form.add("sessionId", "52690b97b0ea434dacefcc9d3beeb6bb");
		  form.add("data", "{existFile:true}");*/
		 // com.rop.request.UploadFile uploadFile = new UploadFile(new File("C:/Users/john/Desktop/cPVG.mp4"));//①构造一个上传文件对象
		 // form.add("file","mp4@"+Base64.encodeBase64String(uploadFile.getContent())  );
		  //③调用上传文件服务
	/*	  FileSystemResource resource1 = new FileSystemResource(new File("C:/Users/john/Desktop/avatar-07.png"));  
		  FileSystemResource resource2 = new FileSystemResource(new File("F:/bms/Vido/1477451679941.mp4"));  
		  FileSystemResource resource3 = new FileSystemResource(new File("C:/Users/john/Desktop/avatar-09.png"));*/  
		  FileSystemResource resource4 = new FileSystemResource(new File("C:/avatar-10.png"));  
/*		  form.add("bagNo", "100010");
		  form.add("carrier", "MU");
		  form.add("flightNo", "333");
		  form.add("flightDt", "20161122");
		  form.add("operator", "admn");
		  form.add("remark", "啊哈哈哈");
		  form.add("existFile", "1");*/
		/*  form.add("files", resource1);
		  form.add("files", resource2);
		  form.add("files", resource3);*/
		  form.add("file", resource4);
		  String response = restTemplate.postForObject("http://127.0.0.1:9080/5,019d90e98a", form, String.class);
		  System.out.println("response:/n" + response);
}
	  public static byte[] File2byte(String filePath)  
	    {  
	        byte[] buffer = null;  
	        try  
	        {  
	            File file = new File(filePath);  
	            FileInputStream fis = new FileInputStream(file);  
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	            byte[] b = new byte[1024];  
	            int n;  
	            while ((n = fis.read(b)) != -1)  
	            {  
	                bos.write(b, 0, n);  
	            }  
	            fis.close();  
	            bos.close();  
	            buffer = bos.toByteArray();  
	        }  
	        catch (FileNotFoundException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        catch (IOException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        return buffer;  
	    } 
	
}
