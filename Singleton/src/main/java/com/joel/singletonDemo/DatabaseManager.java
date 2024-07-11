package com.joel.singletonDemo;
import com.joel.singletonDemo.Database;

public class DatabaseManager {

    private DatabaseManager() {}
    private volatile Database database;
    public static DatabaseManager getInstance(){ return INSTANCE; }
    private static final DatabaseManager INSTANCE = new DatabaseManager();
    
    public synchronized Database getDatabase(){
		if(this.database == null){
			this.database = new Database(
				"127.0.0.1",
				"Joel the sphinx", 
				"12345678", 
				3306
			);		
		}
		
		return this.database;
    }
}
