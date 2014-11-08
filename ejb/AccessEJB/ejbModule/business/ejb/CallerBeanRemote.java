package business.ejb;

import javax.ejb.Remote;

@Remote
public interface CallerBeanRemote {
	
	public String retrieveName(int id);
}
