package io.umaid.springbootquickstarter.domain;

import org.springframework.stereotype.Component;

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
@Component
public class EmployeeDTO {

	private int eid;
	private String ename;
	private float esalary;
	/**
	 * @param eid
	 * @param ename
	 * @param esalary
	 */
	public EmployeeDTO(EmployeeDAO dao) {
		this.eid = dao.getEid();
		this.ename = dao.getEname();
		this.esalary = dao.getEsalary();
	}
	
	

}
