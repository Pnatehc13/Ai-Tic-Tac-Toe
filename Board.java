
public class Board{
    char[][] board = new char[3][3];

    public Board()
    {
        for(int i =0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]=' ';
    }

    public void printGrid() {
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    public boolean check(int row,int col,char sym)
    {
        if(row<0||row>2||col<0||col>2||board[row][col]!=' ')return false;
        board[row][col] = sym;
        return true;
    }
    public char getwinner(char[][] board) {
        // vertical
        if(board[0][0] != ' ' && board[0][0]==board[1][0] && board[1][0]==board[2][0]) return board[0][0];
        if(board[0][1] != ' ' && board[0][1]==board[1][1] && board[1][1]==board[2][1]) return board[0][1];
        if(board[0][2] != ' ' && board[0][2]==board[1][2] && board[1][2]==board[2][2]) return board[0][2];

        // horizontal
        if(board[0][0] != ' ' && board[0][0]==board[0][1] && board[0][1]==board[0][2]) return board[0][0];
        if(board[1][0] != ' ' && board[1][0]==board[1][1] && board[1][1]==board[1][2]) return board[1][0];
        if(board[2][0] != ' ' && board[2][0]==board[2][1] && board[2][1]==board[2][2]) return board[2][0];

        // diagonals
        if(board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]) return board[0][0];
        if(board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) return board[0][2];

        return ' '; // No winner
    }

    private int evaluate(char aiplayer)
    {
        char win = getwinner(board);
        if(win == aiplayer)return 1;
        else if(win != ' ' )return -1;
        else return 0;
    }
    private boolean isFull()
    {
        for(int i =0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]==' ')return false;
        return true;
    }

    private int minimax(char[][] board,boolean isMinimax)
    {
        char winner = getwinner(board);
        if(winner == 'X') return 1;
        else if(winner == 'O') return -1;
        if(isFull()) return 0;

        if( isMinimax)
        {
            int bestscore = Integer.MIN_VALUE;
            for(int i =0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(board[i][j] == ' ')
                    {
                        board[i][j] = 'X';
                        int score = minimax(board,false);
                        board[i][j] = ' ';
                        bestscore = Math.max(score, bestscore);
                    }
                }
            }
            return bestscore;
        }
        else
        {
            int bestscore = Integer.MAX_VALUE;
            for(int i =0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(board[i][j] == ' ')
                    {
                        board[i][j] = 'O';
                        int score = minimax(board ,true);
                        board[i][j] = ' ';
                        bestscore = Math.min(score,bestscore);
                    }
                }
            }
            return bestscore;
        }
    }

    public int[] getbestmove(char[][] board)
    {
        int bestscore = Integer.MIN_VALUE;
        int[] move = {-1, -1};

        for(int i =0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j] == ' ')
                {
                    board[i][j] = 'X';
                    int score = minimax(board,false);
                    board[i][j] = ' ';

                    if(score>bestscore)
                    {
                        bestscore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }


}
