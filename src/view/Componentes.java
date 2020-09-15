package view;

import paint.Editor;
import figuras.Elipse;
import figuras.Figura2D;
import figuras.Retangulo;
import figuras.Triangulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

/**
 * Classe que inicia todos os componentes gráficos desta aplicação
 *
 * @author Micael Jordy
 */
public class Componentes extends JFrame implements ActionListener {

    private JButton elipse;//botão elipse
    private JButton retangulo;//botão retângulo
    private JButton triangulo;//botão triângulo
    private JButton limparTela;//botão limpar tela
    private JButton atualizar;//botão atualizar tela
    private JButton salvar;//botão salvar
    private JButton carregar;//botao carregar
    private JButton sair;//botao sair
    private JToolBar caixa;
    private JSeparator s1;
    private JSeparator s2;
    private JSeparator s3;
    private JSeparator s4;
    private JSeparator s5;
    private JSeparator s6;
    private JSeparator s7;
    private final int width = 650;
    private final int height = 30;
    private Transparencia t;
    private Lista lista;//inicia Lista
    private ArrayList<Figura2D> figuras;
    private Janela janela;//inicia janela de desenho
    private int cliques;//captura o número de cliques do mouse na interface gráfica janela
    private Editor editor;

    /**
     * Contrutor de Componentes
     */
    
    public Componentes() {
        this.setSize(width, height);
        elipse = new JButton("Elipse");
        retangulo = new JButton("Retângulo");
        triangulo = new JButton("Triângulo");
        limparTela = new JButton("Limpar tela");
        atualizar = new JButton("Atualizar tela");
        salvar = new JButton("Salvar figuras");
        carregar = new JButton("Carregar figuras");
        sair = new JButton("Sair");

        s1 = new JSeparator();
        s2 = new JSeparator();
        s3 = new JSeparator();
        s4 = new JSeparator();
        s5 = new JSeparator();
        s6 = new JSeparator();
        s7 = new JSeparator();

        caixa = new JToolBar("Ferramentas");
        caixa.setSize(width, height);
        caixa.add(elipse);
        caixa.add(s1);
        caixa.add(retangulo);
        caixa.add(s2);
        caixa.add(triangulo);
        caixa.add(s3);
        caixa.add(atualizar);
        caixa.add(s4);
        caixa.add(limparTela);
        caixa.add(s5);
        caixa.add(salvar);
        caixa.add(s6);
        caixa.add(carregar);
        caixa.add(s7);
        caixa.add(sair);

        this.add(caixa);
        this.setLocation(650, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        t = new Transparencia();
        t.aplicarTransparencia(this);

        atualizar.addActionListener(this);
        elipse.addActionListener(this);
        retangulo.addActionListener(this);
        triangulo.addActionListener(this);
        limparTela.addActionListener(this);
        salvar.addActionListener(this);
        carregar.addActionListener(this);
        sair.addActionListener(this);

        janela = new Janela();
        janela.setTitle("3P + Pintar");
        janela.setSize(800, 600);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        cliques = janela.getCliques();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);

        figuras = new ArrayList();
        editor = new Editor(figuras, janela);

        lista = new Lista(editor);
        lista.setVisible(rootPaneCheckingEnabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

        String cor = "Preto";
        int numeroDeCliques = janela.getCliques();
        int x = janela.getCooX();
        int y = janela.getCooY();
        double atb1;
        double atb2;
        if (obj == sair) {
            System.exit(0);
        } else if (obj == salvar) {
            editor.salvarFiguras();
        } else if (obj == carregar) {
            editor.carregarFiguras();
            lista.atualizar();
            janela.desenhar(editor.getFiguras());
        } else if (obj == atualizar) {
            janela.desenhar(editor.getFiguras());
        } else if (obj == limparTela) {
            figuras = new ArrayList();
            editor.setFiguras(figuras);
            janela.desenhar(editor.getFiguras());
            lista.apagarTudo();
        } else if (this.cliques < numeroDeCliques) {
            if (obj == elipse) {
                Elipse forma;
                FrameDeTexto painel = new FrameDeTexto("Raio Horizontal", "Raio Vertical", "Elipse");

                if (painel.getCor() != null) {
                    cor = painel.getCor();
                }

                atb1 = painel.getCampo1();

                atb2 = painel.getCampo2();

                if ((atb1 >= 0) && (atb2 >= 0)) {
                    forma = new Elipse(cor, x, y, atb1, atb2);
                    editor.addFigura(forma);
                    lista.atualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);

                }

            } else if (obj == triangulo) {

                Triangulo forma;
                FrameDeTexto painel = new FrameDeTexto("Base", "Altura", "Triângulo");

                if (painel.getCor() != null) {
                    cor = painel.getCor();
                }

                atb1 = painel.getCampo1();

                atb2 = painel.getCampo2();

                if ((atb1 >= 0) && (atb2 >= 0)) {

                    forma = new Triangulo(cor, x, y, atb1, atb2);
                    editor.addFigura(forma);
                    lista.atualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);

                }

            } else if (obj == retangulo) {

                Retangulo forma;
                FrameDeTexto painel = new FrameDeTexto("Base", "Altura", "Retângulo");

                if (painel.getCor() != null) {
                    cor = painel.getCor();
                }

                atb1 = painel.getCampo1();

                atb2 = painel.getCampo2();
                if ((atb1 >= 0) && (atb2 >= 0)) {
                    forma = new Retangulo(cor, x, y, atb1, atb2);
                    editor.addFigura(forma);
                    lista.atualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Atributo(s) inválido(s)", "ERRO!", JOptionPane.ERROR_MESSAGE);

                }
            }

            janela.desenhar(editor.getFiguras());
            this.cliques = janela.getCliques();
        } else {
            JOptionPane.showMessageDialog(null, "Primeiramente clique na posição da figura!", "Aviso!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
