package com.COMTRUE.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employees {

	@Id
	private String id;
	
	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 30)
	@Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$")
	private String phoneNumber;

	@Column(nullable = false, length = 30)
	private String position;
	
	@Column(nullable = false, length = 30)
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")
	private String email;
}
