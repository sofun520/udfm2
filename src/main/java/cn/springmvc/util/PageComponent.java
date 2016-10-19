package cn.springmvc.util;

import java.util.HashMap;
import java.util.Map;

public class PageComponent {

	private int page;
	private int pageCount;
	private int pageSize = 10;
	private int total;

	public PageComponent(int page, int total) {
		this.page = page;
		this.pageCount = (total + pageSize - 1) / pageSize;
		this.total = total;
	}

	public Map<String, Object> getContext() {
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("pageCount", this.pageCount);
		context.put("page", this.page);
		context.put("total", this.total);
		return context;
	}
}
