package com.manfredipiraino.db;

import java.sql.*;

public class MyBiblioteca {
	
		// Stringhe di connessione
		private static String url = "jdbc:mysql://localhost/biblioteca?";
		private static String user = "root";
		private static String password = "0_mysql_1";
		final private static String MYSEPARATOR="_____________________________________";
			
		// Oggetti Java.SQL
		// Connessione al DB
		private static Connection myConnection = null;
		
		// Istruzioni SQL		
		private static PreparedStatement myPreparedStatement = null;
		private static CallableStatement myCallableStatement = null;
		
		// Contiene l'insieme dei risultati delle SELECT
		private static ResultSet myResultSet = null;

		// Proprietà  corrispondenti ai campi della tabella
		/*libri*/
		private static String ISBN;
		private static String titolo;
		private static String autore;
		/*copie_libro*/
		private static int idcopie_libro;
		private static String libro;
		/*utenti*/
		private static String CF;
		private static String nome;
		private static String cognome;
		/*prestiti*/
		private static int id_prestito;
		private static int copia_libro;
		private static String utente;
		
	public static void main(String[] args) {
		try {
			myConnection = DriverManager.getConnection(url, user, password);	
			System.out.println("Connessione al Data Base riuscita");
			
			/* Select */
			// mySelectUtenti();
			
			/* Insert, Update, Delete*/
			// myInsertUtente();
			// myUpdateUtente();
			// myDeleteUtente();
			
			/* Callable stored procedure con INNERJOIN*/
			// myStoredGetAllTables("Mario");
			
		} catch (SQLException e) {
			System.out.println("Erore: " + e.getMessage());
		}
	}
	static void mySelectUtenti() {
		try {
			String mySelect = "SELECT * FROM utenti";
			myPreparedStatement = myConnection.prepareStatement(mySelect);
			
			/*
			NON SI PUò PARAMETRIZZARE LA TABLE
			myPreparedStatement.setString(1, table);
			System.out.println(myPreparedStatement);
			*/
			
			myResultSet = myPreparedStatement.executeQuery();
			// Itera il resultset
			while (myResultSet.next()) {
				/*
				idcopie_libro=myResultSet.getInt("idcopie_libro");
				libro=myResultSet.getString("libro");
				System.out.println("idcopie_libro: " + idcopie_libro + " libro: " + libro);
				
				ISBN=myResultSet.getString("ISBN");
				titolo=myResultSet.getString("titolo");
				autore=myResultSet.getString("autore");
				System.out.println("ISBN: " + ISBN + " titolo: " + titolo + " autore: " + autore);
				
				id_prestito=myResultSet.getInt("id_prestito");
				copia_libro=myResultSet.getInt("copia_libro");
				utente=myResultSet.getString("utente");
				System.out.println("id_prestito: " + id_prestito + " copia_libro: " + copia_libro + " utente: " + utente);
				*/
				CF=myResultSet.getString("CF");
				nome=myResultSet.getString("nome");
				cognome=myResultSet.getString("cognome");
				System.out.println("Nome: " + nome + " Cognome: " + cognome + " CF: " + CF);
			}
		} catch(SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			/* Al termine del loro utilizzo, gli oggetti ResultSet, PreparedStatement e Connection
			devono essere chiusi, per permettere al sistema di liberare le risorse precedentemente impegnate
			*/
			if(myResultSet != null)
			try {
				myResultSet.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myPreparedStatement != null)
			try {
				myPreparedStatement.close();
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
	static void myInsertUtente() throws SQLException {
		try {
			// Valori da inserire
			String CF ="FSEFGSDFWFWEF267Y";
			String nome = "Mirco";
			String cognome = "Neri";
			// Stringa SQL
			String myInsert = "INSERT INTO utenti(nome, cognome, CF) VALUES(?,?,?)";
			
			myPreparedStatement = myConnection.prepareStatement(myInsert);
			myPreparedStatement.setString(1, nome);
			myPreparedStatement.setString(2, cognome);
			myPreparedStatement.setString(3, CF);
			myPreparedStatement.executeUpdate();
			// Stampa ok
			System.out.println("OK: inserito un nuovo record");
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
			if(myPreparedStatement != null)
			try {
				myPreparedStatement.close();
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
	// UPDATE (con Transazione)
	static void myUpdateUtente() throws SQLException {
		try {
		String mySurname = "Neri";
		String myNewSurname = "Bianchi";
		// Stringa SQL
		String myUpdate = "UPDATE utenti SET cognome=? WHERE cognome=?";
		myPreparedStatement = myConnection.prepareStatement(myUpdate);
		myPreparedStatement.setString(1, myNewSurname);
		myPreparedStatement.setString(2, mySurname);
		
		myPreparedStatement.executeUpdate();
		// Stampa ok
		System.out.println("OK: aggiornato il record");		
		} catch(SQLException e) {
			System.out.println("Errore: " + e.getMessage());	
		} finally {
			if(myPreparedStatement != null)
			try {
				myPreparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myConnection != null)
			try {
				myConnection.close();
			} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
			}
			System.out.println("Finally: chiuso preaparedStatement & connection" );
		}
	}
	// DELETE
	static void myDeleteUtente() throws SQLException {
		try {
			String myCF = "FSEFGSDFWFWEF267Y";
			// Stringa SQL
			String myDelete = "DELETE FROM utenti WHERE CF=?";
			myPreparedStatement = myConnection.prepareStatement(myDelete);
			myPreparedStatement.setString(1, myCF);		
			myPreparedStatement.executeUpdate();
			// Stampa ok
			System.out.println("OK: eliminato il record");
		}catch(SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}finally {
			if(myPreparedStatement != null)
			try {
				myPreparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myConnection != null)
			try {
				myConnection.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			System.out.println("Finally: chiuso preaparedStatement & connection" );
		}
	}
	/* CallableStatement con INNERJOIN*/
	static void myStoredGetAllTables(String nome) throws SQLException {
		try {
			myCallableStatement = myConnection.prepareCall("{call GetAllTablesWithName(?)}");
			myCallableStatement.setString(1, nome);
			myResultSet = myCallableStatement.executeQuery();
			// Itera il resultset
			while (myResultSet.next()) {
				id_prestito=myResultSet.getInt("id_prestito");
				copia_libro=myResultSet.getInt("copia_libro");
				utente=myResultSet.getString("utente");
				nome=myResultSet.getString("nome");
				cognome=myResultSet.getString("cognome");
				ISBN=myResultSet.getString("ISBN");
				titolo=myResultSet.getString("titolo");
				autore=myResultSet.getString("autore");
				System.out.println("id_prestito: "+id_prestito+" copia_libro: "+copia_libro+" utente: "+utente+"\nnome: "+nome+" cognome: "+cognome+" ISBN: " + ISBN + " titolo: " + titolo + " autore: " + autore);
				System.out.println(MYSEPARATOR);
			}
		}catch(SQLException e){
			System.out.println("Errore: " + e.getMessage());
		}finally {
			/* Al termine del loro utilizzo, gli oggetti ResultSet, PreparedStatement e Connection
			devono essere chiusi, per permettere al sistema di liberare le risorse precedentemente impegnate
			*/
			if(myResultSet != null)
			try {
				myResultSet.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myPreparedStatement != null)
			try {
				myPreparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			if(myConnection != null)
			try {
				myConnection.close();
			} catch (SQLException e) {
				System.out.println("Errore: " + e.getMessage());
			}
			System.out.println("Finally: chiuso preaparedStatement & connection & resultSet" );
		}
		
	}

}
