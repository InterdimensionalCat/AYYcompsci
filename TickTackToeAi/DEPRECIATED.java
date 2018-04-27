
/**
 * Write a description of class DEPRECIATED here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DEPRECIATED
{
   /* public int checkWin(char[] game, int spot, boolean isAi)
    {
        char checkLetter = ' ';
        if (isAi) {
            checkLetter = this.letter;
        } else {
            switch (this.letter) {
                case 'X':
                checkLetter = 'O';
                break;
                case 'O':
                checkLetter = 'X';
                break;
            }
            int sum = 0;
            for (int i = 0; i < 3; i++)
            {
                //across
                if (game[i*3] == checkLetter && ( checkLetter == game[i*3 + 1] || checkLetter == game[i*3 + 2]))
                {
                    while(game[spot] != ' ') {
                        sum = 0;
                        spot = game[i*3 + sum];
                        sum++;
                    }
                    return spot;
                } else {
                    if ( checkLetter == game[i*3 + 1] && ( game[i*3] == checkLetter || checkLetter == game[i*3 + 2]))
                    {
                        while(game[spot] != ' ') {
                            sum = 0;
                            spot = game[i*3 + sum];
                            sum++;
                        }
                        return spot;
                    } else {
                        if (checkLetter == game[i*3 + 2] && ( game[i*3] == checkLetter || checkLetter == game[i*3 + 1]))
                        {
                            while(game[spot] != ' ') {
                                sum = 0;
                                spot = game[i*3 + sum];
                                sum++;
                            }
                            return spot;
                        }
                    }
                }
                //up & down
                if (game[i] == checkLetter && (game[i + 3] == checkLetter || game[i + 6] == checkLetter))
                {
                    while(game[spot] != ' ') {
                        sum = 0;
                        spot = game[i + sum];
                        sum+=3;
                    }
                    return spot;
                } else {
                    if (game[i + 3] == checkLetter && (game[i] == checkLetter|| game[i + 6] == checkLetter))
                    {
                        while(game[spot] != ' ') {
                            sum = 0;
                            spot = game[i + sum];
                            sum+=3;
                        }
                        return spot;
                    } else {
                        if (game[i + 6] == checkLetter&& (game[i + 3] == checkLetter || game[i] == checkLetter))
                        {
                            while(game[spot] != ' ') {
                                sum = 0;
                                spot = game[i + sum];
                                sum+=3;
                            }
                            return spot;    
                        }
                    }
                }
            }

            //diagonal
            if (game[0] == checkLetter && (checkLetter == game[4] || checkLetter == game[8]))
            {
                while(game[spot] != ' ') {
                    sum = 0;
                    spot = game[sum];
                    sum+=4;
                }
                return spot;
            } else {
                if (checkLetter == game[4] && (game[0] == checkLetter || checkLetter == game[8])) {
                    while(game[spot] != ' ') {
                        sum = 0;
                        spot = game[sum];
                        sum+=4;
                    }
                    return spot;
                } else {
                    if (checkLetter == game[8] && (checkLetter == game[4] || game[0] == checkLetter)) {
                        while(game[spot] != ' ') {
                            sum = 0;
                            spot = game[sum];
                            sum+=4;
                        }
                        return spot;
                    }
                }
            }

            if (game[2] == checkLetter && (checkLetter == game[4] || checkLetter == game[6]))
            {
                while(game[spot] != ' ') {
                    sum = 2;
                    spot = game[sum];
                    if (game[spot] == ' ') {
                        continue;
                    }
                    sum+=2;
                }
                return spot;
            } else {
                if (checkLetter == game[4] && (game[2] == checkLetter || checkLetter == game[6])) {
                    while(game[spot] != ' ') {
                        sum = 2;
                        spot = game[sum];
                        if (game[spot] == ' ') {
                            continue;
                        }
                        sum+=2;
                    }
                    return spot;
                } else {
                    if (checkLetter == game[6] && (checkLetter == game[4] || game[2] == checkLetter)) {
                        while(game[spot] != ' ') {
                            sum = 2;
                            spot = game[sum];
                            if (game[spot] == ' ') {
                                continue;
                            }
                            sum+=2;
                        }
                        return spot;
                    }
                }
            }
            //      if (game[2] != ' ' && game[2] == game[4] && game[4] == game[6])
            //      {
            //       //DO IT
            //      }

        }
        return -1;
    }*/
    
    
    
    
    /* for (int i = 0; i < 3; i++)
            {
                spot = betterWin(i*3, i*3+1, i*3+2, game,  this.letter);
                if (spot != -1) {
                    System.out.println( "I WIN");
                    break;
                } else {
                    spot = betterWin(i, i+3, i+6, game, this.letter);
                }
                if (spot != -1) {
                    System.out.println( "I WIN");
                    break;
                } else {
                    spot = betterWin(0, 4, 8, game, this.letter);
                }
                if (spot != -1) {
                    System.out.println( "I WIN");
                    break;
                } else {
                    spot = betterWin(2, 4, 6, game, this.letter);
                }
                if (spot != -1) {
                    System.out.println( "I WIN");
                    break;
                }
            } */
            
            /*     public static int getCenterCorner(char[] game) {
        int[] goodPos = {0,2,4,6,8};
        int possiblePos;
        int rand = 0;
        boolean willWork = false;
        for(int i : goodPos) {
            if ( game[i] == ' '){
                willWork = true;
                break;
            }
        }

        if (!willWork)
        {
            return -1;
        }

        for(int i : goodPos) {
            if ( game[i] == ' ') {
                do
                {
                    rand = (int)(Math.random()*8);
                    if (rand > 4) { //this makes it so that the AI has a 50% chance of choosing the middle if it is avalible
                        rand = 2; 
                    }
                    possiblePos = goodPos[rand];
                    System.out.println("number " + possiblePos);
                } while(game[possiblePos] != ' ');
                return possiblePos;
            }
        }
        return -1; // if none of the spots are avalible, defaults to -1
    } */
}
