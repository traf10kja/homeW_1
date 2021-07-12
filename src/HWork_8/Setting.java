package HWork_8;

import javax.swing.*;
import java.awt.*;


public class Setting extends JFrame{

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;


    private GameWindow gameWindow;

    private JSlider sliderFieldSize;
    private JSlider sliderDotsToWin;


    public Setting(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(525, 250, 450, 450);
        setTitle("TicTacToe settings");

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintTicks(true);
        sliderFieldSize.setPaintLabels(true);
        sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintTicks(true);
        sliderDotsToWin.setPaintLabels(true);

        sliderFieldSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderFieldSize.getValue()));

        setLayout(new GridLayout(5, 1));
        add(new Label("Choose field size:"));
        add(sliderFieldSize);
        add(new Label("Choose winning line:"));
        add(sliderDotsToWin);

        JButton button = new JButton("Start a game!");
        add(button);
        button.addActionListener(e -> {
            int fieldSize = sliderFieldSize.getValue();
            int winLength = sliderDotsToWin.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOT_TO_WIN = winLength;
            Logic.initMap();
            Logic.printMap();
            Logic.isGameFinished = false;

            gameWindow.startNewGame(fieldSize, winLength);

            setVisible(false);
        });


        setVisible(false);

    }
}
