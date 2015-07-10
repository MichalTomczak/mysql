package mysql;

import java.sql.*;
import java.util.*;
public class database { 

	public database(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("worked");
		}
		catch(ClassNotFoundException e){
			System.out.println("Not found");
		}
		try{
			//get a connectoin to database
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/cars", "root", "");
			
			//create a statement
			Statement myStatement = myCon.createStatement();
			//execute SQL query
			ResultSet myRs = myStatement.executeQuery("SELECT * FROM `top gear`");
			//process result set
			while(myRs.next()){
				System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Horse Power"));
				}
			}
		catch(SQLException ex){
				System.out.println("additoin unsuccessful");
			}
		catch(Exception e){
			System.out.println("Error " + e);
			//e.printStackTrace();
		}
		}//end of database()
		

			
	
	 public void addData(){
		 try{
			 Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/cars", "root", "");
		 
			//insert new entry
				String manufac, model, year, hp, price, zeroto60 = null;
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter a manufacturer ");
				manufac = scan.nextLine();
				System.out.println("Enter a model ");
				model = scan.nextLine();
				System.out.println("Enter a year ");
				year = scan.nextLine();
				System.out.println("Enter Horse Power ");
				hp = scan.nextLine();
				System.out.println("Enter a price ");
				price = scan.nextLine();
				System.out.println("Enter the acceleration in 0 to 60 ");
				zeroto60 = scan.nextLine();
				
				
				String sql = "INSERT INTO `top gear`(`Manufacturer`, `Model`, `Year`, `Horse Power`, `Price`, `0 to 60`) VALUES (?,?,?,?,?,?)";
				try{
				PreparedStatement preparedstatement = myCon.prepareStatement(sql);
				preparedstatement.setString(1, manufac);
				preparedstatement.setString(2, model);
				preparedstatement.setString(3, year);
				preparedstatement.setString(4, hp);
				preparedstatement.setString(5, price);
				preparedstatement.setString(6, zeroto60);
				preparedstatement.executeUpdate();
				
				myCon.close();
		 
				}
				catch(Exception e){}
		 }//end of try
		 catch(Exception e){
			 
		 }//end of catch
	 
	
	 }//end of add()
	 public void search(){
		 try{
		 //String manufac, model, year, hp, price, zeroto60 = null;
		 Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/cars", "root", "");
			Scanner scan = new Scanner(System.in);
			menu();
			//create a statement
			Statement myStatement = myCon.createStatement();
			//execute SQL query
			
			//process result set
			
			//select what to search
			int choice =scan.nextInt();
			System.out.println("Please enter a search parameter");
			switch(choice){
			case 1:{	
				System.out.println("Enter a manufacturer ");
				String manufac = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `Manufacturer` = '" + manufac +"'";
				ResultSet myRs = myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));
					}
				break;}
			case 2:{
				System.out.println("Enter a model ");
				String model = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `Model` = '" + model +"'";
				ResultSet myRs = myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));}
				break;}
			case 3:{
				System.out.println("Enter a year ");
				String year = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `Year` = '" + year +"'";
				ResultSet myRs = myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));
				}
				break;}
			case 4:{
				System.out.println("Enter Horse Power ");
				String hp = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `Horse Power` = '" + hp +"'";
				ResultSet myRs = myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));
				}
				break;}
			case 5:{
				System.out.println("Enter a price ");
				String price = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `Price` = '" + price +"'";
				ResultSet myRs = myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));
				}
				break;}
			case 6:{
				System.out.println("Enter the acceleration in 0 to 60 ");
				String zeroto60 = scan.next();
				String sql =  "SELECT * FROM `top gear` WHERE `0 to 60` = '" + zeroto60 +"'";
				ResultSet myRs =myStatement.executeQuery(sql);
				while(myRs.next()){
					System.out.println(myRs.getString("Manufacturer") + " " + myRs.getString("Model") + " " +  myRs.getString("Year") + " " + myRs.getString("Horse Power") + " " + myRs.getString("Price") + " " + myRs.getString("0 to 60"));
				}
				break;}
			}
		 }//end of try
		 catch(SQLException ex){
			 System.out.println("error search");
			 
		 }
			
	 }
	 public void menu(){
			System.out.println("1: Manufacturer");
			System.out.println("2: Model");
			System.out.println("3: Year");
			System.out.println("4: Horse Power");
			System.out.println("5: Price");
			System.out.println("6: 0 to 60");
		}
	 public void sort(){
		 Connection myCon = null;
		 Statement myStat = null;
		 try{
		 //register JDBC Driver
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 //create connection
		myCon = DriverManager.getConnection("jdbc:mysql://localhost/cars", "root", "");
		 //execute query
		 myStat = myCon.createStatement();
		 //get records in ascending order
		 System.out.println("Getting cars in ascending order by year");
		 String sql ="SELECT * FROM `top gear` ORDER BY `Year` ASC";
		 ResultSet rs = myStat.executeQuery(sql);
		 
		 while(rs.next()){
			 int year = rs.getInt("Year");
			 int hp = rs.getInt("Horse Power");
			 String model = rs.getString("Model");
			 String manu =rs.getString("Manufacturer");
			System.out.printf("\n%s\t%s\t%s\t%s\n", manu, model, year, hp); 
		 }
		 rs.close();
		 }//end of try
		 
		 catch(SQLException ex){
			 ex.printStackTrace();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally{
			 try{
				 if(myStat != null)
					 myCon.close();
			 }
			 catch(SQLException se){}
			 try{
				if( myCon != null)
					myCon.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
		 }//end finally
	 }
	 
		
}//end of class

