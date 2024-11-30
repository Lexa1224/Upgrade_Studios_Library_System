package ConexionDB;
//<>
import java.sql.*;
import java.util.Scanner;

public class ConexionDb {

    /**
     * Crearemos la conexion con usuarios clave
     * SE DEBE TRABAJAR LA OPCION DE INGRESAR OCN UN USUARIO
     *
     */

   private String url = "jdbc:postgresql://localhost:5432/UpgradeStudiosMainDB";
   private String User = "LexaDeveloper";
   private String Password = "2410";
   private String query;
   private Scanner Entrada;
   Connection conexion;
   Statement stm;
   ResultSet rst;
   PreparedStatement prst;



    //creamos el constructor
    public ConexionDb(){

    }//final del constructor


    //ESTE METODO DEBE DE TRABAJARSE


    /*public void asdLeerDatos(String query){

        //Creamos la conexion
        try {
            conexion = DriverManager.getConnection(url,User,Password);//Obtenemos la conexion

            //this.query = "SELECT * FROM \"libro\"";
            this.query = query;


            //extramos los datos de la base
            stm = conexion.createStatement();
            rst = stm.executeQuery(this.query);

            System.out.println("Codigo-------Titulo-------Autor-------Categoria-------Año-------Disponibilidad"
            );
            //bucle que leee desde la base de datos
            while (rst.next()){
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

                    //cerramos la conexion
                conexion.close();

            }//final del bucle




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }//final del metodo
*/


    //******************************************************************************************
    //trateremnos de retornar un resultset
    public ResultSet LeerDatos(String query){

        //Creamos la conexion
        try {
            conexion = DriverManager.getConnection(url,User,Password);//Obtenemos la conexion

            //this.query = "SELECT * FROM \"libro\"";
            this.query = query;


            //extraemos los datos de la base
            stm = conexion.createStatement();
            rst = stm.executeQuery(this.query);



                conexion.close();

            //}//final del bucle




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rst;
    }//final del metodo
    public void InsertarDatos(String titulo,String autor,String categoria,int anio,boolean estado){
        try {
            conexion = DriverManager.getConnection(this.url,this.User,this.Password);


            //alistamos la query
            this.query = "INSERT INTO libro (titulo, autor, categoria, año, estado) VALUES (?, ?, ?, ?, ?)";

            //prparamos la orden
            this.prst = conexion.prepareStatement(query);
            prst.setString(1,titulo);
            prst.setString(2,autor);
            prst.setString(3,categoria);
            prst.setInt(4,anio);
            prst.setBoolean(5,estado);


            //comprobando el insert
            int filas_insertadas = prst.executeUpdate();

            System.out.println("Se han insertado "+filas_insertadas+" Filas" );






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }//final del metodo
    public void EliminarDatos(){

            //creamos la conexion
        try {

            query = "DELETE FROM libro WHERE codigo = ?";//consulta
            conexion = DriverManager.getConnection(this.url,this.User,this.Password);

            int ClaveAborrar=0;
            Entrada = new Scanner(System.in);
            System.out.println("Ingrese el registro a eliminar");
            ClaveAborrar = Entrada.nextInt();//leemos la clave


            prst = conexion.prepareStatement(query);

            prst.setInt(1,ClaveAborrar);//eliminamos la clave seleccionada

            //obtenemos el dato de las filas eliminadas

            int filas_eliminadas = prst.executeUpdate();


            //validamos
            //<>
            if(filas_eliminadas >0){
                System.out.println(filas_eliminadas+" filas eliminadas");
            }//final de la condicion
            else{
                System.out.println("NO existe la clave seleccionada");
            }




            //cerramos la conexion
            conexion.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }//final del metodo





/******************************************************************/
    public PreparedStatement InsertarDatosTEST(String query){
        try {
            this.conexion = DriverManager.getConnection(this.url,this.User,this.Password);


            //alistamos la query
           // this.query = "INSERT INTO libro (titulo, autor, categoria, año, estado) VALUES (?, ?, ?, ?, ?)";

            //prparamos la orden
            this.prst = this.conexion.prepareStatement(query);
            //prst.setString(1,titulo);
            //prst.setString(2,autor);
            //prst.setString(3,categoria);
            //prst.setInt(4,anio);
            //prst.setBoolean(5,estado);


            //comprobando el insert
           // int filas_insertadas = prst.executeUpdate();

            //System.out.println("Se han insertado "+filas_insertadas+" Filas" );




        //cerramos la conexion
            //this.conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.prst;//retornamos el prepareStatement

    }//final del metodo

/****************************************************************/



}//final de la clase
