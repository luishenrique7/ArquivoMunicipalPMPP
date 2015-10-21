package arquivomunicipalpmpp.cadastro;

import java.util.List;

public interface CadastroDAO
{
    public void salvar(Cadastro cad);
    
    public void atualizar(Cadastro cad);
    
    public void excluir(Cadastro cad);
    
    public List<Cadastro> listar();
    
//    public List<Cadastro> buscarPorAno(String info);
    
}
