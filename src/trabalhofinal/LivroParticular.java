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
public class LivroParticular extends Livro{
    private boolean particular;
    
    LivroParticular(String tipoLivro, String nomeLivro, String descricaoLivro, String autorLivro, boolean part){
        super(tipoLivro, nomeLivro, descricaoLivro, autorLivro);
        this.particular = part;
    }
    
    LivroParticular(){
        
    }
    
    public boolean isParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
    }

    @Override
    public String toString() {
        return   "Nome Livro: "+super.getNomeLivro() + "\nDescrição: " + super.getDescricaoLivro()+ "\nAutor: " +super.getAutorLivro();
    }
    
    
}
