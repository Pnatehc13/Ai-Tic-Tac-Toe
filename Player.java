public class Player {
    char current;
    public Player(char Curr)
    {
        this.current = Curr;
    }
    public void Switch()
    {
        if(current == 'O')current = 'X';
        else if(current == 'X')current = 'O';
    }
}
