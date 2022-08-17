package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@Data annotation is equal to getter,setter,NoargsConstructor,toString,equals and hascode annotations.
//it doesn't support No argument constructor or default constructor and All argument constructors
@Data   
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	@NotBlank(message="Please add departmentName")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	public DepartmentEntity(String departmentName,String departmentAddress,String departmentCode) {
		this.departmentName= departmentName;
		this.departmentCode = departmentCode;
		this.departmentAddress = departmentAddress;
	}
}
