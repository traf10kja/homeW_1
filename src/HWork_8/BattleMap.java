package HWork_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;
    private int fieldSize;
    private int winLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);
                }
                repaint();
            }
        });
    }

    void startNewGame(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        isInit = true;
        repaint();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.map.length; i++) {
            for (int j = 0; j < Logic.map.length; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                }
            }
        }
        for (int i = 0; i < Logic.map.length; i++) {
            for (int j = 0; j < Logic.map.length; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }

            }

        }


    }

    private void drawX(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        g.drawLine(x * cellWidth, y * cellHeight, (x + 1) * cellWidth, (y + 1) * cellHeight);
        g.drawLine((x + 1) * cellWidth, y * cellHeight, x * cellWidth, (y + 1) * cellHeight);
    }

    private void drawO(Graphics g, int y, int x) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));

        g.drawOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
    }
}
