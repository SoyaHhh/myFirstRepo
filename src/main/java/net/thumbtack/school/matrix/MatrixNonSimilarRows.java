package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> map = new HashMap<>();
        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int anInt : ints) {
                set.add(anInt);
            }
            map.put(set, ints);
        }
        return new ArrayList<>(map.values());
    }
}
