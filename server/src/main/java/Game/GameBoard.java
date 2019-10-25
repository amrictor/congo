package Game;

<<<<<<< HEAD
import java.util.*;

public class GameBoard{
    public static final int RIVER_ROW = 3;
    public static final int NUM_ROWS = 7;
    public static final int NUM_COLUMNS = 7;
=======
import java.util.ArrayList;
import java.util.ListIterator;

public class GameBoard{
    public static final int NUM_ROWS = 7;
    public static final int NUM_COLUMNS = 7;
    public static final int RIVER_ROW = 3;

>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    public GamePiece[][] board;

    public GameBoard(){
        board = new GamePiece[NUM_ROWS][NUM_COLUMNS];
    }
<<<<<<< HEAD

    /**
    Places pieces on the board during initial setup
    */
=======
    
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    public void initialize(){
        placePiecesForPlayer(1);
        placePiecesForPlayer(2);
    }
    
<<<<<<< HEAD
    /**
    Returns a visual represenation of the state of the board
    */
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    public String toString(){
        String row = "";
        String boardStr = "--------------\n";
        String playPiece;
        for (int i = NUM_ROWS - 1; i >= 0; i--){
            /* traverse each row one at a time */
            row = "|";
            for (int j = 0; j < NUM_COLUMNS; j++){
                /* traverse all columns in this row to see what pieces are on the board */
                GamePiece piece = getGamePiece(i,j);
                playPiece = (piece == null) ? " " : piece.pieceIDString();

                row = row + playPiece + "|";
            }
            row = row + "\n";
            row = row + "--------------\n";
            boardStr = boardStr + row;
        }

        return boardStr;
    }
    
<<<<<<< HEAD
    /**
    Loads an existing game
    @param string representation of board
    */
    public void loadGame(String[][] board){
        //this will be sent all the information it needs to create a new game with info from the database
    }
=======
    public void loadGame(String[][] board){
    }

    public GamePiece getGamePiece(int row, int col){
        if(inBounds(row, col)){
            return board[row][col];
        }
        else return null;
    }

    private void placePiecesForPlayer(int player){
        /* places all pieces on one side of the board for a specific player */
        int animalRow = (player == 1) ? 0 : 6;
        int pawnRow = (player == 1) ? 1 : 5;

        /* Create and setup animal game pieces for player */
        board[animalRow][0] = new GiraffePiece(animalRow, 0, player);
        board[animalRow][1] = new MonkeyPiece(animalRow,1,player);
        board[animalRow][2] = new ElephantPiece(animalRow,2,player);
        board[animalRow][3] = new LionPiece(animalRow,3,player);
        board[animalRow][4] = new ElephantPiece(animalRow,4,player);
        board[animalRow][5] = new CrocodilePiece(animalRow,5, player);
        board[animalRow][6] = new ZebraPiece(animalRow, 6, player);

        /* need to initialize all pawns */
        for (int i =0; i<=6; i++){
            board[pawnRow][i] = new PawnPiece(pawnRow, i, player);
        }
    }

>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c

    /**
    Returns the player at the given position. Returns null if position is out of bounds
    @param row of position
    @param col of position
    */
    public GamePiece getGamePiece(int row, int col){
        if(inBounds(row, col)){
            return board[row][col];
        }
        else return null;
    }

    /**
    Places pieces for the given player for initial board set up
    @param player (either 1 or 2)
    */
    private void placePiecesForPlayer(int player){
        /* places all pieces on one side of the board for a specific player */
        int animalRow = (player == 1) ? 0 : 6;
        int pawnRow = (player == 1) ? 1 : 5;

        /* Create and setup animal game pieces for player */
        board[animalRow][0] = new GiraffePiece(animalRow, 0, player);
        board[animalRow][1] = new MonkeyPiece(animalRow,1,player);
        board[animalRow][2] = new ElephantPiece(animalRow,2,player);
        board[animalRow][3] = new LionPiece(animalRow,3,player);
        board[animalRow][4] = new ElephantPiece(animalRow,4,player);
        board[animalRow][5] = new CrocodilePiece(animalRow,5, player);
        board[animalRow][6] = new ZebraPiece(animalRow, 6, player);

        /* need to initialize all pawns */
        for (int i =0; i<=6; i++){
            board[pawnRow][i] = new PawnPiece(pawnRow, i, player);
        }
    }


