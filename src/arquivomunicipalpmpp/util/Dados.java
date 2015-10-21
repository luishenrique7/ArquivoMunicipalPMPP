package arquivomunicipalpmpp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dados
{

    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/arquivo";
    private final String usuario = "root";
    private final String senha = "root";
    public Connection conn = null;

    public Connection conecta()
    {
        try
        {
            Class.forName(driver);
            try
            {
                conn = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Impossível conectar!" + ex.getMessage());
            }

        } catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Impossível localizar driver!" + ex.getMessage());
        }
        return conn;
    }

    public void desconecta()
    {
        try
        {
            conn.close();
            conn = null;
        } catch (SQLException ex)
        {
            System.out.println("Impossível desconectar!" + ex.getMessage());
        }
    }
    
}
