package Insurer;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    static int dimension = 2;
    static int cellSize = 150;
    private Game game;
    private JButton[] gameButtons;

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    public void initField(){
        setTitle("Кто хочет страть страховщиком");
        setBounds(dimension*cellSize,dimension*cellSize,400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel questPanel = new JPanel();
        JLabel question = new JLabel("Здесь вопрос");
        questPanel.setLayout(new BoxLayout(questPanel,BoxLayout.Y_AXIS));
        questPanel.add(question);
        JPanel gameField = new JPanel();
        gameField.setLayout(new GridLayout(dimension,dimension));
        gameField.setSize(cellSize*dimension,cellSize*dimension);
        gameButtons = new JButton[dimension*dimension];
        for(int i = 0; i < dimension*dimension; i++){
            JButton fieldButton = new JButton();
            gameField.add(fieldButton);
            gameButtons[i] = fieldButton;
        }
        getContentPane().add(questPanel,BorderLayout.NORTH);
        getContentPane().add(gameField,BorderLayout.CENTER);
        setVisible(true);
    }
}
