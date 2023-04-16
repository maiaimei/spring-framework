package cn.maiaimei.example.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserService.class)
public class IocApplication {
	private static final Log log = LogFactory.getLog(IocApplication.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("cn.maiaimei.example.ioc");
		applicationContext.refresh();

		final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			log.info(beanDefinitionName + " -> "+ applicationContext.getBean(beanDefinitionName));
		}
	}
	
	@Bean
	public UserMapper userMapper(){
		return new UserMapper();
	}
}
