package arquivomunicipalpmpp.cadastro;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro")
public class Cadastro implements Serializable
{
    @Id
    @GeneratedValue
    private int id;
    private String ano;
    private String caixa;
    private String assunto;
    private String info;

    public Cadastro()
    {
    }

    public Cadastro(int id, String ano, String caixa, String assunto, String info)
    {
        this.id = id;
        this.ano = ano;
        this.caixa = caixa;
        this.assunto = assunto;
        this.info = info;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAno()
    {
        return ano;
    }

    public void setAno(String ano)
    {
        this.ano = ano;
    }

    public String getCaixa()
    {
        return caixa;
    }

    public void setCaixa(String caixa)
    {
        this.caixa = caixa;
    }

    public String getAssunto()
    {
        return assunto;
    }

    public void setAssunto(String assunto)
    {
        this.assunto = assunto;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.ano);
        hash = 29 * hash + Objects.hashCode(this.caixa);
        hash = 29 * hash + Objects.hashCode(this.assunto);
        hash = 29 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Cadastro other = (Cadastro) obj;
        if (this.id != other.id)
        {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano))
        {
            return false;
        }
        if (!Objects.equals(this.caixa, other.caixa))
        {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto))
        {
            return false;
        }
        if (!Objects.equals(this.info, other.info))
        {
            return false;
        }
        return true;
    }
    
    
}
