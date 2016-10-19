package cn.springmvc.service;

public interface SmsService {

	String sendCode(String phone, String code);

	String sendOrderRemin(String user, String action, String phone,
			String orderId, String remindUrl);

}
