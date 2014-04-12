package org.devnation.rubyonrules.utils;

import java.util.ArrayList;
import java.util.Collection;

public class AccountAlertService {
	
	Collection<String> accounts;
	
	public AccountAlertService(){
		
	}
	
	public void addAccount(String accountNumberToAdd){
		getAccounts().add(accountNumberToAdd);
	}

	public Collection<String> getAccounts() {
		if(this.accounts == null) setAccounts(new ArrayList<String>());;
		return this.accounts;
	}

	public void setAccounts(Collection<String> accounts) {
		this.accounts = accounts;
	}
	
	

}
