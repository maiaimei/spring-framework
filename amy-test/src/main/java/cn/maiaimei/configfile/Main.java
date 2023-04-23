package cn.maiaimei.configfile;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("cn.maiaimei.configfile")
@PropertySource("db.properties")
public class Main implements InitializingBean {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class);
	}
	
	@Autowired
	private Environment environment;
	
	@Value("${mysql.host}")
	private String host;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("使用 @Value 读取配置文件，只能读取一个配置项。");
		System.out.println(host);

		System.out.println("使用 Environment 读取配置文件。");
		System.out.println(environment.getProperty("mysql.host"));
	}
}
