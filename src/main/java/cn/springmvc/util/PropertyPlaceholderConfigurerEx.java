package cn.springmvc.util;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author: baowei
 * @date: 2016年5月5日
 */
public class PropertyPlaceholderConfigurerEx extends
		PropertyPlaceholderConfigurer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
	 * #processProperties
	 * (org.springframework.beans.factory.config.ConfigurableListableBeanFactory
	 * , java.util.Properties)
	 */
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);

		// 初始化Log4j
		PropertyConfigurator.configure(props);
	}

}