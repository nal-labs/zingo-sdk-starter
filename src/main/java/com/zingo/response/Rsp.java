package com.zingo.response;


/**
 * @author manta
 */
public class Rsp<T> {

	private String code;
	public String message;
	private T data;

	public static final String SUCCESS = "200";

	public Rsp() {
	}

	public Rsp(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public static <T> Rsp<T> success(String code, String msg, T data) {
		return new Rsp<T>(code, msg, data);
	}

	public static <T> Rsp<T> failure(String code, String msg) {
		return new Rsp<T>(code, msg, null);
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Rsp{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
