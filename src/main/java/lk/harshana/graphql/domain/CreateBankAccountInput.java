package lk.harshana.graphql.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateBankAccountInput {
	
	@NotBlank
	private String firstName;
	private int age;
}
