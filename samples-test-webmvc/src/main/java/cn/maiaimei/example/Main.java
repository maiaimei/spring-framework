package cn.maiaimei.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	private static final Log log = LogFactory.getLog(Main.class);
	
	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("cn.maiaimei.example");
		applicationContext.register(Main.class);
		applicationContext.refresh();
		final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			log.info(beanDefinitionName + " -> " + applicationContext.getBean(beanDefinitionName));
		}
	}
}
