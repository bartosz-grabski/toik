package pl.edu.agh.dao;

import java.util.Collection;

import pl.edu.agh.account.Account;

public interface AccountDAO {
	Collection<Account> getAccounts();

	Collection<Long> getIds();

	Account getAccountByID(Long Id);

	long saveAccount(Account account);
}
