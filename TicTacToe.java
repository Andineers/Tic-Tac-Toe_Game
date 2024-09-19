import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame();
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();

    TicTacToe() {
        frame.setTitle("Tic Tac Toe Game");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame. setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Tambahkan ini agar program berhenti ketika ditutup
        frame.setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        // Inisialisasi permainan dengan memanggil constructor TicTacToe
        new TicTacToe();
    }
}
