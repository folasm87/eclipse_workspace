package net.mv.dao;

import javax.persistence.*;


@Entity //Can be persisted = Serializable + Can go into a database
public class Transaction {
	
	@Id
	@GeneratedValue
	@Column(name="txn_id")
	private long txnId;
	
	@Column(name="txn_type")
	private String type;
	
	@Column
	private double amount;
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="acnt_no")
	private Account acnt;
	
	public Transaction(){
		
		
	}
	
	public Transaction(String type, double amount, double balance){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account getAcnt() {
		return acnt;
	}

	public void setAcnt(Account acnt) {
		this.acnt = acnt;
	}
	
	

}
