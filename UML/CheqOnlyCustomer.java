public class CheqOnlyCustomer extends Account {

	protected int CheckBalance;

	/**
	 * 
	 * @param name
	 * @param password
	 * @param AccountType
	 * @param CheqBalance
	 */
	public CheqOnlyCustomer(String name, String password, int AccountType, int CheqBalance) {
		throw new UnsupportedOperationException();
	}

	public void getCheckBalance() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void cheqDeposit(int amount) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 */
	public void cheqWithdraw(int amount) {
		throw new UnsupportedOperationException();
	}

}