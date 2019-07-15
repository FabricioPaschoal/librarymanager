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
public class LivroEstudo extends Livro{
    private String materia;
    
    LivroEstudo(String tipoLivro, String nomeLivro, String descricaoLivro, String autorLivro, String mate){
        super(tipoLivro, nomeLivro, descricaoLivro, autorLivro);
        this.materia = mate;
    }
    
    LivroEstudo(){
        
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Nome Livro: "+super.getNomeLivro() + "\nDescrição: " + super.getDescricaoLivro()+ "\nAutor: " +super.getAutorLivro() + "\nMateria: " + materia ;
    }
    
}
