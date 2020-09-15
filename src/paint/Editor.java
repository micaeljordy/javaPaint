package paint;

import figuras.Figura2D;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Janela;

/**
 * Classe com opções para manipular um array de figuras
 * @author Micael Jordy
 */

public class Editor {

    private ArrayList<Figura2D> figuras;//array de figuras
    private Janela janela;//Ponteiro para classe Janela
    
    /**
     * Método para desenhar as figuras na janela
     */
    
    public void desenhar(){
        janela.desenhar(figuras);
    }
    
    /**
     * Método para definir o array de figuras
     * @param figuras 
     */

    public void setFiguras(ArrayList<Figura2D> figuras) {
        this.figuras = figuras;
    }

    /**
     * Método para retornar o array de figuras
     * @return figuras
     */
    
    public ArrayList<Figura2D> getFiguras() {
        return figuras;
    }
    
    /**
     * Construtor de Editor
     * @param figuras
     * @param janela 
     */

    public Editor(ArrayList<Figura2D> figuras, Janela janela) {
        this.figuras = figuras;
        this.janela = janela;
    }

    /**
     * Método para adicionar uma figura do array
     * @param f 
     */
    
    public void addFigura(Figura2D f) {
        figuras.add(f);
    }

    /**
     * Método para remover uma figura do array
     * @param f 
     */
    
    public void rmFigura(Figura2D f) {
        if (figuras.contains(f)) {
            figuras.remove(f);
        }
    }
    
    /**
     * Método para substituir uma figura do array
     * @param f
     * @param index 
     */
    
    public void subFigura(Figura2D f, int index){
        figuras.set(index, f);
    }

    /**
     * Método para retornar uma figura do array
     * @param index
     * @return figuras.get(index)
     */
    
    public Figura2D getFigura(int index) {
        return figuras.get(index);
    }

    /**
     * Método para salvar o array de figuras em um arquivo
     */
    
    public void salvarFiguras() {
        try{
            FileOutputStream arq = new FileOutputStream("figuras.objectArq");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            obj.writeObject(figuras);
            obj.flush();
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!");
        }catch(IOException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a gravação!");
        }
    }

    /**
     * Método para carregar um arquivo que contém um array de figuras
     */
    
    public void carregarFiguras() {
        try{
            FileInputStream arq = new FileInputStream("figuras.objectArq");
            ObjectInputStream obj = new ObjectInputStream(arq);
            ArrayList<Figura2D> lista2 = (ArrayList<Figura2D>)obj.readObject();
            figuras.addAll(lista2);
            JOptionPane.showMessageDialog(null, "Figuras carregadas!");
        }catch(IOException | ClassNotFoundException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante o carregamento!");
        }
    }

    /**
     * Método para imprimir os objetos do array de figuras
     */
    
    public void imprimirFiguras() {
        for (Figura2D figura : figuras) {
            System.out.println(figura);
        }
    }

}
