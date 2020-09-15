package figuras;

import java.io.Serializable;

/**
 * Classe que guarda informações de um triângulo
 * @author Micael Jordy
 */

public class Triangulo extends Figura2D implements Serializable{

    private Double base;//base do triângulo
    private Double altura;//altura do triângulo

    /**
     * Método que retorna a base
     * @return base
     */
    
    public Double getBase() {
        return base;
    }

    /**
     * Método que define a base
     * @param base
     */
    
    public void setBase(Double base) {
        this.base = base;
    }

    /**
     * Método que retorna a altura
     * @return altura
     */
    
    public Double getAltura() {
        return altura;
    }
    /**
     * Método que define a altura
     * @param altura 
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

    /**
     * Construtor de Triangulo
     * @param cor
     * @param x
     * @param y
     * @param base
     * @param altura 
     */
    
    public Triangulo(String cor, int x, int y, double base, double altura) {
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
        string.append("Triângulo ");
        string.append("Cor: ");
        string.append(getCor());
        string.append(l);
        string.append("Altura: ");
        string.append(altura);
        string.append(l);
        string.append("Base: ");
        string.append(base);
        string.append(l);
        return string.toString();
    }

}
