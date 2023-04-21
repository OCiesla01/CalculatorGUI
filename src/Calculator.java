import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton,
            decimalButton, equalButton, deleteButton, clearButton, negativeButton;
    JPanel mainPanel, numbersPanel;
    double num1, num2, result;
    char operator;
    Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Calculator");

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0,400, 600);
        mainPanel.setBackground(new Color(0xB7B7B7));
        mainPanel.setOpaque(true);
        mainPanel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(0, 0, 400, 60);
        textField.setFont(new Font("Roboto", Font.PLAIN, 50));
        textField.setBackground(new Color(0xCDCDCD));
        textField.setOpaque(true);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        textField.setEditable(false);

        numbersPanel = new JPanel();
        numbersPanel.setBounds(0, 195, 290, 400);
        numbersPanel.setBackground(new Color(0xB7B7B7));
        numbersPanel.setOpaque(true);
        numbersPanel.setLayout(new FlowLayout());

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("+/-");

        functionButtons[0] = addButton;
        addButton.setBounds(22, 110, 65, 65);
        functionButtons[1] = subtractButton;
        subtractButton.setBounds(112, 110, 65, 65);
        functionButtons[2] = multiplyButton;
        multiplyButton.setBounds(202, 110, 65, 65);
        functionButtons[3] = divideButton;
        divideButton.setBounds(292, 110, 65, 65);
        functionButtons[4] = decimalButton;
        decimalButton.setBounds(292, 478, 65, 65);
        functionButtons[5] = equalButton;
        equalButton.setBounds(292, 388, 65, 65);
        functionButtons[6] = deleteButton;
        deleteButton.setBounds(292, 298, 65, 65);
        functionButtons[7] = clearButton;
        clearButton.setBounds(292, 208, 65, 65);
        functionButtons[8] = negativeButton;
        negativeButton.setBounds(204, 478, 65, 65);

        for (JButton b : functionButtons) {
            b.setFocusable(false);
            b.setBackground(new Color(0xB0B0B0));
            b.setFont(new Font("Roboto", Font.PLAIN, 15));
            b.setBorder(BorderFactory.createLineBorder(new Color(0x989898), 2));
            b.setOpaque(true);
            b.addActionListener(this);
            mainPanel.add(b);
        }



        for(int i = 1; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(new Font("Roboto", Font.PLAIN, 25));
            numberButtons[i].setBackground(new Color(0xA1A1A1));
            numberButtons[i].setBorder(BorderFactory.createLineBorder(new Color(0x818181), 2));
            numberButtons[i].setOpaque(true);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setPreferredSize(new Dimension(85, 85));
            numbersPanel.add(numberButtons[i]);
        }
        numberButtons[0] = new JButton(String.valueOf(0));
        numberButtons[0].setFocusable(false);
        numberButtons[0].setFont(new Font("Roboto", Font.PLAIN, 25));
        numberButtons[0].setBackground(new Color(0xA1A1A1));
        numberButtons[0].setBorder(BorderFactory.createLineBorder(new Color(0x818181), 2));
        numberButtons[0].setOpaque(true);
        numberButtons[0].addActionListener(this);
        numberButtons[0].setPreferredSize(new Dimension(85, 85));
        numbersPanel.add(numberButtons[0]);

        mainPanel.add(numbersPanel);

        this.add(mainPanel);
        this.add(textField);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clearButton) {
            num1 = 0;
            num2 = 0;
            operator = ' ';
            textField.setText("");
        }
        if(e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
