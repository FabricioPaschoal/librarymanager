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
public class Livro {
    private String nomeLivro;
    private String descricaoLivro;
    private String autorLivro;
    private String tipoLivro;

    public Livro(String tipoLivro, String nomeLivro, String descricaoLivro, String autorLivro) {
        this.tipoLivro = tipoLivro;
        this.nomeLivro = nomeLivro;
        this.descricaoLivro = descricaoLivro;
        this.autorLivro = autorLivro;
    }

    public Livro() {
        
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getDescricaoLivro() {
        return descricaoLivro;
    }

    public void setDescricaoLivro(String descricaoLivro) {
        this.descricaoLivro = descricaoLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }   

    public String getTipoLivro() {
        return tipoLivro;
    }

    public void setTipoLivro(String tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    @Override
    public String toString() {
        return "Nome Livro: " + nomeLivro + "\nDescrição: " + descricaoLivro + "\nAutor: " + autorLivro ;
    }
    
}
