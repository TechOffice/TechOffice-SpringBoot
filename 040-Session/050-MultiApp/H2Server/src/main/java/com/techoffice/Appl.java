package com.techoffice;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.util.DatabaseManagerSwing;

public class Appl {
	
	
	public static void main(String[] args) {
		  try{
			  new Thread(new Runnable(){

					public void run() {
						try{
							Server server=new Server();
							  HsqlProperties props = new HsqlProperties();
							  props.setProperty("server.remote_open", true);
							  props.setProperty("server.port", "9003");
					          server.setDatabaseName(0, "test");
					          server.setDatabasePath(0, "mem:test;sql.enforce_strict_size=true");
							  server.setProperties(props);
							  server.start();		
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				  }).start();
				  
		  }catch(Exception e){
			  
		  }
			
		  try{
			  new Thread(new Runnable(){

					public void run() {
						  DatabaseManagerSwing.main(new String[]{});
					}
				  }).start();
		  }catch(Exception e){
			  
		  }
	}
}
