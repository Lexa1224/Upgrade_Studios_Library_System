package entidades;
//<>
import ConexionDB.ConexionDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Libros {

    private String titulo;
    private String Autor;
    private String Categoria;
    private int anio;
    private boolean disponibilidad;
    private int dispo;
    private  ConexionDb pruebaConexion;
    private ResultSet rst;
    Scanner entradas = new Scanner(System.in);
    String query ;
    //  this.query = "INSERT INTO libro (titulo, autor, categoria, año, estado) VALUES (?, ?, ?, ?, ?)";


    //cuando este metodo sea llamado se cargaran todos los valores para insertar los datos



    public void LecturaDeDatos(){
        //Ingresando la informacion del libro
        System.out.println("Ingrese el autor del libro");
        this.titulo = this.entradas.nextLine();//leemos el titulo del libro
        System.out.println("Ingrese el autor del libro");
        this.Autor = this.entradas.nextLine();
        System.out.println("Ingrese la categoria del libro");
        this.Categoria = this.entradas.nextLine();
        System.out.println("Ingrese el año de publicacion");
        this.anio = this.entradas.nextInt();//el año de publicacion


        /*A futuro debe de modificarse esta opcion por la operacion de prestamo
        * */
        System.out.println("Ingrese si esta disponible \n 1)Disponible 2)Agotado");
        this.dispo = this.entradas.nextInt();
        //validamos
        //<>
        while(this.dispo<0 && this.dispo>2 ){
            System.out.println("Entrada no valida");
            System.out.println("Ingrese si esta disponible \n 1)Disponible 2)Agotado");
            this.dispo = this.entradas.nextInt();


        }//termina la validacion del dato

        //Damos el valor a la disponibilidad
        if(this.dispo ==1){
            this.disponibilidad=true;
        }//final de la condicion
        else {
            this.disponibilidad = false;
        }


        //mensaje de prueba
        System.out.println("Los siguientes datos se escribiran");
        System.out.println(
                this.titulo+" "+this.Autor+" "+this.Categoria+" "+this.anio+" "+this.disponibilidad
        );

        //gestion con la conexion






    }


    //llamamos a la clase de conexion donde seleccionamos la base de datos



    public void leerDatosDeLaDB(){

        this.pruebaConexion = new ConexionDb();//llamamos a la clase conexion
        this.rst = pruebaConexion.TESTLeerDatos("SELECT * FROM \"libro\"");//pasamos la query al metodo

        //comprobamos la lectura
        System.out.println("Codigo-------Titulo-------Autor-------Categoria-------Año-------Disponibilidad");
        while(true){
            try {
                if (!this.rst.next()) break;
                String codigo,titulo,autor,categoria,anio;
                Boolean estado;

                codigo = rst.getString(1);
                titulo = rst.getString(2);
                autor = rst.getString(3);
                categoria = rst.getString(4);
                anio = rst.getString(5);
                estado = rst.getBoolean(6);




                System.out.println(
                        " "+codigo+" "+titulo+" "+autor+" "+categoria+" "+anio+" "+estado

                );

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }//final del bucle

        System.out.println("Desde la entidad libro");


    }//final del metodo









}//final de la clase
