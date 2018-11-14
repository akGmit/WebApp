package com.student.DAOs;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;

import static org.neo4j.driver.v1.Values.parameters;

public class Neo4J {
	
	private final Driver driver;
	private Transaction tx;
	
	public Neo4J(String uri, String user, String password ) {
		driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
		
	}
	
	public void close() throws Exception
    {
        driver.close();
    }
	
	public Transaction getTransaction(String name)
    {
        Session session = driver.session();
        this.tx = session.beginTransaction();
        
        return this.tx;
    }
}
