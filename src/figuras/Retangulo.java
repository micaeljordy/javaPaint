package figuras;

import java.io.Serializable;

/**
 * Classe que guarda as informações de um retângulo
 * @author Micael Jordy
 */

public class Retangulo extends Figura2D implements Serializable{

    private Double base;//base retângulo
    private Double altura;//altura retângulo

    /**
     * Método que retorna a base
     * @return base
     */
    
    public Double getBase() {
        return base;
    }
    
    /**
     * Método que retorna a altura
     * @return base
     */
    
    public Double getAltura() {
        return altura;
    }

    /**
     * Contrutor de Retangulo
     * @param cor
     * @param x
     * @param y
     * @param base
     * @param altura 
     */
    
    public Retangulo(String cor, int x, int y, double base, double altura) {
        super(cor, x, y);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        char l = ' ';
        string.append("Retângulo ");
        string.append("Cor: ");
        string.append(getCor());
        string.append(l);
        string.append("Base: ");
        string.append(base);
        string.append(l);
        string.append("Altura: ");
        string.append(altura);
        string.append(l);
        return string.toString();
    }

}
