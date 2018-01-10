import java.util.ArrayList;
import java.util.List;

/**
 * Created by dustinbixler on 6/7/17.
 */
public class Generator {

    public List<PuzzlePiece> generateBoard(){
        List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
        pieces.add(new PuzzlePiece(1,7,3,2));
        pieces.add(new PuzzlePiece(1,7,2,4));
        pieces.add(new PuzzlePiece(8,2,5,3));
        pieces.add(new PuzzlePiece(7,2,5,6));
        pieces.add(new PuzzlePiece(8,5,5,2));
        pieces.add(new PuzzlePiece(8,5,6,3));
        pieces.add(new PuzzlePiece(1,8,4,3));
        pieces.add(new PuzzlePiece(1,4,6,7));
        pieces.add(new PuzzlePiece(1,2,5,3));
        return pieces;
    }
}
