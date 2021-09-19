package lk.harshana.graphql.resolver;

import org.springframework.stereotype.Component;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.Client;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount>{


  public Client client(BankAccount bankAccount) {
	  log.info("client resolver");
	  
	   throw new GraphQLException("client not available"); 
	  // throw new RuntimeException("Spring error");
	  
//	  return Client.builder().id(bankAccount.getId()).firstName("harshana").lastName("madusanka").build();
  
  }
  
  
	 
}
