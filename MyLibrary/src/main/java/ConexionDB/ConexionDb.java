package ConexionDB;

import java.sql.*;

public class ConexionDb {

    /**
     * Crearemos la conexion con usuarios clave
     *
     */

   private String url = "jdbc:postgresql://localhost:5432/UpgradeStudiosMainDB";
   private String User = "LexaDeveloper";
   private String Password = "2410";
   private String query;
   Connection conexion;
   Statement stm;
   ResultSet rst;
   PreparedStatement prst;



    //creamos el constructor
    public ConexionDb(){

    }//final del constructor

    public void LecturaBD(){

        //Creamos la conexion
        try {
            conexion = DriverManager.getConnection(url,User,Password);//Obtenemos la conexion

            String query = "SELECT * FROM \"libro\"";



            //extramos los datos de la base
            stm = conexion.createStatement();
            rst = stm.executeQuery(query);


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




}//final de la clase
