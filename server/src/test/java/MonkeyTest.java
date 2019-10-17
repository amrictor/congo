package Game ;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.Assert.*;
import Game.GamePiece;
import Game.GameBoard;
import Game.Player;

import java.util.ArrayList;
import java.util.Arrays;

/*
  This class contains tests for the Monkey piece in Congo.
 */

public class MonkeyTest {
    GameBoard congoGame;
    Player congoPlayer;

    // Setup to be done before every test in TestPlan
    @Before
    public void initialize() {
        congoPlayer = new Player(1);
        congoGame = new GameBoard();
        congoGame.InitGameBoard();
    }

    @Test
    public void testMonkeyMove() {
        /* Start with initial board */
        /* this test assumes there are no pawns on the board yet */
        MonkeyPiece monkey1 = (MonkeyPiece) congoGame.board[0][1];
        ArrayList<Integer> movesRow = new ArrayList<Integer>();
        ArrayList<Integer> movesCol = new ArrayList<Integer>();
        movesRow.add(1);
        movesCol.add(0);

        /* jump to 1,0 which should be blocked*/
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);
        movesCol.set(0,1);  /* try jumping to 1,1 which should also be blocked by a pawn */
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);
        movesCol.set(0,2);  /* try jumping to 1,2 which is again blocked by a pawn */
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);
        movesRow.set(0,2); /* try jumping to 2,2 which is not a straight line move */
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);

        /* move the opponent's zebra to 1,2 */
        congoGame.movePiece(6,6,1,2);  /* move zebra from 6,6 to 1,2 so it is capturable with a jump */
        /* make first move in sequence -> 2,3 */
        movesRow.set(0,2);
        movesCol.set(0,3);
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == true);
        congoGame.movePiece(6,0,1,4);  /* move opponent's giraffe to 1,4 */
        /* will not be capturable because crocodile is blocking */
        movesRow.add(0);  /* add jump to 0,5, but this should be blocked */
        movesCol.add(5);  /* Now have 2 moves in our sequence */
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);
        /* now move the crocodile and allow the jump */
        congoGame.movePiece(0,5,1,6);  /* move crocodile from 0,5 to 1,6 so monkey can capture opponent's giraffe */
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == true);
    }

    @Test
    public void testMonkeyCantJumpTwice() {
        /* Start with initial board */
        /* this test assumes there are no pawns on the board yet */
        /* tests to make sure we block move if piece is jumped twice */
        congoGame.movePiece(0,1,2,1);  /* initialize player's monkey to 2,1 */
        congoGame.movePiece(6,2,3,2);  /* initialize opponent's elephant to 3,2 */
        congoGame.movePiece(6,4,2,4);  /* initialize opponent's elephant to 2,4 */
        congoGame.movePiece(6,1,4,2);  /* initialize opponent's monkey to 4,2 */
        System.out.println("board \n"+ congoGame.toString());

        ArrayList<Integer> movesRow = new ArrayList<Integer>();
        ArrayList<Integer> movesCol = new ArrayList<Integer>();
        /* perform valid double jump (2,1) to (4,3) to (4,1) */
        movesRow.add(4);
        movesCol.add(3);
        movesRow.add(4);
        movesCol.add(1);
        MonkeyPiece monkey1 = (MonkeyPiece) congoGame.board[2][1];
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == true);
        /* now try and do an illegal move by jumping the first elephant again to get to the second elephant */
        /* add jumps to (2,3) to (2,5) */
        movesRow.add(2);
        movesCol.add(3);
        movesRow.add(2);
        movesCol.add(5);
        assertTrue(monkey1.ValidateMove(movesRow,movesCol,congoGame.board) == false);
    }


}