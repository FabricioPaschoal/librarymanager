/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Fabricio Paschoal
 */
public class Gerenciamento {
    private int numLivros;
    private Livro[] livros = new Livro[1];
    
    public Gerenciamento() {
       this.numLivros = 0;
       
    }
    
    public void setarArquivo() throws IOException{
    String aux;
    String nomeArquivo = "BIBLIOTECA.txt";
    BufferedWriter out = null;
    try{
        out = new BufferedWriter(new FileWriter(nomeArquivo));
        for(Livro Livros : livros){
        aux = Livros.getTipoLivro();
        switch(aux){
            case "NORMAL1":
                out.write(Livros.getTipoLivro()+"\r\n"+Livros.getNomeLivro()+"\r\n"+Livros.getDescricaoLivro()+"\r\n"+Livros.getAutorLivro()+"\r\n");
                break;
            case "PARTICULAR2":   
                out.write(Livros.getTipoLivro()+"\r\n"+Livros.getNomeLivro()+"\r\n"+Livros.getDescricaoLivro()+"\r\n"+Livros.getAutorLivro()+"\r\n");     
                break;
            case "ESTUDO3":
                LivroEstudo livreta = new LivroEstudo();
                livreta = (LivroEstudo) Livros;
                out.write(livreta.getTipoLivro()+"\r\n"+livreta.getNomeLivro()+"\r\n"+livreta.getDescricaoLivro()+"\r\n"+livreta.getAutorLivro()+"\r\n"+livreta.getMateria()+"\r\n");
                break;
            case "PROFISSIONAL4":
                LivroProfissional livroso = new LivroProfissional();
                livroso = (LivroProfissional) Livros;
                out.write(livroso.getTipoLivro()+"\r\n"+livroso.getNomeLivro()+"\r\n"+livroso.getDescricaoLivro()+"\r\n"+livroso.getAutorLivro()+"\r\n"+livroso.getProfissao()+"\r\n"+livroso.getAreaProfissional()+"\r\n");     
                break;
             }
        }
    }catch(IOException e){
        JOptionPane.showMessageDialog(null, "Erro de gravação no arquivo ! \n"+e.getMessage());
    }
    finally {
        out.close();
    }
    }
    