    /**
    Finds all the pieces the given player has in the river (crocodile is excluded)
    @param player whose turn it is (either 1 or 2)
    */
    public ArrayList<GamePiece> getRiverDwellers(int activePlayer){
        ArrayList<GamePiece> riverDwellers = new ArrayList<GamePiece>();
<<<<<<< HEAD
        
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
        for (int i = 0; i < NUM_COLUMNS; i++){
            GamePiece piece = getGamePiece(RIVER_ROW,i);
            if ((piece != null ) && (piece.player == activePlayer) && !(piece instanceof CrocodilePiece)){
                riverDwellers.add(piece);
            }
        }
         return riverDwellers;
    }

    /**
    Drowns all pieces that stayed in the river longer than a single turn
    @param list of all pieces that were in the river at the start of the turn
    */
    public void drownRiverDwellers(ArrayList<GamePiece> listRiverDwellers){
        ListIterator listIter = listRiverDwellers.listIterator();

        while(listIter.hasNext()){
            GamePiece dweller = (GamePiece) listIter.next();
            if (dweller.inRiver()){
                board[dweller.getRow()][dweller.getColumn()] = null;
            }
        }
    }
    
<<<<<<< HEAD
    /**
    Checks if the given position (row, col) is valid on the board
    @param row of desired square
    @param column of desired square
    */
    public static boolean inBounds(int row, int col){
=======
    public boolean inBounds(int row, int col){
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
        return row < NUM_ROWS && row >= 0 && col < NUM_COLUMNS && col >= 0;
    }

    /**
    Moves the given piece to the given position (row, col). If the position is out of bounds, the piece isn't moved
    @param piece to move
    @param row of square to move to
    @param column of square to move to
    */
    public void movePiece(GamePiece piece, int row, int col) {
        if(inBounds(row, col)){
            int startingRow = piece.getRow();
            int startingCol = piece.getColumn();
            piece.row = row;
            piece.column = col;
            board[row][col] = piece;
            board[startingRow][startingCol] = null;
        }
<<<<<<< HEAD
    }

    /**
    Gets the piece at position (fromRow, fromCol) and moves it to (toRow, toCol) if the position is valid. If the piece is a pawn, it checks to see if it has become a super pawn.
    Does no error checking and assumes the move is legal
    @param row of piece to move
    @param col of piece to move
    @param row of square to move to
    @param col of square to move to
=======

    }

    /**
        routine does NO error checking but assumes move is legal and updates the piece's info as well as set it's previous square location to NULL
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    */
    public void movePiece(int fromRow, int fromCol, int toRow, int toCol){
        GamePiece movingPiece = getGamePiece(fromRow,fromCol);

        movePiece(movingPiece, toRow, toCol);
        
        if(movingPiece instanceof PawnPiece){
            checkForSuperPawn(movingPiece);
        }
    }
    
<<<<<<< HEAD
    /**
    Checks if the pawn needs to be declared a super pawn
    @param piece to check for super pawn
    */
=======
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
    public void checkForSuperPawn(GamePiece piece){
        //If the pawn reaches the other side of the board, it's a super pawn
        if ( (piece.getPlayer() == 1 && piece.getRow() == 6 ) || (piece.getPlayer() == 2 && piece.getRow() == 0 )) {
            PawnPiece pawn = (PawnPiece) piece;
            pawn.superPawn = true;
        }
    }

    /**
    Captures the given piece and removes it from the board
    */
    public void capturePiece(GamePiece pieceToBeCaptured){
<<<<<<< HEAD
=======
        // remove the piece from the board
>>>>>>> c7b58d0539f2dd4115144a153c81334d34b0947c
        board[pieceToBeCaptured.row][pieceToBeCaptured.column] = null;
    }
}
