package com.manfredipiraino.my.exe.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyEXE_JDBC {
	private static String url = "jdbc:mysql://localhost/tirocinio?";
	private static String user = "root";
	private static String password = "0_mysql_1";
	final private static String MYSEPARATOR = "_____________________________________";
	// Connessione al DB
	private static Connection myConnection = null;
	// Istruzioni SQL
	private static PreparedStatement myPreparedStatement = null;
	private static CallableStatement myCallableStatement = null;

	// Contiene l'insieme dei risultati delle SELECT
	private static ResultSet myResultSet = null;

	public static void main(String[] args) {

		try {
			myConnection = DriverManager.getConnection(url, user, password);
			System.out.println("Connessione al Data Base riuscita");

			/* metodi */
			/* metodi tirocinante */
			// List myListOfTrainees=cercaTirocinantiPerMatricola(11112);
			// List myListOfTrainees=cercaTirocinantiPerNome("%a%");
			// printListTirocinante(myListOfTrainees);
			// insertTirocinante();
			// deleteTirocinante("11119");
			// updateTirocinante("11112");

			/* metodi tutor */
			// List myListOfTutors=cercaTutor("Aldo","Rossi");
			// printListTutor(myListOfTutors);
			// insertTutor();
			// updateTutor(4);
			// deleteTutor(4);

			/* ricerca tirocinante per azienda */
			//List myListOfTrainees=cercaTirocinantiPerAzienda("Apple");
			//printListTirocinanteEAzienda(myListOfTrainees);

		} catch (SQLException e) {
			System.out.println("Erore: " + e.getMessage());
		}

	}

	static void printListTirocinante(List<Tirocinante> myList) {
		Iterator<Tirocinante> myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			Tirocinante myTirocinante = myIterator.next();
			System.out.println("{Id: " + myTirocinante.getId() + " Matricola: " + myTirocinante.getMatricola()
					+ " Nome: " + myTirocinante.getNome() + " Cognome: " + myTirocinante.getCognome() + " Classe: "
					+ myTirocinante.getClasse() + " idazienda: " + myTirocinante.getIdazienda() + " idtutor: "
					+ myTirocinante.getIdtutor() + "}");
		}
	}
	static void printListTirocinanteEAzienda(List<Tirocini> myList) {
		Iterator<Tirocini> myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			Tirocini myJoinedTable = myIterator.next();
			Tirocinante myTirocinante= myJoinedTable.getMyTrainee();
			Tutor myTutor= myJoinedTable.getMyTutor();
			Azienda myAgency= myJoinedTable.getMyAgency();
			System.out.println("{Id: " + myTirocinante.getId() + " Matricola: " + myTirocinante.getMatricola()
					+ " Nome: " + myTirocinante.getNome() + " Cognome: " + myTirocinante.getCognome() + " Classe: "
					+ myTirocinante.getClasse() + "\n idazienda: " + myTirocinante.getIdazienda() +" nome azienda: "+myAgency.getNome()+
					" luogo azienda: "+myAgency.getLuogo()+"\n idtutor: "+ myTirocinante.getIdtutor() +" nome tutor: "+ myTutor.getNome() +" "+myTutor.getCognome()+ "}");
		}
	}
	static void printListTutor(List<Tutor> myList) {
		Iterator<Tutor> myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			Tutor myTutor = myIterator.next();
			System.out.println("{Id: " + myTutor.getId() + " Nome: " + myTutor.getNome() + " Cognome: "
					+ myTutor.getCognome() + " Classe: " + myTutor.getMateria() + "}");
		}
	}

	static List<Tirocinante> cercaTirocinantiPerMatricola(int matricola) {

		List<Tirocinante> myListOfTrainees = new ArrayList<Tirocinante>();
		try {
			String mySelect = "SELECT * FROM tirocinante WHERE matricola=?";
			myPreparedStatement = myConnection.prepareStatement(mySelect);
			myPreparedStatement.setInt(1, matricola);

			myResultSet = myPreparedStatement.executeQuery();

			// Itera il resultset
			while (myResultSet.next()) {
				myListOfTrainees.add(new Tirocinante(myResultSet.getInt("id"), myResultSet.getString("matricola"),
						myResultSet.getString("nome"), myResultSet.getString("cognome"),
						myResultSet.getString("classe"), myResultSet.getInt("idazienda"),
						myResultSet.getInt("idtutor")));
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myResultSet != null)
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
		}

		return myListOfTrainees;
	}

	static List<Tirocinante> cercaTirocinantiPerNome(String nome) {

		List<Tirocinante> myListOfTrainees = new ArrayList<Tirocinante>();
		try {
			String mySelect = "SELECT * FROM tirocinante WHERE nome LIKE ?";
			myPreparedStatement = myConnection.prepareStatement(mySelect);
			myPreparedStatement.setString(1, nome);

			myResultSet = myPreparedStatement.executeQuery();

			// Itera il resultset
			while (myResultSet.next()) {
				myListOfTrainees.add(new Tirocinante(myResultSet.getInt("id"), myResultSet.getString("matricola"),
						myResultSet.getString("nome"), myResultSet.getString("cognome"),
						myResultSet.getString("classe"), myResultSet.getInt("idazienda"),
						myResultSet.getInt("idtutor")));
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myResultSet != null)
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
		}

		return myListOfTrainees;
	}

	static List<Tutor> cercaTutor(String nome, String cognome) {
		List<Tutor> myTutorList = new ArrayList<>();

		try {
			String mySelect = "SELECT * FROM tutor WHERE nome=? AND cognome=?";
			myPreparedStatement = myConnection.prepareStatement(mySelect);

			myPreparedStatement.setString(1, nome);
			myPreparedStatement.setString(2, cognome);

			myResultSet = myPreparedStatement.executeQuery();

			// Itera il resultset
			while (myResultSet.next()) {
				myTutorList.add(new Tutor(myResultSet.getInt("id"), myResultSet.getString("nome"),
						myResultSet.getString("cognome"), myResultSet.getString("materia")));
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myResultSet != null)
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
		}
		return myTutorList;
	}

	static void insertTirocinante() {
		try {
			String matricola = "11119";
			String nome = "Mirco";
			String cognome = "Neri";
			String classe = "4D";
			int idazienda = 4;
			int idtutor = 1;

			String myInsert = "INSERT INTO tirocinante(matricola, nome, cognome, classe,idazienda,idtutor) VALUES(?,?,?,?,?,?)";

			myPreparedStatement = myConnection.prepareStatement(myInsert);
			myPreparedStatement.setString(1, matricola);
			myPreparedStatement.setString(2, nome);
			myPreparedStatement.setString(3, cognome);
			myPreparedStatement.setString(4, classe);
			myPreparedStatement.setInt(5, idazienda);
			myPreparedStatement.setInt(6, idtutor);
			myPreparedStatement.executeUpdate();

			System.out.println("Nuovo record inserito");
		} catch (SQLException e) {
			System.out.println("Errore: /n" + e.getMessage());
		} finally {
			if (myResultSet != null)
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
		}
	}

	static void updateTirocinante(String matricola) {
		try {
			String myNewClass = "4C";

			String myUpdate = "UPDATE tirocinante SET classe=? WHERE matricola=?";
			myPreparedStatement = myConnection.prepareStatement(myUpdate);

			myPreparedStatement.setString(1, myNewClass);
			myPreparedStatement.setString(2, matricola);

			myPreparedStatement.executeUpdate();

			System.out.println("OK: aggiornato il record");
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			System.out.println("Finally: chiuso preaparedStatement & connection");
		}
	}

	static void deleteTirocinante(String matricola) {
		try {

			String myDelete = "DELETE FROM tirocinante WHERE matricola=?";
			myPreparedStatement = myConnection.prepareStatement(myDelete);
			myPreparedStatement.setString(1, matricola);
			myPreparedStatement.executeUpdate();

			System.out.println("OK: eliminato il record");
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			System.out.println("Finally: chiuso preaparedStatement & connection");
		}
	}

	static void insertTutor() {
		try {
			String nome = "Steven";
			String cognome = "Hawking";
			String materia = "Fisica";

			String myInsert = "INSERT INTO tutor( nome, cognome, materia) VALUES(?,?,?)";

			myPreparedStatement = myConnection.prepareStatement(myInsert);
			myPreparedStatement.setString(1, nome);
			myPreparedStatement.setString(2, cognome);
			myPreparedStatement.setString(3, materia);
			myPreparedStatement.executeUpdate();

			System.out.println("Nuovo record inserito");
		} catch (SQLException e) {
			System.out.println("Errore: /n" + e.getMessage());
		} finally {
			if (myResultSet != null)
				try {
					myResultSet.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
		}
	}

	static void updateTutor(int id) {
		try {
			String mySubject = "Fisica teorica";
			String myUpdate = "UPDATE tutor SET materia=? WHERE id=?";
			myPreparedStatement = myConnection.prepareStatement(myUpdate);

			myPreparedStatement.setString(1, mySubject);
			myPreparedStatement.setInt(2, id);

			myPreparedStatement.executeUpdate();

			System.out.println("OK: aggiornato il record");
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			System.out.println("Finally: chiuso preaparedStatement & connection");
		}
	}

	static void deleteTutor(int id) {
		try {

			String myDelete = "DELETE FROM tutor WHERE id=?";
			myPreparedStatement = myConnection.prepareStatement(myDelete);
			myPreparedStatement.setInt(1, id);
			myPreparedStatement.executeUpdate();

			System.out.println("OK: eliminato il record");
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
			if (myPreparedStatement != null)
				try {
					myPreparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			if (myConnection != null)
				try {
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Errore: " + e.getMessage());
				}
			System.out.println("Finally: chiuso preaparedStatement & connection");
		}
	}

	static List<Tirocini> cercaTirocinantiPerAzienda(String nomeAzienda){
		List <Tirocini> myListOfTrainees=new ArrayList<Tirocini>();
		try {
			String mySelect = "SELECT * FROM tirocinante "+
								" INNER JOIN azienda "+
								" ON idazienda=azienda.id "+
								" INNER JOIN tutor "+
								" ON idtutor=tutor.id "+
								" WHERE azienda.nome=?;";
			myPreparedStatement = myConnection.prepareStatement(mySelect);
			myPreparedStatement.setString(1, nomeAzienda);
			
			myResultSet = myPreparedStatement.executeQuery();
			
			// Itera il resultset
			while (myResultSet.next()) {
				myListOfTrainees.add(new Tirocini(new Tutor(myResultSet.getInt("tutor.id"),myResultSet.getString("tutor.nome"),myResultSet.getString("tutor.cognome"),myResultSet.getString("materia")),
									new Azienda(myResultSet.getInt("azienda.id"),myResultSet.getString("azienda.nome"),myResultSet.getString("luogo"),myResultSet.getString("settore"),myResultSet.getString("tipologia")),
									new Tirocinante(myResultSet.getInt("tirocinante.id"),myResultSet.getString("matricola"),myResultSet.getString("tirocinante.nome"),myResultSet.getString("tirocinante.cognome"),myResultSet.getString("classe"),myResultSet.getInt("idazienda"),myResultSet.getInt("idtutor"))));
			}
		}catch(SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		} finally {
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
		
		return myListOfTrainees;
	}
}
