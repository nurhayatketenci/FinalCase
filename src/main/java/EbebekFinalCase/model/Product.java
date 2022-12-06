package EbebekFinalCase.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne()
	@JoinColumn(name="brand_id")
	private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_attribute_id", referencedColumnName = "id")
    private ProductAttributes productAttribute;

}
