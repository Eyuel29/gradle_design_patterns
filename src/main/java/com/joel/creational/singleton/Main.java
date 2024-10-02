package com.joel.creational.singleton;

import java.io.UncheckedIOException;
import java.net.http.HttpClient;
import java.util.concurrent.Future;
import com.joel.creational.singleton.HttpClientProvider;

public class Main{
	public static void main(String[] args){
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run(){
				HttpClient client1 = HttpClientProvider.getInstance().getClient();
				System.out.println("Thread 1 " + client1);
			}
		});


		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run(){
				HttpClient client2 = HttpClientProvider.getInstance().getClient();
				System.out.println("Thread 2 " + client2);
			}
		});

		thread1.start();
		thread2.start();
	}
}
