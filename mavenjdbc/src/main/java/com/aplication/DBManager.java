package com.aplication;


import org.apache.log4j.Logger;

import javax.management.MBeanAttributeInfo;
import java.sql.*;

public class DBManager {

    private static final Logger logger = Logger.getLogger (DBManager.class);

    public DBManager () {

        super ();
    }

    public static Connection getConnection() throws Exception {

        try{

            String url = "jdbc:postgresql://localhost:5432/heskuelita";
            String username = "crimson";
            String password = "crimson";
            Class.forName ("org.postgresql.Driver");


            System.out.println("Connecting to DataBase...");
            Connection cnn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DataBase.");

            return cnn;
        }catch(Exception e){System.out.println(e);
            System.out.println("Cannot connect to DataBase.");
        }

        return null;

    }

    public static void createTable(String tableName, String[] columns) throws Exception{

        try {
            Connection cnn = DBManager.getConnection();

            String stringColumns = "";

            for(String str: columns) {
                if(stringColumns.length() != 0) {
                    stringColumns += ", ";
                }
                stringColumns += str;
            }


            PreparedStatement create = cnn.prepareStatement("CREATE TABLE IF NOT EXISTS "+ tableName+" ("+stringColumns+");");
            create.executeUpdate();
        } catch (Exception e){System.out.println(e);}

        finally {
            System.out.println("Function Complete.");
        }

    }
        public static void deleteTable (String tableName) throws  Exception{

        try {
            Connection cnn = DBManager.getConnection();

            PreparedStatement delete = cnn.prepareStatement("DROP TABLE "+tableName+";");
            delete.executeUpdate();
            System.out.println("The table "+tableName+" has been deleted.");
        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }finally {
            System.out.println("Function complete.");
        }
        }

        public static void insertTable (String table,String values[]) throws  Exception {

            try {


                Connection cnn = DBManager.getConnection();

                String stringValues = "";

                for (String str : values) {
                    if (stringValues.length() != 0) {
                        stringValues += ", ";
                    }
                    stringValues += str;
                }

                PreparedStatement insert = cnn.prepareStatement("INSERT INTO "+table+" "+" VALUES("+stringValues+");");
                insert.executeUpdate();
                }catch(SQLException se){

                se.printStackTrace();
            }catch(Exception e){

                e.printStackTrace();
            }
        }

        public static void readTable(String table) throws Exception{

        try {
            Connection cnn = DBManager.getConnection();

            Statement stmnt = cnn.createStatement();

            //PreparedStatement read = cnn.prepareStatement("SELECT * FROM "+table+";");

            ResultSet rs = stmnt.executeQuery("SELECT * FROM "+table+";");

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                Date bd = rs.getDate("bd");


                //Display values
                System.out.print("ID: " + id);
                System.out.print(", firstname: " + firstname);
                System.out.print(", lastname: " + lastname);
                System.out.println(", birthdate: " + bd);
            }
            rs.close();

        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }


        }

}


