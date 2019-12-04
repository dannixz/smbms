package cn.smbms.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class UserLogger {
	
	private static final Logger log = Logger.getLogger(UserLogger.class);
	
	//代表前置增强的方法
		public void before(JoinPoint jp) {
			log.info("调用" + jp.getTarget() +"的" + jp.getSignature().getName()
					+ "方法.方法入参：" + Arrays.toString(jp.getArgs()));
		}
		
		
		//代表后置增强
		public void afterReturning(JoinPoint jp,Object result) {
			log.info("调用："+jp.getTarget()+"的"+jp.getSignature().getName()+
					"方法执行的返回值："+result);
		}
		//异常抛出增强
		public void afterThrowing(JoinPoint jp,Exception e) {
			log.error("调用："+jp.getTarget()+"的"+jp.getSignature().getName()+
					"方法。方法执行过程中报错："+e.getMessage());
		}
		//最终增强
		public void after(JoinPoint jp){
			log.info("调用" + jp.getTarget() +"的" + jp.getSignature().getName()
					+ "方法.方法入参：" + Arrays.toString(jp.getArgs()));
		}
	
}
