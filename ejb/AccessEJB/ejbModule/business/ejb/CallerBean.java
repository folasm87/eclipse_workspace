package business.ejb;

import javax.ejb.Stateless;

import dataservice.DataDao;
import dataservice.DataDaoImpl;


@Stateless(name="callerBean")
public class CallerBean implements CallerBeanRemote {

    
    public CallerBean() {
        
    }

	@Override
	public String retrieveName(int id) {
		
		DataDao data = new DataDaoImpl();
		
		String name = data.retrieveName(id);
		
		
		return name;
	}

}
