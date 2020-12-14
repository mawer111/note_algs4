package study.ss.book.algs4.section2;

import study.ss.book.algs4.struct.Stack;

public class Evaluate {

    public static void main(String[] args) {

        String express = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] s = express.split(" ");

        Stack<String> stack = new Stack<String>();
        Stack<Double> valueStack = new Stack<Double>();
        for (int i = 0; i < s.length; i++) {
            String c = s[i];
            if (c.equals("(")) stack.push(c);
            else if (c.equals("+")) stack.push(c);
            else if (c.equals("-")) stack.push(c);
            else if (c.equals("*")) stack.push(c);
            else if (c.equals("/")) stack.push(c);
            else if (c.equals(")")){
                Double pop = valueStack.pop();
                String op = stack.pop();
                Double pop1 = valueStack.pop();
                String pop2 = stack.pop();
                if (op.equals("+")) valueStack.push(pop + pop1);
                if (op.equals("-")) valueStack.push(pop1 - pop);
                if (op.equals("*")) valueStack.push(pop * pop1);
                if (op.equals("/")) valueStack.push(pop1 / pop);
            } else valueStack.push(Double.valueOf(c));
        }
        System.out.println(valueStack.pop());
    }


}
