public class Score {
    int X =0;
    int O = 0;
    int draw =0;
    public void scoreupdate(char p)
    {
        if(p == 'X')X++;
        else if(p == 'O')O++;
        else draw++;
    }
    public void scoredisplay()
    {
        System.out.println("Player X score: "+X);
        System.out.println("Player O score: "+O);
        System.out.println("Draws: "+draw);
    }
}
