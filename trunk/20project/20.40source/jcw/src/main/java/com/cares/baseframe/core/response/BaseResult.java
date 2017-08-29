package com.cares.baseframe.core.response;

public class BaseResult {

	private String code;
	private String msg;
	private Object data;
	
	private static String SUCCESS=Conts.SUCCESS.getCode();
	private static String ERROR="error";
	
	
	private  BaseResult() {
		
	}
	
	private BaseResult(String code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static BaseResult success(){
		return success(null);
	}
	
	public static BaseResult success(Object data){
		return success(SUCCESS,"成功！",data);
	}
	
	public static BaseResult success(String code,String msg,Object data){
		return new BaseResult(code,msg,data);
	}
	
	public static BaseResult fail(){
		return fail(null);
	}
	
	public static BaseResult fail(String msg){
		return fail(ERROR,msg,null);
	}
	
	public static BaseResult fail(String code,String msg,Object data){
		return new BaseResult(code,msg,data);
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	enum Conts{
		SUCCESS		("ok","成功"),
		FAIL		("error","错误");
		
		private String code;
		private String msg;
		
		private  Conts(String code,String msg){
			this.code=code;
			this.msg=msg;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
}
