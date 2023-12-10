package matematicaDiscreta;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Set;

public class DiagramaVenn extends JFrame {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private Set<Integer> conjuntoA;
	@SuppressWarnings("unused")
	private Set<Integer> conjuntoB;
    private Set<Integer> intersecao;
    private Set<Integer> diferenca;
    private Set<Integer> complemento;

    public DiagramaVenn(Set<Integer> conjuntoA, Set<Integer> conjuntoB, Set<Integer> intersecao, Set<Integer> diferenca, Set<Integer> complemento) {
        this.conjuntoA = conjuntoA;
        this.conjuntoB = conjuntoB;
        this.intersecao = intersecao;
        this.diferenca = diferenca;
        this.complemento = complemento;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int radius = 80;
        int x1 = 140;
        int x2 = 240;
        
        int y = 180;  


        /// Desenha os círculos
        g2d.setColor(Color.BLUE);
        Ellipse2D circleA = new Ellipse2D.Double(x1 - radius, y - radius, 2 * radius, 2 * radius);
        g2d.fill(circleA);
       
       

        g2d.setColor(Color.GREEN);
        Ellipse2D circleB = new Ellipse2D.Double(x2 - radius, y - radius, 2 * radius, 2 * radius);
        g2d.fill(circleB);
        
        

        // Pinta a área de interseção com uma cor diferente (por exemplo, amarelo)
        g2d.setColor(Color.YELLOW);
        Area intersecaoArea = new Area(circleA);
        intersecaoArea.intersect(new Area(circleB));
        g2d.fill(intersecaoArea);


        // Preenche a área de interseção
        g2d.fill(intersecaoArea);

     
        Font font = new Font("Arial", Font.BOLD, 15);
        g2d.setFont(font);
     
        // Ajustes para rótulos A e B
        g2d.setColor(Color.RED);
        g2d.drawString("A", (float) (x1 - 1), y - radius - 5);
        g2d.drawString("B", (float) (x2 - 1), y - radius - 5);

        // Ajustes para números da interseção
        g2d.setColor(Color.BLACK);
        int yOffsetIntersecao = -5;
        for (Integer elemento : intersecao) {
            g2d.drawString(String.valueOf(elemento), (float) (x1 + x2) / 2 - 15, y + yOffsetIntersecao);
            yOffsetIntersecao += 15;
        }

        // Ajustes para números da diferença
        g2d.setColor(Color.BLACK);
        int yOffsetDiferenca = -5;
        for (Integer elemento : diferenca) {
            g2d.drawString(String.valueOf(elemento), (float) (x1 - 15), y + yOffsetDiferenca);
            yOffsetDiferenca += 15;
        }

        // Ajustes para números do complemento
        g2d.setColor(Color.BLACK);
        int yOffsetComplemento = -5;
        for (Integer elemento : complemento) {
            g2d.drawString(String.valueOf(elemento), (float) (x2 - 15), y + yOffsetComplemento);
            yOffsetComplemento += 15;
        }
    }

   
}
