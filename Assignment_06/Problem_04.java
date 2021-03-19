package Assignment_06;

import java.util.ArrayList;
import java.util.List;

public class Problem_04 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        generateParenthesis(n, n, "", result);
        return result;
    }

    private void generateParenthesis(int open, int close, String paranthesis, List<String> answer) {
        if (open == 0) {
            while (close-- != 0) {
                paranthesis += ")";
            }
            answer.add(paranthesis);
            return;
        }
        if (open == close) {
            paranthesis += "(";
            generateParenthesis(open - 1, close, new String(paranthesis), answer);
        } else {
            String openCurrent = paranthesis + "(";
            generateParenthesis(open - 1, close, openCurrent, answer);
            String closeCurrent = paranthesis + ")";
            generateParenthesis(open, close - 1, closeCurrent, answer);
        }
    }
}
