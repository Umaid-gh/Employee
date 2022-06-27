package io.umaid.springbootquickstarter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class EmployeeDAO {

	@Id
	private int eid;
	private String ename;
	private float esalary;

	/**
	 * @param id
	 * @param name
	 * @param salary
	 */
	public EmployeeDAO(EmployeeDTO dto) {
		this.eid = dto.getEid();
		this.ename = dto.getEname();
		this.esalary = dto.getEsalary();
	}

}
