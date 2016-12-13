import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Calculator class for simple Calc.
 * @author jw76577
 * @version 1
 */
public class Calculator
{
    private static final int NONMAGIC = 120;
    private static final int NONMAGIC2 = 420;
    private JFrame frame = new JFrame();
    private JPanel calcButtonPanel;
    private JPanel textFieldPanel;
    private JTextField leftOperand = new JTextField(10);
    private JTextField rightOperand = new JTextField(10);
    private JLabel resultLabel = new JLabel("Result =");
    private JPanel resultPanel = new JPanel();
    private JButton addButton;
  

    /**
     * Constructor.  
     */
    public Calculator()
    {
        calcFrame();
    }


    /**
     * Creates the Frame of Calc.
     */
    public void calcFrame()
    {

        frame = new JFrame();
        frame.setLocation(NONMAGIC, NONMAGIC);
        frame.setSize(NONMAGIC2, NONMAGIC2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple Calculator");
        calcButtonsAndPanel();
        resultsPanel();
        textFieldPanel();
        frame.pack();
        frame.setVisible(true);




    }

    /**
     * This is the button and panel creation.
     */
    public void calcButtonsAndPanel()
    {

        calcButtonPanel = new JPanel();
        addButton = new JButton("ADD");
        JButton subButton = new JButton("SUB");
        JButton multButton = new JButton("MULT");
        JButton divButton = new JButton("DIV");

        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");

        calcButtonPanel.add(addButton);
        calcButtonPanel.add(subButton);
        calcButtonPanel.add(multButton);
        calcButtonPanel.add(divButton);



        frame.add(calcButtonPanel, BorderLayout.PAGE_END);


        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String string1 = leftOperand.getText();
                    String string2 = rightOperand.getText();
                    double value1 = Double.parseDouble(string1);
                    double value2 = Double.parseDouble(string2);
                    double solution = value1 + value2;
                    resultLabel.setText(
                        "Result = " + Double.toString(solution));
                }
                catch (NumberFormatException nfe)
                {
                    resultLabel.setText("Result = Error");
                }
            }
        });

        subButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String string1 = leftOperand.getText();
                    String string2 = rightOperand.getText();
                    double value1 = Double.parseDouble(string1);
                    double value2 = Double.parseDouble(string2);
                    double solution = value1 - value2;
                    resultLabel.setText(
                        "Result = " + Double.toString(solution));
                }
                catch (NumberFormatException nfe)
                {
                    resultLabel.setText("Result = Error");
                }
            }
        });

        multButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String string1 = leftOperand.getText();
                    String string2 = rightOperand.getText();
                    double value1 = Double.parseDouble(string1);
                    double value2 = Double.parseDouble(string2);



                    double solution = value1 * value2;
                    resultLabel.setText(
                        "Result = " + Double.toString(solution));
                }
                catch (NumberFormatException nfe)
                {
                    resultLabel.setText("Result = Error");
                }

            }

        });

        divButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String string1 = leftOperand.getText();
                    String string2 = rightOperand.getText();
                    double value1 = Double.parseDouble(string1);
                    double value2 = Double.parseDouble(string2);
                    if (value2 != 0)
                    {
                        double solution = value1 / value2;

                        resultLabel.setText(
                            "Result = " + Double.toString(solution));
                    }
                    else
                    {
                        resultLabel.setText("Result = Error");
                    }
                }
                catch (NumberFormatException nfe)
                {
                    resultLabel.setText("Result = Error");
                }

            }
        });




    }
/**
 * results panel creation.
 */
    public void resultsPanel()
    {
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.LINE_START);
    }
/**
 * text panel creation area.
 */
    public void textFieldPanel()
    {
        textFieldPanel = new JPanel();
        leftOperand.setName("leftOperand");
        rightOperand.setName("rightOperand");
        textFieldPanel.add(leftOperand);
        textFieldPanel.add(rightOperand);

        frame.add(textFieldPanel, BorderLayout.PAGE_START);



    }
/**
 * Returns the frame.
 * @return frame.
 */
    public JFrame getFrame()
    {
        return frame;
    }
/**
 * main method to run the calculator.
 * @param args is the arguments.
 */
    public static void main(String args[])
    {
        Calculator calc = new Calculator();
      

    }




}
