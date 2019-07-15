/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

/**
 *
 * @author Fabricio Paschoal
 */
public class LivroProfissional extends Livro{
    private String profissao;
    private String areaProfissional;
    
    LivroProfissional(String tipoLivro, String nomeLivro, String descricaoLivro, String autorLivro,String prof, String areaProf){
        super(tipoLivro, nomeLivro, descricaoLivro, autorLivro);
        this.profissao = prof;
        this.areaProfissional = areaProf;
    }
    
    LivroProfissional(){
        
    }
    
    public String getAreaProfissional() {
        return areaProfissional;
    }

    public void setAreaProfissional(String areaProfissional) {
        this.areaProfissional = areaProfissional;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        
        return  "Nome Livro: "+super.getNomeLivro() + "\nDescrição: " + super.getDescricaoLivro()+ "\nAutor: " +super.getAutorLivro() + "\nProfissão: " + profissao + "\nArea Profissional: " + areaProfissional ;
    }

    
    
}
