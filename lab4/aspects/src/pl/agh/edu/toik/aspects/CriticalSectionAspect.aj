package pl.agh.edu.toik.aspects;

import java.util.concurrent.Semaphore;

public aspect CriticalSectionAspect {
	
	private static final Semaphore sem = new Semaphore(1);
	
	pointcut pc1():
		call(void pl.agh.edu.toik.aspects.TestClass.criticalSection(..));
	
	void around() : pc1() {
		
		
		try {
			sem.acquire();
			System.out.println("Semaphore acquired");
			proceed();
			System.out.println("Semaphore released");
			sem.release();
		} catch (InterruptedException e) {
			//
		}
		
		
	}

}
