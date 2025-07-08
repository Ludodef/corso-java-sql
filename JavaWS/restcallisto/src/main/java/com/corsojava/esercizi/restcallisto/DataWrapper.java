package com.corsojava.esercizi.restcallisto;

public class DataWrapper <T>{
	
	private Boolean success;
	
	private Integer code;
	
	private String msg;
	
	private String error;
	
	private String method;
	
	private String timeStamp;
	
	private T data;
	
	public static <T> DataWrapper<T> createWrapper(Boolean success, Integer code, String msg, String error, String method, String timeStamp,T data) {
		return new DataWrapper<T>(success,  code, msg,  error,  method,  timeStamp, data);
	}
	
	

	public DataWrapper(Boolean success, Integer code, String msg, String error, String method, String timeStamp,T data) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.error = error;
		this.method = method;
		this.timeStamp = timeStamp;
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
