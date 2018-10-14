package Insurer;

import javax.swing.*;

    public class Game {
        private GameBoard board;

        public Game() {
            this.board = new GameBoard(this);
        }

        void showMessage(String messageText) {
            JOptionPane.showMessageDialog(board, messageText);
        }
    }

