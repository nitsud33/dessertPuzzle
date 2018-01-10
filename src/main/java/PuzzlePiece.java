import java.util.ArrayList;
import java.util.List;

public class PuzzlePiece {

    List<Integer> sides = new ArrayList<Integer>(4);


    public static boolean matchSide(PuzzlePiece left, PuzzlePiece right){
        if (matchInteger(left.getRight(), right.getLeft())){
            return true;
        }
        return false;
    }
    public static boolean matchUp(PuzzlePiece up, PuzzlePiece down){
        if (matchInteger(up.getDown(), down.getUp())){
            return true;
        }
        return false;
    }

    public PuzzlePiece(int up, int right, int down, int left) {
        sides.add(up);
        sides.add(right);
        sides.add(down);
        sides.add(left);
    }

    public boolean matchLeft(PuzzlePiece left){
        return matchSide(left, this);
    }

    public boolean matchUp(PuzzlePiece up){
        return matchUp(up, this);
    }

    public static <T> List<T> rotate(List<T> aL, int shift)
    {
        if (aL.size() == 0)
            return aL;

        T element = null;
        for(int i = 0; i < shift; i++)
        {
            // remove last element, add it to front of the ArrayList
            element = aL.remove( aL.size() - 1 );
            aL.add(0, element);
        }

        return aL;
    }

    public void rotateClockWise(){
        sides = rotate(sides, 1);
    }
    public void rotateCounterClockWise(){
        sides = rotate(sides, 3);
    }

    public Integer getLeft(){
        return sides.get(3);
    }
    public Integer getUp() {
        return sides.get(0);
    }
    public Integer getRight() {
        return sides.get(1);
    }
    public Integer getDown() {
        return sides.get(2);
    }

    private static boolean matchInteger(int a, int b){
        if (a == 1 && b == 8 || a == 8 && b == 1){
            return true;
        }
        if (a == 2 && b == 7 || a == 7 && b == 2){
            return true;
        }
        if (a == 3 && b == 6 || a == 6 && b == 3){
            return true;
        }
        if (a == 4 && b == 5 || a == 5 && b == 4){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof PuzzlePiece){
            PuzzlePiece rhs = (PuzzlePiece) object;
            for(int i = 0; i < 4; i++){
                if (rhs.getUp() == this.getUp() &&
                    rhs.getLeft() == this.getLeft() &&
                    rhs.getDown() == this.getDown() &&
                    rhs.getRight() == this.getRight()){
                    return true;
                }
                rhs.rotateClockWise();
            }
        }
        return false;
    }
}

