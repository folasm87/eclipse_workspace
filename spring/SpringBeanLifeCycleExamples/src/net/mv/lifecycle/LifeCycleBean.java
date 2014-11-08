package net.mv.lifecycle;

public class LifeCycleBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init(){
		System.out.println("A baby bean is born!");
	}
	
	public void destroy(){
		System.out.println("Bean: 'Et tu Brute?'");
	}

}