    public void carregarArquivo() throws IOException{
        String aux;
        String nomeArquivo = "BIBLIOTECA.txt";
        BufferedReader inArq = null;
        String texto= "";

        try{
            FileReader arq = new FileReader(nomeArquivo);
            inArq = new BufferedReader(arq);

            String linha = inArq.readLine(); 
            while (linha != null){
                texto = texto+"\n"+linha;
                linha = inArq.readLine();
            }
            String textoFinal[] = texto.split("\n");
            int j=0, cont=0;
            String l1,l2,l3,l4,l5,l6;
            for(String txt : textoFinal){            
                cont++;
            }
            for(int i=0; i<cont;i++){
                aux = textoFinal[i];
                switch(aux){
                    case "NORMAL1":
                        l1=textoFinal[i];
                        i++;
                        l2=textoFinal[i];
                        i++;
                        l3=textoFinal[i];
                        i++;
                        l4=textoFinal[i];
                        setIncluir(l1,l2,l3,l4);
                        break;
                    case "PARTICULAR2":
                        l1=textoFinal[i];
                        i++;
                        l2=textoFinal[i];
                        i++;
                        l3=textoFinal[i];
                        i++;
                        l4=textoFinal[i];
                        setIncluir(l1,l2,l3,l4,true);
                        break;
                    case "ESTUDO3":
                        l1=textoFinal[i];
                        i++;
                        l2=textoFinal[i];
                        i++;
                        l3=textoFinal[i];
                        i++;
                        l4=textoFinal[i];
                        i++;
                        l5=textoFinal[i];
                        setIncluir(l1,l2,l3,l4,l5);
                        break;
                    case "PROFISSIONAL4":
                        l1=textoFinal[i];
                        i++;
                        l2=textoFinal[i];
                        i++;
                        l3=textoFinal[i];
                        i++;
                        l4=textoFinal[i];
                        i++;
                        l5=textoFinal[i];
                        i++;
                        l6=textoFinal[i];
                        setIncluir(l1,l2,l3,l4,l5,l6);
                        break;
                }
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo ! \n"+e.getMessage());
        }
    }
    
    protected void setIncluir(String tipo, String n, String d, String a){
        this.numLivros++;
        String aux;
        if(numLivros==1){
        livros[0]=new Livro(tipo,n,d,a);
        }else{
        Livro incluLivro = new Livro(tipo,n,d,a);

        Livro[] novosLivros = new Livro[numLivros];
        for(int i=0; i<livros.length ; i++){
            aux =  livros[i].getTipoLivro();
            switch(aux){
                case "NORMAL1":
                    novosLivros[i] = new Livro();
                    break;
                case "PARTICULAR2":
                    novosLivros[i] = new LivroParticular();
                    break;
                case "ESTUDO3":
                    novosLivros[i] = new LivroEstudo();
                    break;
                case "PROFISSIONAL4":
                    novosLivros[i] = new LivroProfissional();
                    break;

            }
            if(livros[i] != null){
                novosLivros[i] = livros[i];
            }
        }
        novosLivros[numLivros-1]= new Livro();
        novosLivros[numLivros-1]=incluLivro;
        livros = novosLivros;
        }
    }
    
    protected void setIncluir(String tipo, String n, String d, String a, boolean p){//particular
        this.numLivros++;
        String aux;
        if(numLivros==1){
        livros[0]=new LivroParticular(tipo,n,d,a,p);

        }else{
        Livro incluLivro = new LivroParticular(tipo,n,d,a,p);
        Livro[] novosLivros = new Livro[numLivros];
        for(int i=0; i<livros.length ; i++){
            aux =  livros[i].getTipoLivro();
            switch(aux){
                case "NORMAL1":
                    novosLivros[i] = new Livro();
                    break;
                case "PARTICULAR2":
                    novosLivros[i] = new LivroParticular();
                    break;
                case "ESTUDO3":
                    novosLivros[i] = new LivroEstudo();
                    break;
                case "PROFISSIONAL4":
                    novosLivros[i] = new LivroProfissional();
                    break;

            }
            if(livros[i] != null){
                novosLivros[i] = livros[i];
            }
        }
        novosLivros[numLivros-1]= new LivroParticular();
        novosLivros[numLivros-1]=incluLivro;
        livros = novosLivros;
        }
    }
    
    protected void setIncluir(String tipo, String n, String d, String a, String m){
        this.numLivros++;
        String aux;
        if(numLivros==1){
        livros[0]=new LivroEstudo(tipo,n,d,a,m);
        }else{
        Livro incluLivro = new LivroEstudo(tipo,n,d,a,m);
        Livro[] novosLivros = new Livro[numLivros];
        for(int i=0; i<livros.length ; i++){
            aux =  livros[i].getTipoLivro();
            switch(aux){
                case "NORMAL1":
                    novosLivros[i] = new Livro();
                    break;
                case "PARTICULAR2":
                    novosLivros[i] = new LivroParticular();
                    break;
                case "ESTUDO3":
                    novosLivros[i] = new LivroEstudo();
                    break;
                case "PROFISSIONAL4":
                    novosLivros[i] = new LivroProfissional();
                    break;

            }
            if(livros[i] != null){
                novosLivros[i] = livros[i];
            }
        }
        novosLivros[numLivros-1]= new LivroEstudo();
        novosLivros[numLivros-1]=incluLivro;
        livros = novosLivros;
        }
    }
        
    protected void setIncluir(String tipo, String n, String d, String a, String prof, String area){
        this.numLivros++;
        String aux;
        if(numLivros==1){
        livros[0]=new LivroProfissional(tipo,n,d,a,prof,area);
        }else{
        Livro incluLivro = new LivroProfissional(tipo,n,d,a,prof,area);
        Livro[] novosLivros = new Livro[numLivros];
        for(int i=0; i<livros.length ; i++){
            aux =  livros[i].getTipoLivro();
            switch(aux){
                case "NORMAL1":
                    novosLivros[i] = new Livro();
                    break;
                case "PARTICULAR2":
                    novosLivros[i] = new LivroParticular();
                    break;
                case "ESTUDO3":
                    novosLivros[i] = new LivroEstudo();
                    break;
                case "PROFISSIONAL4":
                    novosLivros[i] = new LivroProfissional();
                    break;

            }
            if(livros[i] != null){
                novosLivros[i] = livros[i];
            }
        }
        novosLivros[numLivros-1]= new LivroProfissional();
        novosLivros[numLivros-1]=incluLivro;
        livros = novosLivros;
        }
    }      
        
    protected void getLivros(){
        for(Livro Livros : livros){
            JOptionPane.showMessageDialog(null, Livros.toString());
        }
    }
    
    protected void excluir(int pos){
        int w=-1;
        String s;
        s=JOptionPane.showInputDialog("O livro a ser excluído será: \n"+livros[pos].toString()+"\nPressione 1 para confirmar a exclusão\nPressione 2 para cancelar");
        w=Integer.parseInt(s);
        if(w==1){
        
        numLivros--;
        int aux=0;
        String posi;
        Livro[] livrosAux;
        livrosAux = new Livro[numLivros];
        for(int j=0; j<numLivros;j++){
            posi =  livros[j].getTipoLivro();
            switch(posi){
                case "NORMAL1":
                    livrosAux[j] = new Livro();
                    break;
                case "PARTICULAR2":
                    livrosAux[j] = new LivroParticular();
                    break;
                case "ESTUDO3":
                    livrosAux[j] = new LivroEstudo();
                    break;
                case "PROFISSIONAL4":
                    livrosAux[j] = new LivroProfissional();
                    break;

            }
            livrosAux[j] = new Livro();
        }
        
        for(int j=0; j<numLivros;j++){
            if(aux!=pos){
                
                livrosAux[j] = livros[aux];
                aux++;
            
            }else{
                aux++;
                livrosAux[j] = livros[aux];
                aux++;
            }
        }
        livros = livrosAux;
        JOptionPane.showMessageDialog(null, "Livro excluído !");
        }else JOptionPane.showMessageDialog(null, "Exclusão cancelada !");
       
    }  
    
    protected void pesquisaNome(String p){
       
        String aux;
        boolean result;
        for (Livro livro : livros) {
            aux = livro.getNomeLivro();
            result = aux.toLowerCase().contains(p.toLowerCase());
            if(result == true){
                JOptionPane.showMessageDialog(null, "Livros com essa palavra:\n\n");
                JOptionPane.showMessageDialog(null, "Livro: " + livro.getNomeLivro() + "\nDescrição: " + livro.getDescricaoLivro() + "\nAutor: " + livro.getAutorLivro());
            }
        }
        
    }
    
    protected void pesquisaAutor(String p){
       
        String aux;
        boolean result;
        for (Livro livro : livros) {
            aux = livro.getAutorLivro();
            result = aux.toLowerCase().contains(p.toLowerCase());
            if(result == true){
                JOptionPane.showMessageDialog(null, "Livros com essa palavra:\n\n");
                JOptionPane.showMessageDialog(null, "Livro: " + livro.getNomeLivro() + "\nDescrição: " + livro.getDescricaoLivro() + "\nAutor: " + livro.getAutorLivro());
            }
        }
        
    }
    
    protected int retornPos(String p){
        int pos=-1;
        String aux;
        boolean result;
        for (Livro livro : livros) {
            aux = livro.getNomeLivro();
            result = aux.toLowerCase().contains(p.toLowerCase());
            pos++;
            if(result == true){
                break;
            }
        }
        return pos;
    }
}



