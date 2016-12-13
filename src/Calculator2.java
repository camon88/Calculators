import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator2
{
    public static final int SIZE = 340;
    private JFrame calculatorFrame;
    private JTextField infixExpression;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton clearButton;


    /**
     * Constructor for the calc.
     */

    public Calculator2()
    {
        calculatorFrame = new JFrame();

        calculatorFrame.setLocation(SIZE / 2, SIZE / 2);

        calculatorFrame.setSize(SIZE, SIZE);

        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setTitle("Calculator");

        initializeComponents();
        calculatorFrame.setVisible(true);
    }

    /**
     * getter for the JFrame.
     * @return JFrame 
     */

    public JFrame getFrame()
    {
        return calculatorFrame;
    }

    /**
     * Helper method to  add the panels onto the calculatorFrame.
     */

    public void initializeComponents()
    {
        addExpressionPanel();
        addResultPanel();
    }

    /**
     * Adds a text box.
     */

    public void addExpressionPanel()
    {
        JPanel expressionPanel = new JPanel();

        expressionPanel.setName("expressionPanel");

        infixExpression = new JTextField(15);
       
        infixExpression.setName("infixExpression");

        expressionPanel.add(infixExpression, BorderLayout.LINE_START);
        calculateButton = new JButton("Calculate");

        clearButton = new JButton("Clear");

        calculateButton.setName("calculateButton");
        clearButton.setName("clearButton");

        expressionPanel.add(calculateButton, BorderLayout.EAST);
       
        expressionPanel.add(clearButton, BorderLayout.WEST);


        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                String s = infixExpression.getText();

                ExpressionEvaluator eval = new ExpressionEvaluator();
                s = eval.toPostfix(s);

                double answer = eval.evaluate(s);
                if (answer == -Math.PI)
                {
                    resultLabel.setText("Result = Error");
                }
                else
                {
                    resultLabel.setText("Result = " + answer);
                }
            }

        });

        clearButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent event)
            {
                infixExpression.setText("");
            }

        });


        calculatorFrame.add(expressionPanel, BorderLayout.PAGE_START); 
    }

    /**
     * Adds the result panel onto the calculatorFrame.
     */

    public void addResultPanel()
    {
        JPanel resultPanel = new JPanel();
        resultPanel.setName("resultPanel");

        resultLabel = new JLabel("Result = ");

        resultLabel.setName("resultLabel");

        resultPanel.add(resultLabel);


        calculatorFrame.add(resultPanel, BorderLayout.PAGE_END);
    }

    /**
     * Main method to create the calc.
     * @param args the arguments passed into the main method.
     */

    public static void main(String[] args)
    {


        Calculator2 c = new Calculator2();
    }

}