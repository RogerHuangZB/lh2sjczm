package com.cares.baseframe.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;



/**
 * @author hjh
 *
 */
@Component
public class UpLoadFileUtils {

	@Autowired
	MultipartResolver multipartResolver;

	private static UpLoadFileUtils upLoadFileUtils;

	public void setUserInfo(MultipartResolver multipartResolver) {
		this.multipartResolver = multipartResolver;
	}

	@PostConstruct
	public void init() {
		upLoadFileUtils = this;
		upLoadFileUtils.multipartResolver = this.multipartResolver;

	} 
    /**
     * 补充系统路径分隔符
     * 
     * @param path
     * @return
     */
    private static String appendSeparator(String path) {
        if (!path.endsWith(File.separator)) {
            return path + File.separator;
        }

        return path;

    }
    
    public static boolean checkImagFile(String fileName){
        boolean flag=false;
        String suffixList="jpg,bmp,png";
        //获取文件后缀
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        
        if(suffixList.contains(suffix.trim().toLowerCase())){
            flag=true;
        }
        return flag;
    }
    
    public static boolean checkVideoFile(String fileName){
        boolean flag=false;
        String suffixList="flv";
        //获取文件后缀
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        
        if(suffixList.equals(suffix.trim().toLowerCase())){
            flag=true;
        }
        return flag;
    }
    /**
     * 
     * @param request 
     * @param rPath 上传到服务器地址
     * @return
     */
	public static Map<String,Object> uploadFile(HttpServletRequest request,String rPath){
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				HashMap<String,Object> map=new HashMap<String,Object>();
				
				List<String> pathList=new ArrayList<String>();
				//文件处理
				MultipartHttpServletRequest multipartRequest = upLoadFileUtils.multipartResolver.resolveMultipart(request);
				MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();
				for(String str : fileMap.keySet()){
				List<MultipartFile> fileItemsList = fileMap.get(str);
				for (int i = 0; i < fileItemsList.size(); i++) {
					String fileName = fileItemsList.get(i).getOriginalFilename();
					String f2 = fileName.substring(fileName.lastIndexOf("."));//".jpg"
					if(f2==null || f2.trim().equals("") ){
						break;
					}
					SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
					//创建文件路径
					/*String realPath = rPath+"/"+df.format(new Date()) +"/"+new Date().getTime()+i+f2;*/
					String fname = ""+new Date().getTime()+i+f2;
					String realPath = rPath+"/"+fname;

					pathList.add("/"+fname);
					
					//保存文件到服务器上 
					File file = new File(realPath);
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					fileItemsList.get(i).transferTo(file);
				}
				}
				//表单处理

				map.put("pathList", pathList);
				
				Map<String, String[]> params = multipartRequest.getParameterMap();
				for(String name : params.keySet()){
					map.put(name, params.get(name));
				}
				
				return map;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	//base64转文件存储在rPath 返回文件名和后缀
	public static String uploadBase64(String base64Str,String rPath){
		String suffix="png";
		String base64=null;		
		if(base64Str.contains("data:image")){
			suffix=base64Str.substring(base64Str.indexOf("/")+1,base64Str.indexOf(";"));
			base64=base64Str.substring(base64Str.indexOf("base64")+7);
		}else{
			base64=base64Str;
		}
		if(!Base64.isBase64(base64)||StringUtils.isBlank(base64)) return "";
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		String relativeAddress = "/"+df.format(new Date()) +"/"+new Date().getTime()+new Random().nextInt(100)+"."+suffix;
		String realPath = rPath+relativeAddress;
		File file = new File(realPath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			byte [] buffer=Base64.decodeBase64(base64);
			for (int i = 0; i < buffer.length; ++i) {
			    if (buffer[i] < 0) {// 调整异常数据
			    	buffer[i] += 256;
			    }
			}
			FileOutputStream out = new FileOutputStream(realPath);
			out.write(buffer);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddress;
	}

}
