package com.joel.singletonDemo;
import com.joel.singletonDemo.DatabaseManager;
import com.joel.singletonDemo.Database;

public class Main{
  public static void main(String[] args){
  
  Thread thread1 = new Thread(new Runnable(){
		@Override
		public void run(){
		  	Database db = DatabaseManager.getInstance().getDatabase();
  			System.out.println(db.getUser());
		}
  });
  
  Thread thread2 = new Thread(new Runnable(){
		@Override
		public void run(){
		  	Database db = DatabaseManager.getInstance().getDatabase();
  			System.out.println(db.getUser());
		}
  });
  
  thread1.start();
  thread2.start();
  
  }
}
