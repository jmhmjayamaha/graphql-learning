package lk.harshana.graphql.exception;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

@Component
public class CustomGraphqlExceptionHandlar implements GraphQLErrorHandler {

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		// TODO Auto-generated method stub
		return errors;
	}

}
