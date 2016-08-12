package test;

public class Account {
	private double balance;

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public  Account() {
		balance=0;
	}
	/**
	 * ����˴���synchronized����
	 */
	public synchronized void deposit(double amount){
		double tmp=balance;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tmp+=amount;
		balance=tmp;
	}
	/**
	 * ȡ��˴���synchronized����*/
	public synchronized void withdraw(double amount){
		double tmp=balance;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tmp-=amount;
		balance=tmp;
	}
	/**��ӡ��Ϣ*/
	public void printInfo(){
		System.out.println("Balance on account="+balance);
	}
}
