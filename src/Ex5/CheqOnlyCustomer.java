package Ex5;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ytwytw
 */
public class CheqOnlyCustomer extends Account {
	protected int checkBalance;

	public CheqOnlyCustomer(String Name, String Password, int AccountType, 
                                int CheqBalance) {
            super(Name, Password, AccountType);
            try {
                if (CheqBalance>=20) {
                    this.checkBalance = CheqBalance;
                    this.accountType = 1;
                }
                else this.checkBalance = 1 / 0;
            } catch (ArithmeticException e) {
                System.err.println("CheqBalance Must be greater than $20!!!");
            }
	}

	public int getCheckBalance() {
            return CheqOnlyCustomer.this.getCheckBalance();
	}

	public void cheqDeposit(int Amount) {
            System.out.println("Cureent Chequing Account Balance is:");
            System.out.println(CheqOnlyCustomer.this.getCheckBalance());
            CheqOnlyCustomer.this.checkBalance += Amount;
            System.out.println("After Deposit is:");
            System.out.println(CheqOnlyCustomer.this.getCheckBalance());
	}

	public void cheqWithdraw(int Amount) {
            System.out.println("Cureent Chequing Account Balance is:");
            System.out.println(CheqOnlyCustomer.this.getCheckBalance());
            
            int temp = CheqOnlyCustomer.this.checkBalance - Amount;
            
            if (positiveCheck(temp)) {
                CheqOnlyCustomer.this.checkBalance = temp;
            } else {
                System.err.println("insufficient funds in cheq!");
            }
            
            System.out.println("After Withdraw is:");
            System.out.println(CheqOnlyCustomer.this.getCheckBalance());
	}
        
        public boolean positiveCheck(int money) {
            if (money > 0) {
                return true;
            }
            return false;
        }
}