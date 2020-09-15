
package view;

import figuras.Triangulo;
import figuras.Elipse;
import figuras.Retangulo;
import figuras.Figura2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Tela que apresenta os desenhos graficamente
 * @author Micael Jordy
 */
public class Tela extends javax.swing.JPanel {

    private Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();//pega a dimensão da tela do computador
    private BufferedImage bufferImagem = new BufferedImage((int) dimensao.getWidth(),
            (int) dimensao.getHeight(), BufferedImage.TYPE_INT_RGB);//cria a BufferedImage do fundo da tela
    private BufferedImage bufferReta = new BufferedImage((int) dimensao.getWidth(),
            (int) dimensao.getHeight(), BufferedImage.TYPE_INT_RGB);//cria a BufferedImage que trabalhrá com as figuras
    private int cooX;//coordenada X do mouse
    private int cooY;//coordenada Y do mouse
    private int cliques;

    /**
     * Retorna a coordenada X do mouse
     * @return cooX
     */
    
    public int getCooX() {

        return cooX;
    }

    /**
     * Retorna a coordenada Y do mouse
     * @return cooY
     */
    
    public int getCooY() {
        return cooY;
    }

    /**
     * Retorna o número de vezes que o JPanel foi clicado
     * @return número de cliques
     */
    
    public int getCliques() {
        return cliques;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bufferImagem.getWidth(), bufferImagem.getHeight());
        g.drawImage(bufferReta, 0, 0, this);
        g.dispose();
    }

    /**
     * Construtor de Tela
     */
    
    public Tela() {
        Graphics fundo = bufferImagem.createGraphics();
        fundo.setColor(Color.WHITE);
        fundo.fillRect(0, 0, bufferImagem.getWidth(), bufferImagem.getHeight());
        fundo.dispose();
        Graphics reta = bufferReta.createGraphics();
        reta.setColor(Color.WHITE);
        reta.fillRect(0, 0, bufferReta.getWidth(), bufferReta.getHeight());
        reta.dispose();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cooX = e.getX();
                cooY = e.getY();
                cliques++;
            }
        });

    }

    /**
     * Método que desenha as figuras no JPanel
     * @param figuras 
     */
    
    public void desenhar(List<Figura2D> figuras) {
        Graphics2D Gforma = bufferReta.createGraphics();
        Gforma.drawImage(bufferImagem, 0, 0, this);

        for (Figura2D figura : figuras) {
            if (figura instanceof Retangulo) {
                int base = (((Retangulo) figura).getBase()).intValue();
                int altura = (((Retangulo) figura).getAltura()).intValue();
                int x = figura.getX();
                int y = figura.getY();

                Gforma.setColor(getCor(figura.getCor()));

                if (base == 0 || altura == 0) {
                    Gforma.drawLine(x, y, x + base, y + altura);
                } else {
                    Gforma.fillRect(figura.getX(), figura.getY(), base, altura);
                }
            }

            if (figura instanceof Elipse) {
                int raioV = (((Elipse) figura).getRaioV()).intValue();
                int raioH = (((Elipse) figura).getRaioH()).intValue();
                int x = figura.getX();
                int y = figura.getY();

                Gforma.setColor(getCor(figura.getCor()));

                if (raioV == 0 || raioH == 0) {
                    Gforma.drawLine(x, y, x + raioH, y + raioV);
                } else {

                    Gforma.fillOval(figura.getX(), figura.getY(), raioH, raioV);
                }
            }

            if (figura instanceof Triangulo) {

                int x = figura.getX();
                int y = figura.getY();
                int base = ((Triangulo) figura).getBase().intValue();
                int altura = ((Triangulo) figura).getAltura().intValue();
                Gforma.setColor(getCor(figura.getCor()));

                if (base == 0 || altura == 0) {
                    Gforma.drawLine(x, y, x + base, y + altura);
                } else {
                    int px[] = new int[3];
                    int py[] = new int[3];

                    px[0] = x;
                    py[0] = y;

                    px[1] = x + base / 2;
                    py[1] = Math.abs(y - altura);

                    px[2] = x + base;
                    py[2] = y;

                    Gforma.fillPolygon(px, py, 3);
                }
            }

        }

        Gforma.dispose();
    }

    /**
     * Método que retorna uma cor em Color
     * @param nome
     * @return uma cor em Color
     */
    
    private Color getCor(String nome) {
        Color cor = Color.BLACK;

        if ("Azul".equals(nome)) {
            cor = Color.BLUE;
        }
        if ("Ciano".equals(nome)) {
            cor = Color.CYAN;
        }
        if ("Cinza Escuro".equals(nome)) {
            cor = Color.DARK_GRAY;
        }
        if ("Cinza".equals(nome)) {
            cor = Color.GRAY;
        }
        if ("Verde".equals(nome)) {
            cor = Color.GREEN;
        }
        if ("Cinza Claro".equals(nome)) {
            cor = Color.LIGHT_GRAY;
        }
        if ("Magenta".equals(nome)) {
            cor = Color.MAGENTA;
        }
        if ("Laranja".equals(nome)) {
            cor = Color.ORANGE;
        }
        if ("Rosa".equals(nome)) {
            cor = Color.PINK;
        }
        if ("Vermelho".equals(nome)) {
            cor = Color.RED;
        }
        if ("Branco".equals(nome)) {
            cor = Color.WHITE;
        }
        if ("Amarelo".equals(nome)) {
            cor = Color.YELLOW;
        }

        return cor;
    }

}
