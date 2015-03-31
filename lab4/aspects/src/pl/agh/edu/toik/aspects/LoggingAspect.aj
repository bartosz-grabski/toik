package pl.agh.edu.toik.aspects;

public aspect LoggingAspect {
		
		pointcut pc1():
			call(void pl.agh.edu.toik.aspects.TestClass..*(..));
		
		pointcut pc2():
			get(private * TestClass.*);
		
		pointcut pc3():
			set(private String TestClass.*);
		
		void around(): pc1() {
		    boolean loggingAllowed = true;
		    
		    if (loggingAllowed) {
		    	String wholeMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		    	String methodName = wholeMethodName.split("_")[0];
		    	System.out.println("");
		    	System.out.println("Program run method: "+methodName);
		    	for (Object o : thisJoinPoint.getArgs()) {
		    		System.out.println("Arguments");
		    		System.out.println(o.toString());
		    	}
		    }

		    proceed();
		}
		
		before(): pc2() {
			System.out.println(String.format("Field about to be read: %s", thisJoinPointStaticPart.getSignature().getName()));
		}
		
		before(String newval): pc3() && args(newval) {
			System.out.println(String.format("Field about to be set %s %s", thisJoinPointStaticPart.getSignature().getName(), newval));
			
		}
		
		

}
