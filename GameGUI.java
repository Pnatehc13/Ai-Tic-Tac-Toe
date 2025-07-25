import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
    public static void main(String[] args)
    {
        final int[] m = {0};
        // Initial Setting / Global parts
        JFrame board = new JFrame("TicTacToe");
        board.setSize(300,400);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLayout(new BorderLayout());
        Font font = new Font("Arial",Font.BOLD,32);
        Player Curr = new Player('O');
        Score Score = new Score();
        Board b2 = new Board();

// Label
        JLabel score = new JLabel("X: "+Score.X+" O: "+ Score.O+" Draws: "+Score.draw, SwingConstants.CENTER);
        score.setFont(new Font("Arial",Font.BOLD,24));

// Player
        JLabel player = new JLabel("Player : "+Curr.current, SwingConstants.CENTER);
        player.setFont(new Font("Arial",Font.BOLD,24));

// Board
        JPanel grid = new JPanel(new GridLayout(3,3));
        grid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton[][] button = new JButton[3][3];

        Runnable resetBoard = () -> {
            m[0] =0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    button[i][j].setText("");
                    button[i][j].setEnabled(true);
                    b2.board[i][j] = ' ';

                }
            }
        };

        Runnable checkGameEnd = () -> {
            char winner = b2.getwinner(b2.board);
            if (m[0] == 9 || winner != ' ') {
                if (winner != ' ')
                    JOptionPane.showMessageDialog(null, "Player " + winner + " wins!");
                else
                    JOptionPane.showMessageDialog(null, "DRAW!!");

                Score.scoreupdate(winner);
                score.setText("X: " + Score.X + " O: " + Score.O + " Draws: " + Score.draw);

                int option = JOptionPane.showConfirmDialog(null, "Play again?", "Restart", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    resetBoard.run();
                } else {
                    System.exit(0);
                }
            }
        };



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;

                button[i][j] = new JButton("");
                button[i][j].setFont(font);

                button[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (Curr.current == 'O' && b2.check(row, col, Curr.current)) {
                            button[row][col].setText(String.valueOf(Curr.current));
                            button[row][col].setEnabled(false);
                            m[0] += 1;
                            checkGameEnd.run();

                            Curr.Switch();
                            player.setText("Current Player: "+ Curr.current);
                            int[] moves = b2.getbestmove(b2.board);
                            b2.board[moves[0]][moves[1]] = Curr.current;
                            button[moves[0]][moves[1]].setText(String.valueOf(Curr.current));
                            button[moves[0]][moves[1]].setEnabled(false);

                            m[0] += 1;
                            checkGameEnd.run();
                            Curr.Switch();
                            player.setText("Current Player: "+ Curr.current);

                        }
                        else
                        {
                            System.out.println("Invalid move");
                        }
                    }
                });

                grid.add(button[i][j]);
            }
        }


// Adding on to Board
        board.add(player,BorderLayout.NORTH);
        board.add(grid,BorderLayout.CENTER);
        board.add(score,BorderLayout.SOUTH);

//Running
        board.setVisible(true);
    }
}
