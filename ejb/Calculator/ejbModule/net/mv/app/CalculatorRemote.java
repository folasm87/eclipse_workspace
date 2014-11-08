package net.mv.app;

import javax.ejb.Remote;


@Remote
public interface CalculatorRemote {
	
	public double add(double first, double second);
	
	public double power(double first, double second);
	
	public double areaCircle(double diameter);

}
