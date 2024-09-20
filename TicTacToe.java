import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame();
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    TicTacToe() {
        frame.setTitle("Tic Tac Toe Game");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe"); 
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        frame.add(textPanel, BorderLayout.NORTH);

        
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.DARK_GRAY);
        frame.add(boardPanel, BorderLayout.CENTER);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.BLUE);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                               tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer); 
                            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                            textLabel.setText("Current Player: " + currentPlayer);  
                        }
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        // Inisialisasi permainan dengan memanggil constructor TicTacToe
        new TicTacToe();
    }
}
