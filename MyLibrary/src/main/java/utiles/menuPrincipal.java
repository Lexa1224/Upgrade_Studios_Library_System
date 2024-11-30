package utiles;

import ConexionDB.ConexionDb;
import entidades.Libros;
//<>
import java.text.CompactNumberFormat;
import java.util.Scanner;

public class menuPrincipal {

    private int seleccion;
    private Scanner entradaOpcion ;
    private ConexionDb conexion;


    //constructor
    public menuPrincipal(){

        System.out.println("Bienvenido que desea hacer" +
                "\n 1)Consultar registro 2)Insertar Registro 3)Eliminar Datos 0)Salir 4)testear metodo");
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
                    //conexion.LeerDatos("SELECT * FROM \"libro\"");
                    Libros l = new Libros();
                    l.leerDatosDeLaDB();
                    break;
                case 2:

                    //en la llamada de este metodo se debe ingresar por consola los datos
                    conexion.InsertarDatos("Borrar","Borrar","Borrar",0,false);
                    break;
                case 3:
                    conexion.EliminarDatos();
                    break;
                case 4://TEST
                    System.out.println("Testeando");
                    Libros test = new Libros();
                    test.LecturaDeDatos();
                    break;
            }//final del switch





    }//final del constructor














}
