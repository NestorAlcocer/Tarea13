package com.example.pm1_tarea13;

public class Transiciones
{

    public static final String NameDataBase = "DB13";

    public static final String tablaEmpleados = "empleados";


    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";


    public static final String CreateTableEmpleados = "CREATE TABLE empleados " +
                                                    "( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                    " nombres TEXT, apellidos TEXT, edad INTEGER, "+
                                                    " correo TEXT, direccion TEXT)";

    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";
}
