package com.somesh.banking.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Getter  // lombok - will consider getters for the below variables defined
@Setter  // lombok - will consider  setters for the below variables defined
@NoArgsConstructor  //lombok - will consider the no arg constructor 
@AllArgsConstructor  // lombok - will accept all types of argument constructors
@Table(name = "accounts")  // configure Table in a DB using spring boot
@Entity  //to make this class as JPA entity
*/

@Table(name = "accounts")
@Entity
public class Account {

	/*
	 * @Id // to make the ID field as primary key in DB
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) // to configure Primary
	 * key generation strategy //it will automatically increment the Primary Key
	 * value
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/*
	 * @Column(name = "acc_holder_name") // to configure the column name
	 */
	@Column(name = "acc_holder_name")
	private String accountHolderName;
	@NonNull
	private double balence;

	public long getId() {
		System.out.println("Somesh");
		return id;
		
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	
	public double getBalence() {
		return balence;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}

	public Account() {
		super();
	}

	public Account(long id, String accountHolderName, double balence) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balence = balence;
	}
	

}
