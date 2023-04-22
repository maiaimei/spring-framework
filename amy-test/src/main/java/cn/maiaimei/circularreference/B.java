package cn.maiaimei.circularreference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	
	private static final Log log = LogFactory.getLog(B.class);
	
	@Autowired
	private C c;
	
	public void doSomething(){
		log.info("执行目标方法");
	}
}
