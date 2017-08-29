package com.cares.baseframe.scanURL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//@SpringBootApplication  
@EnableAutoConfiguration()  
public class ScanURLApplication{  
  
    @Autowired  
    private RequestMappingHandlerConfig requestMappingHandlerConfig;  
       
    public static void main(String[] args) {  
        SpringApplication.run(ScanURLApplication.class, args);  
}  
    /** 
     * 扫描URL，如果数据库中不存在，则保存入数据库 
     */  
    @PostConstruct  //这个注解很重要，可以在每次启动的时候检查是否有URL更新，RequestMappingHandlerMapping只能在controller层用。这里我们放在主类中  
     public void detectHandlerMethods(){   
            final RequestMappingHandlerMapping requestMappingHandlerMapping = requestMappingHandlerConfig.requestMappingHandlerMapping ();  
            Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();  
            Set<RequestMappingInfo> mappings = map.keySet();  
            Map<String, String> reversedMap = new HashMap<String, String>();  
            for(RequestMappingInfo info : mappings) {  
                HandlerMethod method = map.get(info);  
                String methodstr = method.toString();  
                methodstr = methodstr.split("\\(")[0];  
                methodstr = methodstr.split(" ")[2];  
                int i=methodstr.lastIndexOf(".");  
                methodstr = methodstr.substring(0,i);  
                String urlparm = info.getPatternsCondition().toString();  
                String url = urlparm.substring(1, urlparm.length()-1);  
                System.out.println ("===>"+url);  
             /* List<SysResource> list = sresourceService.findByResourceString(url);  
                if(list==null || list.size()<=0){  
                    int num = (int)(Math.random()*100+1);  
                    String rand = String.valueOf(num);  
                    String resourceId = "res"+System.currentTimeMillis()+rand;  
                    SysResource sysresource = new SysResource();  
                    sysresource.setResourceString(url);  
                    sysresource.setRemark("0");  
                    sysresource.setResourceId(resourceId);  
                    sysresource.setMethodPath(methodstr);  
                    sresourceService.save(sysresource);  
                    System.out.println ("===>"+url);  
                }  */
                  
            }  
        }  
}  