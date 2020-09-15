
package figuras;

import java.io.Serializable;

/**
 * Classe abstrata para implementar outras classes do pacote figuras
 */
public abstract class Figura2D implements Serializable {

    /**
     * Cor da figura
     */
    private String cor;
    /**
     *Posição x da figura
     */
    protected int x;
    /**
     * Posição y da figura
     */
    protected int y;

    public abstract double area();

    /**
     * Construtor da classe Figura2D
     *
     * @param cor
     * @param x
     * @param y
     */
    public Figura2D(String cor, int x, int y) {
        this.cor = cor;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

}
