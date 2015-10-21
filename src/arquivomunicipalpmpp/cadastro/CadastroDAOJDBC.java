package arquivomunicipalpmpp.cadastro;

import arquivomunicipalpmpp.util.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroDAOJDBC implements CadastroDAO
{

    Dados bd = new Dados();

    String sqlSalvar = "INSERT INTO CADASTRO (ANO, CAIXA, ASSUNTO, INFO) VALUES (?,?,?,?)";
    String sqlAtualizar = "UPDATE CADASTRO SET ANO = ?, CAIXA = ?, ASSUNTO = ?, INFO = ? WHERE ID = ?";
    String sqlExcluir = "DELETE FROM CADASTRO WHERE ID = ?";
    String sqlPesquisarAno = "SELECT * FROM CADASTRO WHERE ANO LIKE ? ";
    String sqlPesquisarAssunto = "SELECT * FROM CADASTRO WHERE ASSUNTO LIKE ? ";
    String sqlPesquisarCaixa = "SELECT * FROM CADASTRO WHERE CAIXA LIKE ? ";

    @Override
    public void salvar(Cadastro cad)
    {
        bd.conecta();
        PreparedStatement ps;
        try
        {
            ps = bd.conn.prepareStatement(sqlSalvar);
            ps.setString(1, cad.getAno());
            ps.setString(2, cad.getCaixa());
            ps.setString(3, cad.getAssunto());
            ps.setString(4, cad.getInfo());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastro inserido com sucesso!");

        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERRO:" + ex.getMessage());
        } finally
        {
            bd.desconecta();
        }
    }

    @Override
    public void atualizar(Cadastro cad)
    {
        bd.conecta();
        PreparedStatement ps;
        try
        {
            ps = bd.conn.prepareStatement(sqlSalvar);
            ps.setString(1, cad.getAno());
            ps.setString(2, cad.getCaixa());
            ps.setString(3, cad.getAssunto());
            ps.setString(4, cad.getInfo());
            ps.setInt(5, cad.getId());

            ps.execute();

        } catch (SQLException ex)
        {
            ex.getMessage();
        } finally
        {
            bd.desconecta();
        }
    }

    @Override
    public void excluir(Cadastro cad)
    {
        bd.conecta();
        PreparedStatement ps;
        try
        {
            ps = bd.conn.prepareStatement(sqlSalvar);
            ps.setInt(1, cad.getId());

            ps.execute();

        } catch (SQLException ex)
        {
            ex.getMessage();
        } finally
        {
            bd.desconecta();
        }
    }

//    @Override
//    public List<Cadastro> buscarPorAno(String ano)
//    {
//        bd.conecta();
//        List<Cadastro> lista = new ArrayList<>();
//
//        try
//        {
//            PreparedStatement ps = bd.conn.prepareStatement(sqlPesquisarAno);
//            ps.setString(1, ano);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next())
//            {
//                Cadastro cad = new Cadastro();
//                cad.getId();
//                cad.getAno();
//                cad.getCaixa();
//                cad.getAssunto();
//                cad.getInfo();
//                lista.add(cad);
//            }
//            
//        } catch (SQLException ex)
//        {
//            ex.getMessage();
//        } finally
//        {
//            bd.desconecta();
//        }
//        return lista;
//    }

    @Override
    public List<Cadastro> listar()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
