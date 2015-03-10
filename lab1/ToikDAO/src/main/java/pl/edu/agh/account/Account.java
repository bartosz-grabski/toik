package pl.edu.agh.account;

import java.math.BigDecimal;
import java.text.MessageFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Account {
	private Long id;

	@Size(min = 2, max = 25)
	private String firstName;

	@Size(min = 1, max = 25)
	private String lastName;

	@NotNull
	@DecimalMin(value = "0")
	private BigDecimal balance;

	@NotBlank
	@Email
	private String email;

	public Account() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		return MessageFormat.format("Id: {0}\nName: {1}\nLastname: {2}\nBalance: {3}\nEmail: {4}", id, firstName,
				lastName, balance, email);
	}

}
