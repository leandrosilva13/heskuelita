package com.aplication;


public class App {

public static void main (String [] args) throws Exception {
//Establecer declaracion de las columnas.
    String [] setColumns = {"id serial not null primary key", "FirstName varchar(100)" ,"LastName varchar(100)" ,"BD Date"};
    String [] selectColumns = {"id"};
    String [] newvals = {"1","'hernan'","'nievas'"};
//Establecer nombre de la tabla a crear.
    //DBManager.createTable("newtable1", setColumns);

    // Establecer nombre de la tabla a borrar.
   // DBManager.deleteTable("newtablex");

    //insertar nuevos datos a una tabla.
   // DBManager.insertTable("newtable1",newvals);
    DBManager.readTable("newtable1");







}

}