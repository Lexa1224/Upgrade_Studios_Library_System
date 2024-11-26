package utiles;

import ConexionDB.ConexionDb;

import java.text.CompactNumberFormat;
import java.util.Scanner;

public class menuPrincipal {

    private int seleccion;
    private Scanner entradaOpcion ;
    private ConexionDb conexion;


    //constructor
    public menuPrincipal(){

        System.out.println("Bienvenido que desea hacer" +
                "\n 1)Consultar registro 2)Insertar Registro 0)Salir");
            entradaOpcion = new Scanner(System.in);

            //leemos la opcion
            seleccion = entradaOpcion.nextInt();

  //<>
            //validamos la entrada
            while(seleccion<0 && seleccion >3){
                System.out.println("Opcion no valida");
                seleccion = entradaOpcion.nextInt();
            }

            //creamos la instancia de la clase de BaseDeDatos

           conexion = new ConexionDb();

            //seleccionamos la opcion
            switch (seleccion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    conexion.LecturaBD();
                    break;
                case 2:
                    conexion.InsertarDatos("Un saco de huesos","Stephen king","Terror",1976,false);
                    break;
            }//final del switch





    }//final del constructor














}
