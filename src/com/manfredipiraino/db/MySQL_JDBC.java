package com.manfredipiraino.db;

import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL_JDBC {

	// Stringhe di connessione
	private static String url = "jdbc:mysql://localhost/mydb222?";
	private static String user = "root";
	private static String password = "0_mysql_1";
		
	// Oggetti Java.SQL
	// Connessione al DB
	private static Connection myConnection = null;
	
	// Istruzioni SQL
	private static Statement myStatement = null;		
	private static PreparedStatement myPreparedStatement = null;
	private static CallableStatement myCallableStatement = null;
	
	// Contiene l'insieme dei risultati delle SELECT
	private static ResultSet myResultSet = null;

	
	
	// Proprietà corrispondenti ai campi della tabella
	private static String nome;
	private static String cognome;
	private static int eta;

	public static void main(String[] args)  {
		try {
			myConnection = DriverManager.getConnection(url, user, password);			
			/* Select con Statement */
			// mySelect();			
			/* Insert, Update, Delete con PreparedStatement */
			// myInsert();
			// myUpdate();
			// myDelete();
			/* Update con Callable stored procedure */
			// myStoredUpdate();
			
			/* Join */
			// myInnerJoin();
			myLeftJoin();

			// Chiude la connessione
			// myConnection.close();
			
		} catch (SQLException e) {
			//Logger myLogger = Logger.getLogger(SQLException.class.getName());
			//myLogger.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Erore: " + e.getMessage());
		}
		System.out.println("Connessione al db riuscita");
	}

	// SELECT
	static void mySelect() {
		/* L'interfaccia Statement viene utilizzata per eseguire normali query SQL. 
		Non è possibile passare i parametri alla query SQL in fase di esecuzione
		Preferibile se si esegue una particolare query SQL solo una volta. 
		Le prestazioni sono molto inferiori rispetto altre due interfacce.
		*/
		try {
			myStatement = myConnection.createStatement();
			String mySelect = "SELECT * FROM mytable";
			myResultSet = myStatement.executeQuery(mySelect);
			// Itera il resultset
			while (myResultSet.next()) {
				nome = myResultSet.getString("nome");
				cognome = myResultSet.getString("cognome");
				eta = myResultSet.getInt("eta");
				System.out.println("Nome: " + nome + " Cognome: " + cognome + " Eta: " + eta);
			}
		} catch(SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			/* Al termine del loro utilizzo, gli oggetti ResultSet, Statement e Connection
			devono essere chiusi, per permettere al sistema di liberare le risorse precedentemente impegnate
			*/
			if(myResultSet != null)
			try {
				myResultSet.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myStatement != null)
			try {
				myStatement.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myConnection != null)
			try {
				myConnection.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
		}
	}

	// INSERT
	static void myInsert() throws SQLException {
		// Valori da inserire
		String nome = "Ciro";
		String cognome = "Gialli";
		int eta = 55;
		// Stringa SQL
		String myInsert = "INSERT INTO mytable(nome, cognome, eta) VALUES(?,?,?)";
		/*
		PreapredStatement, estende l'interfaccia Statement 
		Utilizzato per eseguire query SQL dinamiche o parametrizzate. 
		È possibile passare i parametri alla query SQL in fase di esecuzione. 
		Preferibile se si esegue più volte una particolare query SQL. 
		Offre prestazioni migliori rispetto all'interfaccia Statement, 
		è precompilato e il piano di query viene creato solo una volta
		indipendentemente da quante volte si esegue quella query.
		*/
		myPreparedStatement = myConnection.prepareStatement(myInsert);
		myPreparedStatement.setString(1, nome);
		myPreparedStatement.setString(2, cognome);
		myPreparedStatement.setInt(3, eta);
		myPreparedStatement.executeUpdate();
		// Stampa ok
		System.out.println("OK: inserito un nuovo record");
		myPreparedStatement.close();
	}

	// UPDATE (con Transazione)
	static void myUpdate() throws SQLException {
		try {
		String myName = "Ciro";
		String myNewName = "Pino";
		// Stringa SQL
		String myUpdate = "UPDATE mytable SET nome=? WHERE nome=?";
		myPreparedStatement = myConnection.prepareStatement(myUpdate);
		myPreparedStatement.setString(1, myNewName);
		myPreparedStatement.setString(2, myName);
		/* Transazione 
		Grazie alle transazioni è possibile mantenere l’integrità dei dati evitando che si possano verificare
		situazioni anomale che potrebbero portare ad errori.
		Tutte le istruzioni eseguite all’interno di una transazione vengono gestite come se fossero un’unica 
		istruzione atomica che può andare a buon fine o fallire nella sua interezza.
		*/
		// Disabilita commit automatico
		myConnection.setAutoCommit(false);
		myPreparedStatement.executeUpdate();
		myConnection.commit();
		// Stampa ok
		System.out.println("OK: aggiornato il record con commit");		
		} catch(SQLException e) {
			myConnection.rollback();
			System.out.println("Errore: " + e.getMessage());	
		} finally {
			myPreparedStatement.close();
			System.out.println("Finally: chiuso statement" );
		}
	}

	// DELETE
	static void myDelete() throws SQLException {
		String myName = "Pino";
		// Stringa SQL
		String myDelete = "DELETE FROM mytable WHERE nome=?";
		myPreparedStatement = myConnection.prepareStatement(myDelete);
		myPreparedStatement.setString(1, myName);		
		myPreparedStatement.executeUpdate();
		// Stampa ok
		System.out.println("OK: eliminato il record");
		myPreparedStatement.close();
	}
	
	/* CallableStatement */
	static void myStoredUpdate() throws SQLException {
		/*
		Estende PreparedStatement, utilizzato per eseguire le stored procedure. 
		Può passare 3 tipi di parametri alle stored procedure: 
		- IN: per passare i valori alla procedura memorizzata, 
		- OUT: per contenere il risultato restituito dalla procedura memorizzata 
		- IN OUT: funge sia da parametro IN che OUT. 
		Prima di chiamare la procedura memorizzata, è necessario registrare i parametri 
		OUT utilizzando il metodo registerOutParameter() di CallableStatement. 
		Le prestazioni sono superiori rispetto alle altre due interfacce, perché chiama
		le stored procedure che sono già compilate e memorizzate nel server di database.
		*/
		myCallableStatement = myConnection.prepareCall("{call myProcedureUpdate(?)}");
		myCallableStatement.setString(1, "Ciro");
		myCallableStatement.execute();
		System.out.println("OK: Update da procedura eseguito");
		myCallableStatement.close();
	}

	/* Inner Join
	Visualizza tutte le righe in cui i valori di due campi corrispondono
	*/
	static void myInnerJoin() throws SQLException {
		String cliente;
		String prodotto;
		double prezzo = 0;
		//myStatement = myConnection.createStatement();
		
		/*
		1. Select semplice 
		String mySelect = "SELECT * FROM ordini"; 
		myResultSet = myStatement.executeQuery(mySelect); 
		while (myResultSet.next()) { 
			cliente = myResultSet.getString("id_cliente"); 
			prodotto =	myResultSet.getString("id_prodotto"); 
			System.out.println("Cliente: " + cliente + ", Prodotto: " + prodotto); 
		} 
		myStatement.close();
		*/

		/*
		2. Join semplice 
		String myJoinSelect = "SELECT * FROM clienti, ordini WHERE clienti.id_cliente = ordini.id_cliente ORDER BY clienti.id_cliente"; 
		myResultSet = myStatement.executeQuery(myJoinSelect); 
		while* (myResultSet.next()) { 
			prodotto = myResultSet.getString("ordini.id_prodotto"); 
			cliente = myResultSet.getString("clienti.id_cliente"); 
			System.out.println("Cliente: " +* cliente + ", Prodotto: " + prodotto); 
		} 
		myStatement.close();
	    */
		String myInnerJoin = "" 
				+ "SELECT * FROM clienti " 
				+ "INNER JOIN ordini "
				+ "ON clienti.id_cliente = ordini.id_cliente " 
				+ "INNER JOIN prodotti "
				+ "ON ordini.id_prodotto = prodotti.id_prodotto " 
				+ "ORDER BY clienti.id_cliente";
		myPreparedStatement = myConnection.prepareStatement(myInnerJoin);
		myResultSet = myPreparedStatement.executeQuery();
		while (myResultSet.next()) {
			cliente = myResultSet.getString("clienti.nome");
			prodotto = myResultSet.getString("prodotti.nome");
			prezzo = myResultSet.getDouble("prodotti.prezzo");
			System.out.println("Cliente: " + cliente + ", Prodotto: " + prodotto + ", Prezzo: " + prezzo);
		}
		myPreparedStatement.close();
	}

	/* Left Join
	Visualizza tutte le righe anche se i valori di due campi non corrispondono
	*/
	static void myLeftJoin() throws SQLException {
		String cliente;
		String prodotto;
		double prezzo = 0;
		String myLeftJoin = "" 
				+ "SELECT * FROM clienti " 
				+ "LEFT JOIN ordini "
				+ "ON clienti.id_cliente = ordini.id_cliente " 
				+ "LEFT JOIN prodotti "
				+ "ON ordini.id_prodotto = prodotti.id_prodotto " 
				+ "ORDER BY clienti.id_cliente";
		myPreparedStatement = myConnection.prepareStatement(myLeftJoin);
		myResultSet = myPreparedStatement.executeQuery();
		while (myResultSet.next()) {
			cliente = myResultSet.getString("clienti.nome");
			prodotto = myResultSet.getString("prodotti.nome");
			prezzo = myResultSet.getDouble("prodotti.prezzo");
			System.out.println("Cliente: " + cliente + ", Prodotto: " + prodotto + ", Prezzo: " + prezzo);
		}
		myPreparedStatement.close();
	}

}