package HomeTomecat;

import jakarta.persistence.Entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;

@Entity
@Table(name="Spendings")
public class Wallet {

	@Id
	@GeneratedValue
	public Long Id;
	
	public String purpose;	
	
	@ColumnDefault("0")
	public Double amount;
	
	public Date date;
	
}
