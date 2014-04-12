package org.devnation.rubyonrules;

/**
 * Enum for storing test values
 * 
 * @author jeremy.davis@redhat.com
 *
 */
public enum ACCOUNT {
	
	account1("ABC123456789");
	
	public String accountNumber;
	
	private ACCOUNT(String accountNumberToSet){
		this.accountNumber = accountNumberToSet;
	}

}
