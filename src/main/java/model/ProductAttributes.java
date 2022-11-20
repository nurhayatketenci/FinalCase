package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_attributes")
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private UUID id;
	
    @OneToOne(mappedBy = "product")
    private Product product;
	
	@Column(name="discount_rate")
	private double discountRate;
	
	@Column(name="amount_of_stock")
	private int amountOfStock;
	
	@Column(name="product_name")
	private String productName;
	
	@Nullable
	@Column(name="screen_size")
	private String screenSize;
	
	@Column(name="storage")
	private String storage;
	
	@Column(name="ram")
	private String ram;
	
	@Column(name="color")
	private String color;
	
	@Nullable
	@Column(name="battery_power")
	private int batteryPower;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="name")
	private String name;
}
