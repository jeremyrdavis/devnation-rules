package org.devnation.rubyonrules.model;

import java.math.BigDecimal;

public class Withdrawl {

	private String accountNumber;
	private BigDecimal amount;

	/**
	 * Models a Withdrawl from the specified account
	 * 
	 * @param accountNumberToSet String
	 * @param amountToSet BigDecimal
	 */
	public Withdrawl(String accountNumberToSet, BigDecimal amountToSet) {
		this.accountNumber = accountNumberToSet;
		this.amount = amountToSet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Withdrawl other = (Withdrawl) obj;

		if((accountNumber.equals(other.accountNumber))&&(amount.equals(other.amount))) return true;
		
		return false;
	}



	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
}
