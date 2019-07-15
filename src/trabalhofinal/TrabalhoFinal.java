/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio Paschoal
 */
public class TrabalhoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception{
        Gerenciamento biblioteca = new Gerenciamento();
        String n, d, a, prof, area, mate;
        boolean p = true;
        String tipo;
        String pesq;
        int aux=0, resp=0;
        String s;
        int e;
        
        biblioteca.carregarArquivo();
        
        while(resp <= 5){
            try{
                s = JOptionPane.showInputDialog("Insira uma das opções\n\n" + "MENU"+"\n1 - Incluir Livro" + "\n2 - Pesquisar por titulo" + "\n3 - Pesquisar por autor" + "\n4 - Excluir Livros" + "\n5 - Listar Livros"+"\n6 - SAIR");
                resp = Integer.parseInt(s);
            
                    switch(resp){
                        case 1:{
                            s = JOptionPane.showInputDialog("\n1 - Incluir Livro comum " + "\n2 - Incluir Livro Particular " + "\n3 - Incluir Livro de Estudos " + "\n4 - Incluir Livro de Profissões ");
                            aux = Integer.parseInt(s);
                            switch(aux){
                                case 1:
                                    tipo = "NORMAL1";
                                    n= JOptionPane.showInputDialog("Insira o nome do Livro !");
                                    d= JOptionPane.showInputDialog("Insira a descrição do Livro !");
                                    a= JOptionPane.showInputDialog("Insira o autor do Livro !");
                                    biblioteca.setIncluir(tipo,n, d, a);
                                    break;
                                case 2:
                                    tipo = "PARTICULAR2";
                                    n= JOptionPane.showInputDialog("Insira o nome do Livro !");
                                    d= JOptionPane.showInputDialog("Insira a descrição do Livro !");
                                    a= JOptionPane.showInputDialog("Insira o autor do Livro !"); 
                                    biblioteca.setIncluir(tipo,n, d, a, p);
                                    break;
                                case 3:
                                    tipo = "ESTUDO3";
                                    n= JOptionPane.showInputDialog("Insira o nome do Livro !");
                                    d= JOptionPane.showInputDialog("Insira a descrição do Livro !");
                                    a= JOptionPane.showInputDialog("Insira o autor do Livro !");
                                    mate= JOptionPane.showInputDialog("Insira a matéria do Livro !");
                                    biblioteca.setIncluir(tipo,n, d, a, mate);
                                    break;
                                case 4:
                                    tipo = "PROFISSIONAL4";
                                    n= JOptionPane.showInputDialog("Insira o nome do Livro !");
                                    d= JOptionPane.showInputDialog("Insira a descrição do Livro !");
                                    a= JOptionPane.showInputDialog("Insira o autor do Livro !");
                                    prof = JOptionPane.showInputDialog("Insira a profissão que o Livro se encaixa !");
                                    area = JOptionPane.showInputDialog("Insira a area da profissão que o Livro se encaixa !");
                                    biblioteca.setIncluir(tipo,n, d, a, prof, area);
                                    break;
                                
                            }
                            JOptionPane.showMessageDialog(null, "Livro incluido com sucesso");

                            break;
                        }
                        case 2:{
                            pesq = JOptionPane.showInputDialog("Insira o titulo a ser pesquisado !");
                            biblioteca.pesquisaNome(pesq);
                            break;
                        }
                        case 3:{
                            pesq = JOptionPane.showInputDialog("Insira o Autor a ser pesquisado !");
                            biblioteca.pesquisaAutor(pesq);
                            break;
                        }
                        case 4:{
                            pesq = JOptionPane.showInputDialog("Digite detalhadamente o nome do livro que deseja excluir ");
                            e= biblioteca.retornPos(pesq);
                            biblioteca.excluir(e);
                            break;
                        }
                        case 5:{
                            JOptionPane.showMessageDialog(null, "Livros da Lista:\n");
                            biblioteca.getLivros();
                            break;
                        }
                        default:{
                            if(resp == 6){
                                break;
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Opção inválida !\n");
                                resp=0;
                            }   
                        }
                    }   
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Inseriu uma  opção inválida !! \n"+ex.getMessage());
                }
            }
        biblioteca.setarArquivo();
    }  
}

