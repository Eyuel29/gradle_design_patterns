package com.joel.singletonDemo;
import java.io.UncheckedIOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;

public class HttpClientProvider{
	private static final HttpClientProvider INSTANCE = new HttpClientProvider();
	private volatile HttpClient client;

	public synchronized HttpClient getClient() throws UncheckedIOException{
		if (client == null) {
			client = HttpClient.newBuilder()
			.version(Version.HTTP_1_1)
			.followRedirects(Redirect.NORMAL)
			.connectTimeout(Duration.ofSeconds(150))
			.build();
		}	
		return client;
	}

	private HttpClientProvider(){

	}
	
	public static HttpClientProvider getInstance(){ 
		return INSTANCE; 
	}
}
