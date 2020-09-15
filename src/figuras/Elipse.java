package figuras;

import java.io.Serializable;


/**
 * Classe que guarda informações de uma elipse
 * @author Micael Jordy
 */
public class Elipse extends Figura2D implements Serializable{

    Double raioV;//raio vertical
    Double raioH;//raio horizontal

    /**
     * Método que retorna o raio vertical
     * @return raioV
     */
    
    public Double getRaioV() {
        return raioV;
    }
    
    /**
     * Método que retorna o raio horizontal
     * @return raioH
     */
    
    public Double getRaioH() {
        return raioH;
    }
    
    /**
     * Construtor de Elipse
     * @param cor
     * @param x
     * @param y
     * @param raioH
     * @param raioV
     */
    
    public Elipse(String cor, int x, int y, double raioH, double raioV) {
        super(cor, x, y);
        this.raioV = raioV;
        this.raioH = raioH;
    }

    @Override
    public double area() {
        return Math.PI * raioV * raioH;
    }
    
     @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        char l = ' ';
        string.append("Elipse ");
        string.append("Cor: ");
        string.append(getCor());
        string.append(l);
        string.append("Raio Vertical: ");
        string.append(raioV);
        string.append(l);
        string.append("Raio Horizontal: ");
        string.append(raioH);
        string.append(l);
        return string.toString();
    }
    
}
