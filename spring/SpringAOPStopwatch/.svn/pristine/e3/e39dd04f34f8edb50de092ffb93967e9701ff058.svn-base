package net.mv.aop;

import org.springframework.stereotype.Component;

@Component("timed")
public class TimedImpl implements Timed {

	@Override
	public void method1() {
		
		for(int i = 0; i < 1000000; i++){
			
			new Object();
			System.out.println("Created Object " + i);
		}

	}

}
