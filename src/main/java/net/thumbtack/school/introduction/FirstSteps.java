package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int sumArray = 0;
        // REVU неудачное имя. Это не индекс
        // for(int elem, например
        // здесь и везде
        for (int elem : array)
            sumArray = +sum(sumArray, elem);
        return sumArray;
    }

    public int mul(int[] array) {
        int mul = 1;
        if (isEqual(array.length, 0))
            return 0;
        for (int elem : array)
            mul = +mul(mul, elem);
        return mul;
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int elem : array)
            if (isGreater(min, elem))
                min = elem;
        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int elem : array)
            if (isGreater(elem, max))
                max = elem;
        return max;
    }

    public double average(int[] array) {
        if (isEqual(array.length, 0))
            return 0;
        return sum(array) / (double) array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] <= array[i])
                return false;
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++)
            // REVU *= быстрее
            array[i] *= array[i] * array[i];
    }

    public boolean find(int[] array, int value) {
        // REVU for each
        for (int j : array)
            if (isEqual(j, value))
                return true;
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++)
            if (array[i] != array[array.length - i - 1])
                return false;
        return true;
    }

    public int sum(int[][] matrix) {
        int sumArray = 0;
        for (int[] ints : matrix)
            // REVU вызовите sum для линейного массива
            for (int j : ints)
                sumArray += j;
        return sumArray;
    }

    public int max(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        for (int[] i : matrix)
            // REVU вызовите max для линейного массива
            for (int elem : i)
                if (result < elem)
                    result = elem;
        return result;
    }

    public int diagonalMax(int[][] matrix) {
        int diagonalMax = Integer.MIN_VALUE;
        if (isEqual(matrix[0].length, 0))
            return diagonalMax;
        // REVU двойной цикл не нужен
        for (int i = 0; i < matrix.length; i++)
            if (diagonalMax < matrix[i][i])
                diagonalMax = matrix[i][i];
        return diagonalMax;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] array : matrix)
            if (!isSortedDescendant(array))
                return false;
        return true;
    }
}