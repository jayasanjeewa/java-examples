package com.example.algo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class WordBoardMatrix {
    public static void main(String[] args) {
        WordBoardMatrix wordBoardMatrix = new WordBoardMatrix();

        System.out.println(wordBoardMatrix.isWordExists("ABCCED"));
        System.out.println(wordBoardMatrix.isWordExists("SEE"));
        System.out.println(wordBoardMatrix.isWordExists("ABCB"));

    }

    private boolean isWordExists(String word) {
        char [] [] board = getBoardWithLetters();

        boolean isExist = false;

        Map<Integer, List<Position>> boardMap = createBoardMap(board, 3, 4);

        List<Position> list = boardMap.get(word.charAt(0) - 'A');

        if (list == null) {
            return false;
        }

        for (Position p : list) {
            p.traversed = true;
            if (isSubWordExists(word.substring(1), boardMap, p)) {
                return true;
            }
            p.traversed = false;
        }



        return  isExist;
    }

    private boolean isSubWordExists(String substring, Map<Integer, List<Position>> boardMap, Position position) {
        if ("".equals(substring)) {
            return true;
        }

        List<Position> list = boardMap.get(substring.charAt(0) - 'A');

        if ( list == null ) {
            return false;
        }

        if (substring.length() == 1) {
            for (Position neigPos : list) {
                if (neigPos.traversed) {
                    continue;
                }

                if (position.x == neigPos.x) {
                    if (Math.abs(position.y - neigPos.y) == 1) {
                        return true;
                    }
                } else if(position.y == neigPos.y) {
                    if (Math.abs(position.x - neigPos.x) == 1) {
                        return true;
                    }
                }
            }
            return false;


        } else {
            for( Position negPosi : list) {
                    negPosi.traversed = true;

                    if(isSubWordExists(substring.substring(1), boardMap, negPosi)) {
                        return true;
                    }

                    negPosi.traversed = false;
            }
        }

        return false;
    }

    private char[][] getBoardWithLetters() {
        char board[][] = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}
        };


        return board;
    }

    private Hashtable<Integer, List<Position>> createBoardMap(char [][] board, int height, int width) {
        Hashtable<Integer, List<Position>> boardMap = new Hashtable<>(26);

        for (int i = 0 ; i < height; i++ ) {
            for (int j =0 ; j <width; j++) {
                List list = boardMap.get(board[i][j] - 'A');
              if (list == null) {
                  list = new ArrayList();
                  boardMap.put(board[i][j] - 'A', list);
              }

              list.add(new Position(i, j));
            }
        }

        return  boardMap;
    }

    class Position {
        int x;
        int y;
        boolean traversed;

        public  Position(int x, int y) {
            this.x = x;
            this.y = y;
            this.traversed = false;
        }
    }

}
