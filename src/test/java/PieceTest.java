
import org.junit.Test;

import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.*;


public class PieceTest {


    @Test
    public void pieceTest(){
        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(8,2,3,4);
        assertFalse(PuzzlePiece.matchSide(one, two));
        assertFalse(PuzzlePiece.matchSide(two, one));
        assertFalse(PuzzlePiece.matchUp(one, two));
        assertFalse(PuzzlePiece.matchUp(two, one));

        two.rotateClockWise();
        assertFalse(PuzzlePiece.matchSide(one, two));
        assertFalse(PuzzlePiece.matchSide(two, one));
        assertFalse(PuzzlePiece.matchUp(one, two));
        assertFalse(PuzzlePiece.matchUp(two, one));

    }

    @Test
    public void pieceTestWithRotate(){
        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(8,2,3,4);
        two.rotateClockWise();
        two.rotateClockWise();

        assertTrue(PuzzlePiece.matchUp(two, one));

        assertFalse(PuzzlePiece.matchSide(one, two));
        assertFalse(PuzzlePiece.matchSide(two, one));
        assertFalse(PuzzlePiece.matchUp(one, two));
    }

    @Test
    public void pieceBoardWithTwoPieces(){
        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(8,2,3,4);
        List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
        pieces.add(one);
        pieces.add(two);
        List<PuzzlePiece> answer = new ArrayList<PuzzlePiece>();
        answer.add(one);
        answer.add(two);
        assertEquals(answer, Puzzle.placeNext(new ArrayList<PuzzlePiece>(), pieces));
    }

    @Test
    public void pieceBoardWithTwoPieces1(){
        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(7,2,3,4);
        List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
        pieces.add(one);
        pieces.add(two);
        List<PuzzlePiece> answer = new ArrayList<PuzzlePiece>();
        answer.add(one);
        answer.add(two);
        assertEquals(answer, Puzzle.placeNext(new ArrayList<PuzzlePiece>(),pieces));
    }

    @Test
    public void pieceBoardWithThreePieces(){
        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(8,2,3,4);
        PuzzlePiece three = new PuzzlePiece(6,2,3,4);
        List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
        pieces.add(one);
        pieces.add(two);
        pieces.add(three);
        List<PuzzlePiece> answer = new ArrayList<PuzzlePiece>();
        answer.add(one);
        answer.add(two);
        answer.add(three);
        assertEquals(answer, Puzzle.placeNext(new ArrayList<PuzzlePiece>(), pieces));
    }

    @Test
    public void pieceBoardWithThreePiecesAndTwoAnswers(){
        List<Map<String, Object>> coupons = new ArrayList<Map<String, Object>>();
        List<String> preferredCategories = new ArrayList<String>();

        PuzzlePiece one = new PuzzlePiece(1,2,3,4);
        PuzzlePiece two = new PuzzlePiece(8,4,1,4);
        PuzzlePiece three = new PuzzlePiece(8,2,1,2);
        List<PuzzlePiece> pieces = new ArrayList<PuzzlePiece>();
        pieces.add(one);
        pieces.add(two);
        pieces.add(three);
        List<PuzzlePiece> answer1 = new ArrayList<PuzzlePiece>();
        answer1.add(one);
        answer1.add(two);
        answer1.add(three);
        List<PuzzlePiece> answer2 = new ArrayList<PuzzlePiece>();
        answer2.add(one);
        answer2.add(three);
        answer2.add(two);
//        List<List<PuzzlePiece>> answer = Puzzle.placeNext2(new ArrayList<PuzzlePiece>(), pieces);
//        answer.stream().filter()
//        System.out.println(answer.contains(answer1));
//        System.out.println(answer.contains(answer2));
    }

    @Test
    public void totalTest(){
        Generator gen = new Generator();
        List<PuzzlePiece> pieces = gen.generateBoard();
        // full answer
        List<PuzzlePiece> answer = Puzzle.placeNext(new ArrayList<PuzzlePiece>(), pieces);
        System.out.println(answer);

    }


}
