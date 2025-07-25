import java.util.Scanner;

public class ConsoleGUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Score Score = new Score();
        do
        {
            Board board = new Board();
            Player current = new Player('O');
            int moves =0;
            while(true)
            {
                board.printGrid();
                if (current.current == 'O') {
                    // Human move
                    System.out.println("Player O, enter your move:");
                    int row = sc.nextInt();
                    int col = sc.nextInt();
                    if (!board.check(row, col, current.current)) {
                        System.out.println("Invalid move. Try again.");
                        continue;
                    }
                } else {
                    // AI move for X
                    boolean moved = false;
                    for (int i = 0; i < 3 && !moved; i++) {
                        for (int j = 0; j < 3 && !moved; j++) {
                            if (board.check(i, j, current.current)) {
                                System.out.println("AI played at: " + i + "," + j);
                                moved = true;
                            }
                        }
                    }

                }

                moves++;
                char winner = board.getwinner(board.board);
                if(winner!=' ')
                {
                    board.printGrid();
                    System.out.println("Player: "+ winner+" Wins!");
                    Score.scoreupdate(winner);
                    break;
                }
                if(moves == 9)
                {
                    board.printGrid();
                    System.out.println("Its a draw!");
                    Score.scoreupdate(' ');
                    break;
                }
                current.Switch();
            }

            Score.scoredisplay();

            System.out.println("Do You want to play again(0-NO/1-Yes): ");
            choice = sc.nextInt();

        }while(choice == 1);
        sc.close();
    }
}
