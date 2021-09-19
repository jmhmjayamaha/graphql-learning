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
	
 /*
  public DataFetcherResult<Client> client(BankAccount bankAccount) {
	  log.info("client resolver");
	  
	  // throw new GraphQLException("client not available"); 
	  // throw new RuntimeException("Spring error");
	  
	  return DataFetcherResult.<Client> newResult() .data(Client .builder()
		  .id(bankAccount.getId()) .firstName("harshana") .lastName("madusanka")
		  .build()) .error(new GenericGraphQLError("could not get last name"))
		  .build(); 
	  // return Client.builder().id(bankAccount.getId()).firstName("harshana").lastName("madusanka").build(); // return null; 
  
  }
  
  */
	 
}
