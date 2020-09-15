
package view;

import figuras.Figura2D;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Classe que abre uma JPanel que irá representar os desenhos graficamente
 * @author Micael Jordy
 */
public class Janela extends JFrame{
    private Tela tela;//tela de desenho
    private ArrayList<Figura2D> lista;//lista com desenhos da tela
    
    /**
     * Contrutor de Janela
     */
    
    public Janela(){
        tela = new Tela();
        this.add(tela);
    }
    
    /**
     * Método que desenha as figuras na JPanel "tela"
     * @param figuras 
     */
    
    public void desenhar(ArrayList<Figura2D> figuras){
        tela.desenhar(figuras);
        tela.repaint();
    }
    
    /**
     * Método para retornar a coordenada X do JPanel "tela"
     * @return coordenada X da tela
     */
    
    public int getCooX(){
        return tela.getCooX();
    }
    
    /**
     * Método para retornar a coordenada Y do JPanel "tela"
     * @return coordenada Y da tela
     */
    
    public int getCooY(){
        return tela.getCooY();
    }
    
    /**
     * Método para retornar o número de cliques com mouse do JPanel "tela"
     * @return número de cliques
     */
    
    public int getCliques(){
        return tela.getCliques();
    }
}
