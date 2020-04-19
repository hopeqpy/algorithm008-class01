package three;

/**
 * @program: algorithm
 * @description: 加一
 * @author: qpy
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i =  digits.length - 1; i >= 0; i--) {
            digits[i]++;
            int factNum = digits[i] % 10;
            if (factNum != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
