package lk.harshana.graphql.domain;

import java.util.UUID;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Client {

	private UUID id;
	private String firstName;
	private String lastName;
}
