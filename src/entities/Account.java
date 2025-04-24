package entities;

public class Account {
	
	private Integer number;
	private String holder;
<<<<<<< HEAD
	protected Double balance;
=======
	private Double balance;
>>>>>>> f957e2a641fdc034b89547486507bfb3629cc7b9
	
	public Account() {}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
}
