package com.manfredipiraino.db;
import java.sql.*;

public class MySqlDB {
	/*localhost3306 di default*/
	/*javadatabaseconnector=jdbc*/
	private static String url="jdbc:mysql://localhost/mydb?";
	private static String user="root";
	private static String password="0_mysql_1";
	
	/*private static String urlCompleta="jdbc:mysql://localhost/mydb?root/0_mysql_1"; controllare se giusto*/
	
	// Oggetti SQL
	/*Connessione SQL*/
	private static Connection myConnection=null;
	/*ISTRUZIONI SQL*/
	private static Statement myStatement=null;
	/*RACCHIUDE IL RISULTATO/L'INSIEME DEI RISULTATI DI UNO STATEMENTE SQL*/
	private static ResultSet myResultSet=null;
	
	public static CallableStatement myCallableStatement=null;
	
	private static PreparedStatement myPreparedStatement=null;
	
	private static String nome;
	private static String cognome;
	private static int eta;
	
	public static void main(String args[]) throws SQLException,ClassNotFoundException{
		try {
			myConnection=DriverManager.getConnection(url,user,password);
			System.out.println("Connessione al db riuscita");
			//mySelect();
			myInsert();
		}catch(SQLException e) {
			System.out.println("Connessione non riuscita"+e.getMessage());
		}
		
	}
	
	//SELECT
	static void mySelect() throws SQLException {
		try {
			myStatement=myConnection.createStatement();
			String mySelect="SELECT * FROM mytable";
			/*prende l'intera tabella*/
			myResultSet=myStatement.executeQuery(mySelect);
			
			while(myResultSet.next()) {
				nome= myResultSet.getString("nome");
				cognome= myResultSet.getString("cognome");
				eta=myResultSet.getInt("eta");
				System.out.println("Nome: "+nome+ " Cognome: "+cognome+" Eta: "+eta);
			}
		}catch(SQLException e) {
			
		}finally {
			/*blocco per chiudere tutte le risorse utilizzate*/
			if(myResultSet!=null)
				try {
				myResultSet.close();
				}catch(SQLException e) {
					
				}
			if(myStatement!=null)
				try {
					myStatement.close();
				}catch(SQLException e) {
					
				}
		}
		
		myStatement.close();
	}
	static void myInsert() throws SQLException {
		String nome="Ciro";
		String cognome="Gialli";
		int eta=55;
		String myInsert="INSERT INTO mytable(nome,cognome,eta) VALUES(?,?,?)";
		
		
		myPreparedStatement=myConnection.prepareStatement(myInsert);
		/*1,2,3 indicano la posizione del punto ? in cui lo statemente deve andare nel myInsert*/
		myPreparedStatement.setString(1, nome);
		myPreparedStatement.setString(2, cognome);
		myPreparedStatement.setInt(3, eta);
		myPreparedStatement.executeUpdate();
		
		System.out.print("Ok: inserito un nuovo record");
		myPreparedStatement.close();
		
	}
	static void mySotredUpdate() throws SQLException{
		
		myCallableStatement= myConnection.prepareCall("{call myProcedureUpdate(?}");
		myCallableStatement.setString(1, "cir");
		myCallableStatement.execute();
		myCallableStatement.close();
	}
}
