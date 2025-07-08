package com.corsojava.wrappperdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DataWrapper <T> {
	private Boolean success; 
	private Integer code;      //
	private String message;   //
	private String error;
	private String method;
	private String timestamp;
	private T data; 
	
	
	// --------------------------------------------------------------------------
	public static final Integer SUCCESS_GET = 100; 
	public static final Integer SUCCESS_POST 	= 101;
	public static final Integer SUCCESS_PUT = 102;
	public static final Integer SUCCESS_DELETE = 103;
	public static final Integer ERROR_NOT_FOUND = 401;	 
	// --------------------------------------------------------------------------	
	
	private static final Map<Integer,String> CODES = new HashMap<>();
	static  {
		CODES.put(SUCCESS_GET,"Dato recuperato con successo");
		CODES.put(SUCCESS_POST,"Inserimento andato a buon fine");
		CODES.put(SUCCESS_PUT,"Dato modificato con successo");
		CODES.put(SUCCESS_DELETE,"Dato eliminato con successo");
		CODES.put(ERROR_NOT_FOUND,"Risorsa non trovata per l'ID specificato");
	}
	
	
	public static <T> ResponseEntity<DataWrapper<T>> success(Integer code,String method, T data ) {
		 
		return new ResponseEntity<DataWrapper<T>> (new DataWrapper<T>(true,code ,null,method ,data),HttpStatus.OK); 
		
	}
	
	public static <T> ResponseEntity<DataWrapper<T>> error(Integer code,String method, String error ) {
		 
		return new ResponseEntity<DataWrapper<T>> (new DataWrapper<T>(false,code ,error,method ,null),HttpStatus.OK); 
		
	} 
	
	public DataWrapper(Boolean success, Integer code, String error, String method,  T data) {
		super();
		this.success = success;
		this.code = code;
		this.message = CODES.get(code);
		this.error = error;
		this.method = method;
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
