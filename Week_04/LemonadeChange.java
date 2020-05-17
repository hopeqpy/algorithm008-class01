import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @program: algorithm
 * @description: 柠檬水找零
 * @author: qpy
 */
public class LemonadeChange {


    public boolean lemonadeChange(int[] bills) {
        if (bills == null && bills.length == 0) {
            return false;
        }
        int fiveNumber = 0;
        int tenNumber = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNumber++;
            }
            if (bills[i] == 10) {
                tenNumber++;
                fiveNumber--;
            }
            if (bills[i] == 20) {
                if (tenNumber > 0 && fiveNumber >= 0) {
                    fiveNumber--;
                    tenNumber--;
                } else if (fiveNumber > 3) {
                    fiveNumber = fiveNumber - 3;
                }else{
                    return false;
                }
            }
            if (fiveNumber < 0) {
                return false;
            }
            if (tenNumber < 0) {
                return false;
            }
        }
        return true;
    }
}
