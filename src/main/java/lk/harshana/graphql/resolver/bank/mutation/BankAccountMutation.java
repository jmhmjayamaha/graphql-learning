package lk.harshana.graphql.resolver.bank.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.CreateBankAccountInput;
import lk.harshana.graphql.domain.Currency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver{

	public BankAccount createBankAccount(CreateBankAccountInput input) {
		log.info("create bank account mutaion resolver");
		
		return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).build();
	}
}
