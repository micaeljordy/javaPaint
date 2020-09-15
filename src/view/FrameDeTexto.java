package view;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe que captura as informações das figuras através de interação com o usuário
 * @author Micael Jordy
 */
public class FrameDeTexto {

    private JTextField campo1;
    private JTextField campo2;
    private String pri;
    private String seg;
    private String cor;
    private int acao;
    private JList<String> cores;
    private String[] colorName = {"Preto", "Azul", "Ciano", "Cinza Escuro",
        "Cinza", "Verde", "Cinza Claro", "Magenta", "Laranja", "Rosa",
        "Vermelho", "Branco", "Amarelo"};//Lista de strings para montar o Object "campos"

    /**
     * Método que define a string pri
     * @param pri 
     */
    
    public void setPri(String pri) {
        this.pri = pri;
    }

    /**
     * Método que define a string seg
     * @param seg
     */
    
    public void setSeg(String seg) {
        this.seg = seg;
    }

    /**
     * Construtor de FrameDeTexto
     * @param pri
     * @param seg
     * @param nome_da_forma 
     */
    
    public FrameDeTexto(String pri, String seg, String nome_da_forma) {

        campo1 = new JTextField("Valor");
        campo2 = new JTextField("Valor");
        cores = new JList(colorName);
        cores.setName("Seleção de Cor");
        cores.setVisibleRowCount(5);
        cores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cores.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                cor = cores.getSelectedValue();
            }
        });

        setPri(pri);
        setSeg(seg);

        Object[] campos = {
            "Cor: ", cores,
            pri + ": ", campo1,
            seg + ": ", campo2,};

        acao = JOptionPane.showConfirmDialog(null, campos, nome_da_forma, JOptionPane.OK_CANCEL_OPTION);
        System.out.println(acao);
    }

    /**
     * Método que retorna Double através do casting da string capturada pelo JTextField
     * @return num ou algum valor negativo
     */
    
    public Double getCampo1() {

        Double num = 100d;
        String tst = campo1.getText();

        if ("Valor".equals(tst)) {
            if (acao == 0) {
                return num;
            }
        } else {

            try {
                num = new Double(tst);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Atributo não é um número!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                return -1d;
            }

            return num;
        }

        return -99999d;
    }

    /**
     * Método que retorna Double através do casting da string capturada pelo JTextField
     * @return num ou algum valor negativo
     */
    
    public Double getCampo2() {

        Double num = 100d;
        String tst = campo2.getText();

        if ("Valor".equals(tst)) {
            if (acao == 0) {
                return num;
            }
        } else {

            try {
                num = new Double(tst);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Atributo não é um número!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                return -1d;
            }

            return num;
        }
        
        return -99999d;
    }

    /**
     * Método que retorna uma string com a cor capturada pela JList
     * @return 
     */
    
    public String getCor() {
        return cor;
    }

}
