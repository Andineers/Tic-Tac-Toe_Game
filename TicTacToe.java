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

    boolean gameOver = false;
    int turns = 0;

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
                        if (gameOver) return;  // Jika game sudah selesai, hentikan
                        JButton tile = (JButton) e.getSource();

                        if (tile.getText().equals("")) {
                            tile.setText(currentPlayer);  
                            turns++;  // Tambah jumlah giliran
                            checkWinner();  
                            if (!gameOver) {
                                if (turns == 9) {
                                    setTie();
                                } else {
                                    currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                    textLabel.setText(currentPlayer + "'s turn."); 
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    void checkWinner() {
        // Periksa setiap baris
        for (int r = 0; r < 3; r++) {
            if (!board[r][0].getText().equals("") && 
                board[r][0].getText().equals(board[r][1].getText()) && 
                board[r][1].getText().equals(board[r][2].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        // Periksa setiap kolom
        for (int c = 0; c < 3; c++) {
            if (!board[0][c].getText().equals("") && 
                board[0][c].getText().equals(board[1][c].getText()) && 
                board[1][c].getText().equals(board[2][c].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        // Periksa diagonal
        if (board[0][0].getText().equals(board[1][1].getText()) && 
            board[1][1].getText().equals(board[2][2].getText()) && 
            !board[0][0].getText().equals("")) {
            setWinner(board[0][0]);
            setWinner(board[1][1]);
            setWinner(board[2][2]);
            gameOver = true;
            return;
        }

        // Periksa anti-diagonal
        if (board[0][2].getText().equals(board[1][1].getText()) && 
            board[1][1].getText().equals(board[2][0].getText()) && 
            !board[0][2].getText().equals("")) {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }
    }

    // Set pemenang dengan mengubah warna dan mengatur teks
    void setWinner(JButton tile) {
        tile.setForeground(Color.GREEN);   
        tile.setBackground(Color.BLUE);  
        textLabel.setText(currentPlayer + " is the winner!"); 
    }

    // Set tie (seri) jika permainan berakhir tanpa pemenang
    void setTie() {
        textLabel.setText(" Tie!");  
        gameOver = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
