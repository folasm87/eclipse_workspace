package net.mv.aop;

import org.springframework.stereotype.Component;

@Component("doStuff")
public class DoSomethingImpl implements DoSomething {

	@Override
	public void method() {
		System.out.println("<Method 1 Execute>");

	}

	@Override
	public void method2() {
		System.out.println("<Method 2 Execute>");

	}

}
