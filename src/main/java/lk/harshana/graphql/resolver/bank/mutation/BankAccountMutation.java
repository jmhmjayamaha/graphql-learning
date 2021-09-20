package lk.harshana.graphql.resolver.bank.mutation;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.CreateBankAccountInput;
import lk.harshana.graphql.domain.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class BankAccountMutation implements GraphQLMutationResolver{
	
	private final Clock clock;

	public BankAccount createBankAccount(@Valid CreateBankAccountInput input) {
		log.info("create bank account mutaion resolver");
		
		return BankAccount
				.builder()
				.id(UUID.randomUUID())
				.currency(Currency.USD)
				.createdAt(ZonedDateTime.now(clock))
				.createdOn(LocalDate.now(clock))
				.build();
	}
}
