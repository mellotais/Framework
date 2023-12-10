package matematicaDiscreta;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HasseDiagrama extends JFrame {

    private static final long serialVersionUID = 1L;
    private Set<Set<Integer>> conjuntoPartes;
    private Map<Set<Integer>, Point> setToPoint;

    public HasseDiagrama(Set<Set<Integer>> conjuntoPartes) {
        this.conjuntoPartes = conjuntoPartes;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        setToPoint = new HashMap<>();
        organizeSets();
    }

    private void organizeSets() {
        int setWidth = 100;
        int setHeight = 50;
        int horizontalSpacing = 20;
        int verticalSpacing = 20;

        int totalSets = conjuntoPartes.size();
        int setsPerRow = Math.max(1, getWidth() / (setWidth + horizontalSpacing));
        int totalRows = (int) Math.ceil((double) totalSets / setsPerRow);

        int startX = getWidth() - (setsPerRow * (setWidth + horizontalSpacing)) + horizontalSpacing;  // Mover para a direita
        int startY = (getHeight() + totalRows * (setHeight + verticalSpacing)) / 2;

        int x = startX;
        int y = startY;

        for (Set<Integer> set : conjuntoPartes) {
            setToPoint.put(set, new Point(x, y));
            y -= setHeight + verticalSpacing;

            if (y < startY - totalRows * (setHeight + verticalSpacing) + setHeight) {
                y = startY;
                x += setWidth + horizontalSpacing;
            }
        }
    }




    private void paintEdges(Graphics g) {
        g.setColor(Color.BLACK);

        for (Set<Integer> setA : conjuntoPartes) {
            for (Set<Integer> setB : conjuntoPartes) {
                if (isSubset(setA, setB)) {
                    Point pointA = setToPoint.get(setA);
                    Point pointB = setToPoint.get(setB);

                    g.drawLine(pointA.x, pointA.y, pointB.x, pointB.y);
                }
            }
        }
    }

    private boolean isSubset(Set<Integer> setA, Set<Integer> setB) {
        return setB.containsAll(setA) && !setA.equals(setB);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        organizeSets();  

        paintEdges(g);

        for (Map.Entry<Set<Integer>, Point> entry : setToPoint.entrySet()) {
            drawSet(g, entry.getKey(), entry.getValue());
        }
    }

    private void drawSet(Graphics g, Set<Integer> set, Point point) {
        g.setColor(Color.BLACK);
        g.fillOval(point.x - 20, point.y - 20, 40, 40);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();
        String setText = set.toString();
        int textWidth = fm.stringWidth(setText);
        int textHeight = fm.getHeight();

        g.drawString(setText, point.x - textWidth / 2, point.y + textHeight / 4);
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Set<Set<Integer>> conjuntoPartes = Conjuntos.conjuntoDasPartes(array1);
        System.out.println("Conjunto das Partes: " + conjuntoPartes);

        SwingUtilities.invokeLater(() -> new HasseDiagrama(conjuntoPartes));
    }
}

