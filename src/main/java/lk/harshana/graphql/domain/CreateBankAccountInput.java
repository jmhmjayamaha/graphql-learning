package lk.harshana.graphql.domain;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class CreateBankAccountInput {
	
	private String firstName;
	private int age;
}
