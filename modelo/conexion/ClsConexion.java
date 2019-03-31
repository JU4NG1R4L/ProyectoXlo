package conexion;
/**
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ClsConexion {
	protected String driver = "com.mysql.cj.jdbc.Driver";
    protected String connectString = "jdbc:mysql://localhost:3306/progavanza2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    protected String user = "root";
    protected String password = "";
    protected Connection conexionDB;
    protected Statement sentenciaSQL;
    protected ResultSet resultadoDB;

    public void conectar() {
        try {
            Class.forName(driver);
            conexionDB = DriverManager.getConnection(connectString, user, password);
            sentenciaSQL = conexionDB.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void desconectar() {
        try {
            sentenciaSQL.close();
            conexionDB.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean ejecutar(String sentencia){
        try{
            conectar();
            sentenciaSQL.executeUpdate(sentencia);
            desconectar();
        }catch(Exception e){
            return false;
        }
        return true;
    }
    public void ejecutarRetorno(String sentencia){
        try{
            conectar();
            resultadoDB=sentenciaSQL.executeQuery(sentencia);
            //desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
