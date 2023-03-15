package com.osgi.clothingstoredb;

import java.sql.Connection;

public interface DbContext {
	
	//interface for connection
	public Connection getDatabaseConnection();
	
	

}
