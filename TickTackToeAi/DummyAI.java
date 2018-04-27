
import java.util.ArrayList;
/**
 * Write a description of class DummyAI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DummyAI extends PlayerTTT
{
    public int lastSpot = -1;
    public ArrayList<Integer> positions = new ArrayList<Integer>();
    public DummyAI() //AI tests the randomMove method, which will choose a random spot based off an array of possible spots, if none are avalible, returns -1
    {
        super("dummy AI");
    }

    public int play(char[] game)
    {
        char opponent = ' ';
        switch(this.letter) { 
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
        //System.out.println("MIDDLE");
        int spot = -1;
        spot = randomMove(corners, game, spot);

        //Chooses the corner opposite to the last corner placed
        switch (lastSpot) {
            case 0:
            spot = 8;
            break;
            case 2:
            spot = 6;
            break;
            case 6:
            spot = 2;
            break;
            case 8:
            spot = 0;
            break;
            default:
            spot = -1;
        }
		if (spot != -1) {
			if ((game[spot] != ' ')) {
				System.out.println("OPPOSITE CORNER " + spot + " UNAVALIBLE");
				spot = -1;
			}
		}
        int possibleSpot = getPosFromCorner(game, this.letter);
        	if(possibleSpot != -1) {
        		spot = possibleSpot;
        	}
        
        if (spot == -1) {
            System.out.println("SIDE");
            spot = randomMove(sides, game, spot);
        }
        
        if (spot == -1) {
            System.out.println("MIDDLE");
            spot = randomMove(middle, game, spot);
        }
        
        if (spot == -1) {
            System.out.println("CORNER");
            spot = randomMove(corners, game, spot);
        }
        this.lastSpot = spot;
        this.positions.add(spot);
        return spot;
    }

    public static int randomMove(int[] pos, char[] game, int spot) {
        boolean canPass = false;
        for(int x: pos) {
            if (game[x] == ' ') {
                canPass = true;
                break;
            }
        }
        if (!canPass) {
            System.out.println(canPass);
            System.out.println("RETURNING -1");
            System.out.println(game);
            return -1;
        }
        do {
            spot = pos[(int)(Math.random()*(pos.length))];
        } while(game[spot] != ' ');
        System.out.println(spot);
        System.out.println(canPass);
        return spot;
    }

    //Method returns true if one position is filled with ai's letter, but the other two positions are not
    public static boolean isBlocked(int x, int y, int z, char[] game , char checkLetter) {
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
        if (sum == 1 && sum2 == 0) {
            return false;
        }
        return true;
    }

    public static int getPosFromCorner(char[] game, char l) { //will set up a trap if possible
        ArrayList<Integer> pos = new ArrayList<Integer>();
        if ( game[0] == l && game[8] == l) {
            pos.add(1);
            pos.add(2);
            pos.add(5);
            if (isPosFree(pos, game)) {
                return 2;
            } else {
                pos.clear();
                pos.add(3);
                pos.add(6);
                pos.add(7);
                if (isPosFree(pos, game)) {
                    return 6;
                }
            }
        }
        if ( game[2] == l && game[6] == l) {
            pos.add(0);
            pos.add(1);
            pos.add(3);
            if (isPosFree(pos, game)) {
                return 0;
            } else {
                pos.clear();
                pos.add(5);
                pos.add(7);
                pos.add(8);
                if (isPosFree(pos, game)) {
                    return 8;
                }
            }
        }
        System.out.println("RETURNING -1");
        return -1;
    }

    public static boolean isPosFree(ArrayList<Integer> pos, char[] game) { //checks that all spots in an arraylist are open
        for(int i : pos) {
            if (game[i] != ' ')
            {
                System.out.println("RETURNING FALSE");
                return false;
            }
        }
        return true;
    }
}

