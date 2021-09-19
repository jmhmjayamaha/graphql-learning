package lk.harshana.graphql.resolver;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import lk.harshana.graphql.domain.BankAccount;
import lk.harshana.graphql.domain.Client;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount>{

	private final ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
	);
	
	public CompletableFuture<Client> client(BankAccount bankAccount) {
		log.info("cilent resolve");
		
		return CompletableFuture.supplyAsync(
				() -> {
					log.info("inside completableFuture ( new Thread)");
					return Client.builder()
							.id(bankAccount.getId())
							.firstName("kawshalya")
							.lastName("madushani")
							.build();
				}
				,executorService);
		
	}
	 
}
