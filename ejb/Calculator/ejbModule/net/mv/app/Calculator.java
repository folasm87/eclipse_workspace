package net.mv.app;

import javax.ejb.Stateless;


@Stateless(name="calculate")
public class Calculator implements CalculatorRemote {
	
	public Calculator(){
		
	}

	@Override
	public double add(double first, double second) {
		
		return first+second;
	}

	@Override
	public double power(double first, double second) {
		
		return Math.pow(first, second);
	}

	@Override
	public double areaCircle(double diameter) {
		
		return Math.PI * Math.pow((diameter/2), 2);
	}

}
