public class BennettAI extends PlayerTTT
{
    public BennettAI()
    {
        super("Bennett's Awesome Ai");
    }

    public int play(char[] game)
    {
        char opponent = ' ';
        switch(this.letter) { //determines the opponent's letter this is done so that when checking for winning/blocking moves, the AI will always choose to win over choosing to block
            case 'O':
            opponent = 'X';
            break;
            case 'X':
            opponent = 'O';
            break;
        }
        char[] letterOrder = {this.letter, opponent};
        int[] corners = {0, 2, 6, 8};
        int[] middle = {4};
        int[] sides = {1,3,5,7};
        //(int)(Math.random()*9);
        int spot = -1;
        spot = randomMove(corners, game, spot);
        if (spot == -1) {
        	spot = 0;
        }
        //getCenterCorner(game);
        while(game[spot] != ' ')
        {
           
            //AI checks for a winning spot or blocking spot first
            spot = winningMove(this.letter, game, spot);
            if (spot != -1) {
                break;
            } else {
                spot = winningMove(opponent, game, spot);
                if (spot != -1) {
                    break;
                }
            }
     
            
            if (spot == -1)
            {
                System.out.println("Choosing a random number");
                spot = (int)(Math.random()*9); //will choose a random number if none of the other options are avalible
            }
        }
        return spot;
    }

    //Choose a random position given possible positions
        public static int randomMove(int[] pos, char[] game, int spot) {
        boolean canPass = false;
        for(int x: pos) {
            if (game[x] == ' ') {
                canPass = true;
                break;
            }
        }
        if (!canPass) {
            return -1;
        }
        do {
            spot = pos[(int)(Math.random()*(pos.length))];
        } while(game[spot] != ' ');
        return spot;
    }

    //Method plays betterWin method with all possible winning move configurations; this is a seperate method rather than being in the play method because I need to do it with both characters
    public static int winningMove(char c, char[] game, int spot) {
        for (int i = 0; i < 3; i++)
        {
            spot = betterWin(i*3, i*3+1, i*3+2, game,  c);
            if (spot != -1) {
                return spot;
            } else {
                spot = betterWin(i, i+3, i+6, game, c);
            }
            if (spot != -1) {
                return spot;
            } else {
                spot = betterWin(0, 4, 8, game, c);
            }
            if (spot != -1) {
                return spot;
            } else {
                spot = betterWin(2, 4, 6, game, c);
            }
            if (spot != -1) {
                return spot;
            }
        }
        System.out.println("NO WINING SPOT FOR: " + c);
        return -1;
    }

    //Method Determines if there is 2 spots with letter checkLetter and one empty spot given 3 positions (used for determining a possible winning move)
    public static int betterWin(int x, int y, int z, char[] game , char checkLetter) {
        int[] numbers = {x,y,z};
        int sum = 0;
        int sum2 = 0;
        for (int i : numbers) {
            if (game[i] == checkLetter) {
                sum++;
            }
            if (game[i] == ' ') {
                sum2++;
            }
        }
        if (sum == 2 && sum2 == 1) {
            return getWinningSpot(x, y, z, game);
        }
        return -1;
    }

    //When a possible winning move has been determined, this method determines the right spot to move to
    public static int getWinningSpot(int x, int y, int z, char[] game)  {
        int spot = x;
        int rand = 0;
        do {
            rand++;
            switch (rand) {
                case 1:
                spot = x;
                break;
                case 2:
                spot = y;
                break;
                case 3:
                spot = z;
                break;
            }
            if (rand > 3)
            {
                System.out.println("METHOD DID NOT WORK");
                return -1;
            }
        } while(game[spot] != ' ');
        System.out.println(spot);
        return spot;
    }
}