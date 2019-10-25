package Game ;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import javax.annotation.processing.SupportedAnnotationTypes;
import static org.junit.Assert.*;
<<<<<<< HEAD
=======

>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
import java.util.ArrayList;
import java.util.Arrays;

/*
  This class contains tests for the Zebra piece in Congo.
 */

public class ZebraTest {
    GameBoard congoGame;

    // Setup to be done before every test in TestPlan
    @Before
    public void initialize() {
        congoGame = new GameBoard();
        congoGame.initialize();
<<<<<<< HEAD
        congoPlayer1 = new Player(1);
        congoPlayer1.initPlayerPieces(congoGame);
        congoPlayer2 = new Player(2);
        congoPlayer2.initPlayerPieces(congoGame);
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    }

    @Test
    public void testZebraSimpleMove() {
        /*Start with initial board and test if Player 1 zebra can move from (0,6) to (2,5) */
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(0,6);
        assertTrue(zebra.ValidateMove(2,5,congoGame.board) == true);
    }

    @Test
    public void testZebraBlockedMove() {
        /* Start with initial board and put Crocodile at row 2, col 3 to block move */
        /* Test if Player 1 zebra move from (0,6) to (2,5) is blocked */
        GamePiece[][] congoBoard = congoGame.board;
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(0,6);
        congoBoard[2][5] = congoBoard[0][5];
        assertTrue(zebra.ValidateMove(2,5,congoBoard) == false);
    }

    @Test
    public void testZebraMove3Fail() {
        /* Start with initial board and test is Player 1 zebra can move from (0,6) to (3,6) */
        /* This move is illegal for Zebra */
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(0,6);
        assertTrue(zebra.ValidateMove(3,6,congoGame.board) == false);
    }

    @Test
    public void testZebraPerformSimpleMoveNoCapture() {
        /* Start with initial board and test if Player 2 zebra can move from (6,6) to (4,5) */
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(6,6);
        assertTrue(zebra.performMove(4, 5, congoGame) == true);
        /* check that source location is now empty */
        assertTrue(congoGame.getGamePiece(6,6) == null);
<<<<<<< HEAD
        /* check that player array of pieces has zebra and it's not captured */
        assertTrue(congoPlayer2.playerPieces[6] != null);
        //assertTrue(congoPlayer2.playerPieces[6].checkCaptured() == false);
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
        /* check that GamePiece got updated correctly */
        assertTrue(zebra.row == 4);
        assertTrue(zebra.column == 5);
    }

    @Test
    public void testZebraPerformSimpleMoveWithCapture() {
        /* Start with initial board and test if Player 2 zebra can move from (6,6) to (4,5) */

        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(6,6);
        /* move opponent's crocodile from 0,5 to 4,5 */
        congoGame.movePiece(0,5,4,5);
        /* Now move zebra from 6,6 to 4,5 to see if it can capture crocodile */
        assertTrue(zebra.ValidateMove(4, 5, congoGame.board) == true);
        assertTrue(zebra.performMove(4, 5, congoGame) == true);
        /* check that source location is empty */
        assertTrue(congoGame.getGamePiece(6,6) == null);
<<<<<<< HEAD
        /* check that player array of pieces has zebra */
        assertTrue(congoPlayer2.playerPieces[6] != null);
        /* check that player array of pieces has crocodile marked as captured */
        //assertTrue(congoPlayer1.playerPieces[5].checkCaptured());
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
        /* check that GamePiece got updated correctly */
        assertTrue(zebra.row == 4);
        assertTrue(zebra.column == 5);
    }

    @Test
    public void testZebraDrowning() {
        /* Start with initial board and test if Player 1 zebra can move from (0,6) to (2,5) */
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(0,6);
        zebra.performMove(2, 5, congoGame);
        assertTrue(zebra.inRiver() == false);
        /* now move zebra into river */
        zebra.performMove(3, 3, congoGame);
        assertTrue(zebra.inRiver());
        //assertTrue(zebra.checkCaptured() == false);
        /* now move a pawn so that zebra ends 2 consecutive turns in the river and drowns */
        PawnPiece pawn = (PawnPiece) congoGame.getGamePiece(1,0);
        pawn.performMove(2, 1, congoGame);
        /* check if zebra was drown (captured) and removed from the board */
       // assertTrue(zebra.checkCaptured());
        assertTrue(congoGame.getGamePiece(3,3) == null);
    }

    @Test
    public void testZebraMoveArray() {
        /* Start with initial board and test if Player 1 zebra can move from (6,6) to (5,4)
        using array to contain move sequence */
        /* since (5,4) contains one of the active player's pawns, it should not be able to move */
        ZebraPiece zebra = (ZebraPiece) congoGame.getGamePiece(6, 6);
        /* move opponent's pawn so zebra has something to capture */

        ArrayList<Integer> movesRow = new ArrayList<Integer>();
        ArrayList<Integer> movesCol = new ArrayList<Integer>();
        movesRow.add(5);
        movesCol.add(4);
        assertTrue(zebra.ValidateMove(5, 4, congoGame.board) == false);
        assertTrue(zebra.performMove(movesRow, movesCol, congoGame) == false);  /* can't move since pawn is blocking /
        /* now move an opponent's pawn on top of blocking pawn */
        PawnPiece pawn = (PawnPiece) congoGame.getGamePiece(1, 6);
        congoGame.movePiece(pawn, 5, 4);

        assertTrue(zebra.ValidateMove(5, 4, congoGame.board));
        assertTrue(zebra.performMove(movesRow, movesCol, congoGame));  /* now can move since pawn is opponent's */
        assertTrue(congoGame.getGamePiece(6, 6) == null);  /* zebra has moved */
    }

}
