
package view;

import exceptions.ValorInvalido;
import paint.Editor;
import figuras.Elipse;
import figuras.Figura2D;
import figuras.Retangulo;
import figuras.Triangulo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe para iniciar uma janela com uma JList de figuras que podem ser apagadas ou editadas
 *
 * @author Micael Jordy
 */
public class Lista extends JFrame implements ListSelectionListener {

    private JList lista;
    private int width = 350;
    private int height = 600;
    private DefaultListModel listModel;
    private Editor editor;

    /**
     * Construtor de Lista
     *
     * @param editor
     */
    public Lista(Editor editor) {
        this.setTitle("Figuras");
        this.setSize(width, height);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocation(200, 240);

        listModel = new DefaultListModel();
        preencher(editor.getFiguras());
        this.editor = editor;

        lista = new JList(listModel);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
        this.add(lista);

    }

    /**
     *Preeche a JList com um array de figuras 
     * @param figuras
     */

    private void preencher(ArrayList<Figura2D> figuras) {
        for (int cont = 0; cont < figuras.size(); cont++) {
            listModel.add(cont, figuras.get(cont));
        }
    }

    /**
     * Limpa a JList de todos os itens adicionados
     */
    
    public void apagarTudo() {
        listModel.removeAllElements();
    }

    /**
     * Limpa a JList e a preenche novamente
     */
    
    public void atualizar() {
        apagarTudo();
        preencher(editor.getFiguras());
    }

    /**
     * Apaga uma figura da JList, do array de figuras, e da tela de desenho
     * @param index 
     */
    
    private void apagarFigura(int index) {
        editor.rmFigura(editor.getFigura(index));
        atualizar();
        editor.desenhar();
    }
    
    /**
     * Substitui uma figura da JList, do array de figuras, e da tela de desenho
     * @param f
     * @param index 
     */

    private void subFigura(Figura2D f, int index) {
        editor.subFigura(f, index);
        atualizar();
        editor.desenhar();
    }

    /**
     * Edita uma figura da JList, e aciona o método subFigura para substituí-la
     * @param index 
     */
    
    private void editarFigura(int index) {

        Figura2D figura = editor.getFigura(index);
        int x = figura.getX();
        int y = figura.getY();
        double atb1;
        double atb2;
        String cor = figura.getCor();

        if (figura instanceof Triangulo) {
            FrameDeTexto painel = new FrameDeTexto("Base", "Altura", "EDIÇÃO");
            atb1 = painel.getCampo1();
            atb2 = painel.getCampo2();

            try {
                if (atb1 < 0 || atb2 < 0) {
                    throw new ValorInvalido();
                } else {
                    if (painel.getCor() != null) {
                        cor = painel.getCor();
                    }
                    Triangulo t = new Triangulo(cor, x, y, atb1, atb2);
                    subFigura(t, index);
                }
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        } else if (figura instanceof Retangulo) {
            FrameDeTexto painel = new FrameDeTexto("Base", "Altura", "EDIÇÃO");
            atb1 = painel.getCampo1();
            atb2 = painel.getCampo2();
            try {
                if (atb1 < 0 || atb2 < 0) {
                    throw new ValorInvalido();
                } else {
                    if (painel.getCor() != null) {
                        cor = painel.getCor();
                    }
                    Retangulo r = new Retangulo(cor, x, y, painel.getCampo1(), painel.getCampo2());
                    subFigura(r, index);
                }
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        } else if (figura instanceof Elipse) {
            FrameDeTexto painel = new FrameDeTexto("Raio Horizontal", "Raio Vertical", "EDIÇÃO");
            atb1 = painel.getCampo1();
            atb2 = painel.getCampo2();
            try {
                if (atb1 < 0 || atb2 < 0) {
                    throw new ValorInvalido();
                } else {
                    if (painel.getCor() != null) {
                        cor = painel.getCor();
                    }
                    Elipse e = new Elipse(cor, x, y, painel.getCampo1(), painel.getCampo2());
                    subFigura(e, index);
                }
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = lista.getSelectedIndex();
        int modo;

        System.out.println(index);

        if (index >= 0) {

            int figureIndex = index;

            System.out.println(index + " " + figureIndex);

            modo = JOptionPane.showConfirmDialog(null, "Deseja \"Apagar\" a figura?", "EDIÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);

            if (modo == 0) {
                apagarFigura(figureIndex);
            } else if (modo != 2) {
                modo = JOptionPane.showConfirmDialog(null, "Deseja \"Editar\" a figura?", "EDIÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);
                if (modo == 0) {
                    editarFigura(figureIndex);
                }
            }
        }
    }
}
