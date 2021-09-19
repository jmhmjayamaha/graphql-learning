package lk.harshana.graphql.resolver.bank;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.Client;
import lk.harshana.graphql.domain.Currency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

	public BankAccount bankAccount(UUID id) {
		log.info("Bank account information ");
		
//		var clientA = Client.builder().id(id).firstName("harshana").lastName("madusanka").build();
//		var clientB = Client.builder().id(id).firstName("kawshalya").lastName("madushani").build();
//		
//		clientA.setClient(clientB);
//		clientB.setClient(clientA);
		
		return BankAccount
				.builder()
				.id(id)
				.currency(Currency.USD)
				.build();
	}
}
