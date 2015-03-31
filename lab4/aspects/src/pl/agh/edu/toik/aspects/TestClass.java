package pl.agh.edu.toik.aspects;

public class TestClass {
	
	
	private String field1;
	private String field2;
	
	public TestClass() {
		
	}
	
	public void method1(String argument) {
		
	}
	
	public void method2() throws Exception {
		throw new Exception("some exception");
	}
	
	public String getField1() {
		return this.field1;
	}
	
	public String getField2() {
		return this.field2;
	}
	
	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	public double divide(double a, double b) {
		return a/b;
	}
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public int sumNotOk(int a, int b) {
		return a + 2*b;
	}
	
	public void criticalSection() {
		
	}
	
	public static void main(String[] argv) {
		TestClass c = new TestClass();
		
		c.setField1("asd");
		c.setField2("bsd");
		
		c.criticalSection();
		
		c.method1(c.getField1());
		c.sum(1, 0);
		c.sumNotOk(1, 3);
		c.divide(1.0,1.0);
		c.divide(1.0,0.0);
	
		try {
			c.method2();
		} catch (Exception e) {
			System.out.println("Exception thrown");
		}
	}

}
