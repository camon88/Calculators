import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * @author ???
 * @version ???
 * 
 */
public class ExpressionEvaluator
{ public static final Pattern UNSIGNED_DOUBLE =
        Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    Stack<Character> stack = new Stack<Character>();

    char symbol;
    private String postfixExpression = "";




/**
 * Takes an infix expression and converts it to postfix.
 * 
 * @param expression
 *            The infix expression.
 * @return the postfix expression.
 */
    public String toPostfix(String expression)
    {
    // ... other local variables
        Scanner input = new Scanner(expression);
        String next;

        char symbol;

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {

                next = input.findInLine(UNSIGNED_DOUBLE);
                postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);
                if (symbol == '(')
                {
                    stack.push(symbol);
                }
                else if (symbol == '+' || symbol == '-'
                    || symbol == '*' || symbol == '/')
                {

                    while (!stack.isEmpty() && stack.peek() != '(' 
                        && !higherP(stack.peek(), symbol))
                    {

                        postfixExpression += stack.pop() + " ";

                    }


                    stack.push(symbol);

                }
                else if (symbol == ')')
                {

                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        postfixExpression += stack.pop() + " ";
                    }
                    stack.pop();
                }   
                else
                {
                    throw new IllegalArgumentException("error");

                }




            }   
        }
        while (!stack.isEmpty())
        {
            postfixExpression += stack.pop() + " ";
        }
        return postfixExpression;
    }

/**
 * Evaluates a postfix expression and returns the result.
 * 
 * @param postfixExpression
 *            The postfix expression.
 * @return The result of the expression.
 */
    public double evaluate(String postfixExpression)
    {
    // other local variables you may need
        Scanner input = new Scanner(postfixExpression);
        String next;
        double number1;
        double number2;


        Stack<Double> numbers = new Stack<Double>();




        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                numbers.push(new Double(next));
            }
            else
            {
                next = input.findInLine(CHARACTER);

                number2 = numbers.pop();
                number1 = numbers.pop();


                if (next.charAt(0) == '+')
                {

                    numbers.push(number1 + number2);
                }
                else if (next.charAt(0) == '-')
                {

                    numbers.push(number1 - number2);
                }
                else if (next.charAt(0) == '*')
                {

                    numbers.push(number1 * number2);
                }
                else if (next.charAt(0) == '/')
                {

                    numbers.push(number1 / number2);
                }
                else
                {

                    throw new IllegalArgumentException("Illegal Operation.");
                }
            }
        }   

        return numbers.pop();

    }

   
/**
 * 
 * @param operation1 is first operation.
 * @param operation2 is second operation.
 * @return boolean true or false.
 */
    public boolean higherP(char operation1, char operation2)
    {
        return ((operation1 == '+' || operation1 == '-') 
            && (operation2 == '*' || operation2 == '/')); 
    }
}