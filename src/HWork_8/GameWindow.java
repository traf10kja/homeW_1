package HWork_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private BattleMap battleMap;
    private Setting setting;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 250, 500, 400);
        setTitle("TicTacToe");


        JPanel panel = new JPanel(new GridLayout(1, 2));

        JButton button = new JButton("Start new game");
        panel.add(button, BorderLayout.NORTH);

        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);

        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);

        setting = new Setting(this);

        button.addActionListener(e -> setting.setVisible(true));

        buttonExit.addActionListener(e -> System.exit(0));


        setVisible(true);
    }

    void startNewGame(int fieldSize, int winLength) {
        battleMap.startNewGame(fieldSize,winLength);
    }

    }
