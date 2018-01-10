import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    public void start(){
        Generator gen = new Generator();
        List<PuzzlePiece> pieces = gen.generateBoard();

        PuzzlePiece originPiece = pieces.remove(0);

        List<PuzzlePiece> unusedPieces = pieces.subList(0, pieces.size() -1);
        PuzzlePiece workingPiece = unusedPieces.remove(0);
        for (int i = 0; i < 4; i++) {
            if (workingPiece.matchLeft(originPiece)) {

            } else {
                workingPiece.rotateClockWise();
            }
        }
        // no match
    }

    public static List<PuzzlePiece> placeNext(List<PuzzlePiece> placedPieces, List<PuzzlePiece> unPlacedPieces){
        List<PuzzlePiece> answer = new ArrayList<PuzzlePiece>();

        for (int i = 0; i < unPlacedPieces.size(); i++) {
            PuzzlePiece workingPiece = unPlacedPieces.remove(0);
            for (int j = 0; j < 4; j++) {
                if (placedPieces.size() == 0){
                    placedPieces.add(workingPiece);
                    answer = placeNext(placedPieces, unPlacedPieces);
                    if (answer != null){
                        return answer;
                    }
                    placedPieces.remove(workingPiece);
                }
                if (placedPieces.size() == 1 || placedPieces.size() == 2){
                    if (workingPiece.matchLeft(placedPieces.get(placedPieces.size()-1))) {
                        placedPieces.add(workingPiece);
                        if (unPlacedPieces.size() == 0){
                            return placedPieces;
                        }
                        answer = placeNext(placedPieces, unPlacedPieces);
                        if (answer != null){
                            return answer;
                        }
                        placedPieces.remove(workingPiece);
                    }
                }
                if (placedPieces.size() == 3 || placedPieces.size() == 6){
                    if (workingPiece.matchUp(placedPieces.get(placedPieces.size() - 3))) {
                        placedPieces.add(workingPiece);
                        if (unPlacedPieces.size() == 0){
                            return placedPieces;
                        }
                        answer = placeNext(placedPieces, unPlacedPieces);
                        if (answer != null){
                            return answer;
                        }
                        placedPieces.remove(workingPiece);
                    }
                }
                if (placedPieces.size() == 4 || placedPieces.size() == 5 || placedPieces.size() == 7 || placedPieces.size() == 8){
                    if (workingPiece.matchUp(placedPieces.get(placedPieces.size() - 3)) && workingPiece.matchLeft(placedPieces.get(placedPieces.size() - 1))) {
                        placedPieces.add(workingPiece);
                        if (unPlacedPieces.size() == 0){
                            return placedPieces;
                        }
                        answer = placeNext(placedPieces, unPlacedPieces);
                        if (answer != null){
                            return answer;
                        }
                        placedPieces.remove(workingPiece);
                    }
                }
                workingPiece.rotateClockWise();
            }
            unPlacedPieces.add(workingPiece);
        }
        return null;
    }

//    public static List<List<PuzzlePiece>> placeNext2(List<PuzzlePiece> placedPieces, List<PuzzlePiece> unPlacedPieces){
//        List<List<PuzzlePiece>> answer;
//
//        for (int i = 0; i < unPlacedPieces.size(); i++) {
//            PuzzlePiece workingPiece = unPlacedPieces.remove(0);
//            for (int j = 0; j < 4; j++) {
//                if (placedPieces.size() == 0){
//                    placedPieces.add(workingPiece);
//                    answer = placeNext2(placedPieces, unPlacedPieces);
//                    if (answer != null){
//                        return answer;
//                    }
//                    placedPieces.remove(workingPiece);
//                }
//                if (placedPieces.size() == 1 || placedPieces.size() == 2){
//                    if (workingPiece.matchLeft(placedPieces.get(placedPieces.size()-1))) {
//                        placedPieces.add(workingPiece);
//                        if (unPlacedPieces.size() == 0){
//                            return placedPieces;
//                        }
//                        answer = placeNext2(placedPieces, unPlacedPieces);
//                        if (answer != null){
//                            return answer;
//                        }
//                        placedPieces.remove(workingPiece);
//                    }
//                }
//                if (placedPieces.size() == 3 || placedPieces.size() == 6){
//                    if (workingPiece.matchUp(placedPieces.get(placedPieces.size() - 3))) {
//                        placedPieces.add(workingPiece);
//                        if (unPlacedPieces.size() == 0){
//                            return placedPieces;
//                        }
//                        answer = placeNext2(placedPieces, unPlacedPieces);
//                        if (answer != null){
//                            return answer;
//                        }
//                        placedPieces.remove(workingPiece);
//                    }
//                }
//                if (placedPieces.size() == 4 || placedPieces.size() == 5 || placedPieces.size() == 7 || placedPieces.size() == 8){
//                    if (workingPiece.matchUp(placedPieces.get(placedPieces.size() - 3)) && workingPiece.matchLeft(placedPieces.get(placedPieces.size() - 1))) {
//                        placedPieces.add(workingPiece);
//                        if (unPlacedPieces.size() == 0){
//                            return placedPieces;
//                        }
//                        answer = placeNext2(placedPieces, unPlacedPieces);
//                        if (answer != null){
//                            return answer;
//                        }
//                        placedPieces.remove(workingPiece);
//                    }
//                }
//                workingPiece.rotateClockWise();
//            }
//            unPlacedPieces.add(workingPiece);
//        }
//        return null;
//    }

}
