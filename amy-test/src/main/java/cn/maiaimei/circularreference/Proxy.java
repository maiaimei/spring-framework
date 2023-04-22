package cn.maiaimei.circularreference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Proxy {
	
	private static final Log log = LogFactory.getLog(Proxy.class);
	
	@Pointcut("execution(* cn.maiaimei.circularreference.*.doSomething())")
	public void pointcut(){}
	
	@Around("pointcut()")
	public Object handleDoSomething(ProceedingJoinPoint proceedingJoinPoint) {
		Object result;
		try {
			log.info("前置通知");
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			log.error("异常通知",e);
			return null;
		} finally {
			log.info("后置通知");
		}
		log.info("返回通知");
		return result;
	}
}
