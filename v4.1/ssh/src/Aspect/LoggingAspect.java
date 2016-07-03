package Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	
	@After("execution(* action.ActionFunction.save(..))")
	public void logAfter(JoinPoint joinPoint) {
		
		 Object[] args = joinPoint.getArgs();
		  for (int i=0; i<args.length; i++) {
		   System.out.println(args[i] + "-----------");
		  }
		  
		System.out.println("/////////////////////////////");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
}