package lk.harshana.graphql.listener;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingListener implements GraphQLServletListener {

	private final Clock clock;
	
	@Override	
	public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
		var startTime = Instant.now();  
		
		return new RequestCallback() {
			  
			@Override
			public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
				// no-ops
			}

			@Override
			public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
				// no-ops
			}

			@Override
			public void onFinally(HttpServletRequest request, HttpServletResponse response) {
				log.info("Compeleted request time duration :: {}", Duration.between(startTime, Instant.now()));
			}
			  
		  };
	}
}
