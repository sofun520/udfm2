package cn.springmvc.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import cn.springmvc.service.SmsService;
import cn.springmvc.util.SysConfig;

@Service
public class SmsServiceImpl implements SmsService, ApplicationContextAware {

	private ApplicationContext context;

	private static String ENCODING = "UTF-8";

	public String sendCode(String phone, String code) {
		try {
			SysConfig sysConfig = getConfig();
			String apikey = sysConfig.getSmsApikey();
			String url = sysConfig.getSmsUrl();
			long tpl_id = Long.parseLong(sysConfig.getSmsCodeTpl());

			String mobile = URLEncoder.encode(phone, ENCODING);
			String tpl_value = URLEncoder.encode("#code#", ENCODING) + "="
					+ URLEncoder.encode(code, ENCODING);
			return tplSendSms(apikey, tpl_id, tpl_value, mobile, url);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String sendOrderRemin(String user, String action, String phone,
			String orderId, String remindUrl) {
		try {
			SysConfig sysConfig = getConfig();
			String apikey = sysConfig.getSmsApikey();
			String url = sysConfig.getSmsUrl();
			// String website = sysConfig.getWebsite();
			long tpl_id = Long.parseLong(sysConfig.getOrderRemindTpl());

			// 【京汉安驰】尊敬的#user#：您的#action#，订单号#orderId#，订单详情请登录官网查询。官网#url#
			String mobile = URLEncoder.encode(phone, ENCODING);
			String tpl_value = URLEncoder.encode("#user#", ENCODING) + "="
					+ URLEncoder.encode(user, ENCODING) + "&"
					+ URLEncoder.encode("#action#", ENCODING) + "="
					+ URLEncoder.encode(action, ENCODING) + "&"
					+ URLEncoder.encode("#orderId#", ENCODING) + "="
					+ URLEncoder.encode(orderId, ENCODING) + "&"
					+ URLEncoder.encode("#url#", ENCODING) + "="
					+ URLEncoder.encode(remindUrl, ENCODING);
			return tplSendSms(apikey, tpl_id, tpl_value, mobile, url);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public String tplSendSms(String apikey, long tpl_id, String tpl_value,
			String mobile, String url) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("tpl_id", String.valueOf(tpl_id));
		params.put("tpl_value", tpl_value);
		params.put("mobile", mobile);
		return post(url, params);
	}

	public String post(String url, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(url);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(),
							param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
			}
			response = client.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}

	public SysConfig getConfig() {
		return context.getBean(SysConfig.class);
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}

}
