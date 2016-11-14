package com.faobruzen.spring.config;

import org.springframework.util.Assert;



public class DataSourceContextHolder {
		
	 private static final ThreadLocal<DatabaseType> contextHolder = 
	            new ThreadLocal<DatabaseType>();
		
	   public static void setDatabaseType(DatabaseType databaseType) {
	      Assert.notNull(databaseType, "databaseType cannot be null");
	      contextHolder.set(databaseType);
	   }

	   public static DatabaseType getDatabaseType() {
	      return (DatabaseType) contextHolder.get();
	   }

	   public static void clearDatabaseType() {
	      contextHolder.remove();
	   }	

}
