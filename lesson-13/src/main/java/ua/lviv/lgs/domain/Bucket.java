package ua.lviv.lgs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bucket")
public class Bucket {
	
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@Column(name ="date")
	private Date date;

	public Bucket() {
		
	}

	public Bucket(User user, Product product, Date date) {
		this.user = user;
		this.product = product;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date nowDate) {
		this.date = nowDate;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", product=" + product + ", nowDate=" + date + "]";
	}



	
}
