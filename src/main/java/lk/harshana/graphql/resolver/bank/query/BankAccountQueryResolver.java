package lk.harshana.graphql.resolver.bank.query;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.Client;
import lk.harshana.graphql.domain.Currency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankAccountQueryResolver implements GraphQLQueryResolver {

	public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
		log.info("Bank account information ");
		
		var requestedFields = environment.getSelectionSet().getFields().stream().map(SelectedField::getName)
				.collect(Collectors.toSet());

		requestedFields.forEach(name -> log.info(name));
				
		if(environment.getSelectionSet().contains("currency")) {
			log.info("currency is in the filed set");
		}
		
		return BankAccount
				.builder()
				.id(id)
				.currency(Currency.USD)
				.build();
	}
}
