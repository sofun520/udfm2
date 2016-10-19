package cn.springmvc.util;

public class SysConfig {

	private String smsUrl;

	private String smsApikey;

	private String smsCodeTpl;

	private String orderRemindTpl;

	private String website;

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	public String getOrderRemindTpl() {
		return orderRemindTpl;
	}

	public void setOrderRemindTpl(String orderRemindTpl) {
		this.orderRemindTpl = orderRemindTpl;
	}

	public String getSmsCodeTpl() {
		return smsCodeTpl;
	}

	public void setSmsCodeTpl(String smsCodeTpl) {
		this.smsCodeTpl = smsCodeTpl;
	}

	public String getSmsUrl() {
		return smsUrl;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	public String getSmsApikey() {
		return smsApikey;
	}

	public void setSmsApikey(String smsApikey) {
		this.smsApikey = smsApikey;
	}

}
