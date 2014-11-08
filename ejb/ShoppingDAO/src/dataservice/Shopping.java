package dataservice;

import javax.persistence.*;
import org.hibernate.Transaction;

@Entity 
public class Shopping {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHOPPING_ID")
	private long SHOPPING_ID;
	
	@Column(name="ITEM")
	private String ITEM;
	
	public Shopping(String item){
		super();
		this.ITEM = item;
		
	}

	public long getSHOPPING_ID() {
		return SHOPPING_ID;
	}

	public void setSHOPPING_ID(long sHOPPING_ID) {
		SHOPPING_ID = sHOPPING_ID;
	}

	public String getITEM() {
		return ITEM;
	}

	public void setITEM(String iTEM) {
		ITEM = iTEM;
	}

	@Override
	public String toString() {
		return "Shopping [SHOPPING_ID=" + SHOPPING_ID + ", ITEM=" + ITEM + "]";
	}
	
	
	
}