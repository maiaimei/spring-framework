package cn.maiaimei.circularreference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("cn.maiaimei")
public class Main {
	
	private static final Log log = LogFactory.getLog(C.class);
	
	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

		final String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			log.info(beanDefinitionName + " -> " + context.getBean(beanDefinitionName));
		}

		final A a = context.getBean(A.class);
		a.doSomething();

		final B b = context.getBean(B.class);
		b.doSomething();

		final C c = context.getBean(C.class);
		c.doSomething();
	}
}
