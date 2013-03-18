/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ytwytw
 */
public class CheqSavCustomer extends Account {
	protected int savBalance;
	protected int checkBalance;

	public CheqSavCustomer(String Name, String Password, int AccountType, 
                               int CheqBalance, int SavBalance) {
            super(Name, Password, AccountType);
            try {
                if (CheqBalance>=20 && SavBalance >=20) {
                    this.checkBalance = CheqBalance;
                    this.savBalance = SavBalance;
                    this.accountType = 2;
                }
                else this.checkBalance = 1 / 0;
            } catch (ArithmeticException e) {
                System.err.println("Cheq&Sav Must be greater than $20!!!");
            }
            
	}

	public int getSavBalance() {
            return CheqSavCustomer.this.savBalance;
	}

	public int getCheckBalance() {
            return CheqSavCustomer.this.checkBalance;
	}

	public void savDeposit(int Amount) {
            System.out.println("Cureent Saving Account Balance is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
            CheqSavCustomer.this.savBalance += Amount;
            System.out.println("After Deposit is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
	}

	public void cheqDeposit(int Amount) {
            System.out.println("Cureent Cheqing Account Balance is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            CheqSavCustomer.this.checkBalance += Amount;
            System.out.println("After Deposit is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
	}

	public void savWithDraw(int Amount) {
            System.out.println("Cureent Saving Account Balance is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
            
            int temp = CheqSavCustomer.this.savBalance - Amount;
            
            if (positiveCheck(temp)) {
                CheqSavCustomer.this.savBalance = temp;
            } else {
                System.err.println("insufficient funds in Sav!");
            }
            
            System.out.println("After Withdraw is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
	}

	public void cheqWithDraw(int Amount) {
            System.out.println("Cureent Chequing Account Balance is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            
            int temp = CheqSavCustomer.this.checkBalance - Amount;
            
            if (positiveCheck(temp)) {
                CheqSavCustomer.this.checkBalance = temp;
            } else {
                System.err.println("insufficient funds in cheq!");
            }
            
            System.out.println("After Withdraw is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
	}

	public void Cheq2Sav(int Amount) {
            System.out.println("Cureent Chequing Account Balance is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            System.out.println("Cureent Saving Account Balance is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
            
            int temp = CheqSavCustomer.this.checkBalance - Amount;
            
            if (positiveCheck(temp)) {
                CheqSavCustomer.this.checkBalance = temp;
                CheqSavCustomer.this.savBalance += Amount;
            } else {
                System.err.println("insufficient funds in cheq!");
            }
            
            System.out.println("After Withdraw cheqing is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            System.out.println("After Withdraw saving is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
	}

	public void Sav2Chqu(int Amount) {
            System.out.println("Cureent Chequing Account Balance is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            System.out.println("Cureent Saving Account Balance is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
            
            int temp = CheqSavCustomer.this.checkBalance - Amount;          
            if (positiveCheck(temp)) {
                CheqSavCustomer.this.savBalance = temp;
                CheqSavCustomer.this.checkBalance += Amount;
            } else {
                System.err.println("insufficient funds in Sav!");
            }
            
            System.out.println("After Withdraw cheqing is:");
            System.out.println(CheqSavCustomer.this.getCheckBalance());
            System.out.println("After Withdraw saving is:");
            System.out.println(CheqSavCustomer.this.getSavBalance());
	}
        
        public boolean positiveCheck(int i) {
            if (i>0) {
                return true;
            }
            else {
                return false;
            }
        }
}