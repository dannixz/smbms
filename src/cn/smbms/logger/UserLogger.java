package cn.smbms.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class UserLogger {
	
	private static final Logger log = Logger.getLogger(UserLogger.class);
	
	//����ǰ����ǿ�ķ���
		public void before(JoinPoint jp) {
			log.info("����" + jp.getTarget() +"��" + jp.getSignature().getName()
					+ "����.������Σ�" + Arrays.toString(jp.getArgs()));
		}
		
		
		//���������ǿ
		public void afterReturning(JoinPoint jp,Object result) {
			log.info("���ã�"+jp.getTarget()+"��"+jp.getSignature().getName()+
					"����ִ�еķ���ֵ��"+result);
		}
		//�쳣�׳���ǿ
		public void afterThrowing(JoinPoint jp,Exception e) {
			log.error("���ã�"+jp.getTarget()+"��"+jp.getSignature().getName()+
					"����������ִ�й����б���"+e.getMessage());
		}
		//������ǿ
		public void after(JoinPoint jp){
			log.info("����" + jp.getTarget() +"��" + jp.getSignature().getName()
					+ "����.������Σ�" + Arrays.toString(jp.getArgs()));
		}
	
}
