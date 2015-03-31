package pl.agh.edu.toik.aspects;

import javax.management.RuntimeErrorException;

public aspect DivisionAspect {
	
	pointcut pc1():
		call(double pl.agh.edu.toik.aspects.TestClass.divide(double,double));
	
	pointcut pc2():
		call(int pl.agh.edu.toik.aspects.TestClass.sum*(int,int));
	
	before(double x, double y): pc1() && args(x,y) {
		System.out.println("division aspect : "+x+" "+y);
		if (y == 0.0) {
			throw new IllegalArgumentException("Division by zero!");
		}
	}
	
	int around(int x, int y):  pc2() && args(x,y) {
		int result = proceed(x,y);
		if (result != x + y) {
			System.out.println("Illegal sum for "+x+" "+y);
			throw new RuntimeException("Illegal sum");
		} else {
			System.out.println("Sum ok for "+x+" "+y);
			return result;
		}
	}
	
	double around(double x, double y): pc1() && args(x,y) {
		try {
			double result = proceed(x,y);
			System.out.println("Result is " + result);
			return result;
		} catch(IllegalArgumentException e) {
			System.out.println("Exception caught");
			return 0.0;
		}
		
	}

}
