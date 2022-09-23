import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Window extends JFrame {
    JButton[] numButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JTextField textField = new JTextField();
    float num1;
    float num2;
    char operator;
    public Window () {

        setBounds(400,300,600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        textField.setBounds(40,25,500,50);
        add(textField);
        textField.setEditable(false);
        textField.setText("0");

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
        }

        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("*");
        functionButtons[3] = new JButton("/");
        functionButtons[4] = new JButton("=");
        functionButtons[5] = new JButton(".");
        functionButtons[6] = new JButton("clear");
        functionButtons[7] = new JButton("delete");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,6,4,4));
        panel.setBounds(40,100,500,325);
        add (panel);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(functionButtons[0]);
        panel.add(functionButtons[1]);
        panel.add(functionButtons[4]);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[3]);
        panel.add(functionButtons[6]);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(numButtons[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[7]);

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i].addActionListener(this::actionPerformed);
        }

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this::actionPerformed);
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                if (textField.getText().equals("0")) {
                    textField.setText("");
                }
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == functionButtons[0]) {
            if (textField.getText().equals("Infinity")) {
                textField.setText("0");
            }
            num1 = Float.parseFloat(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[1]) {
            if (textField.getText().equals("Infinity")) {
                textField.setText("0");
            }
            num1 = Float.parseFloat(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[2]) {
            if (textField.getText().equals("Infinity")) {
                textField.setText("0");
            }
            num1 = Float.parseFloat(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[3]) {
            if (textField.getText().equals("Infinity")) {
                textField.setText("0");
            }
            num1 = Float.parseFloat(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[5]) {
            if (textField.getText().equals("Infinity")) {
                textField.setText("0");
            }
            String string = textField.getText();
            boolean dot = false;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '.') {
                    dot = true;
                }
            }
            if (!dot){
                textField.setText(textField.getText() + '.');
            }
        }

        if (e.getSource() == functionButtons[6]) {
            textField.setText("0");
        }
        if (e.getSource() == functionButtons[7]) {
            if (textField.getText().equals("Infinity")){
                textField.setText("");
            }
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
                }
            }
            if (textField.getText().equals("")) {
                textField.setText("0");
        }

        if (e.getSource() == functionButtons[4]) {
            switch (operator) {
                case '+':
                    num2 = Float.parseFloat(textField.getText());
                    textField.setText(String.valueOf(num1 + num2));
                    num1 = 0;
                    num2 = 0;
                    operator = ' ';
                    break;
            }
            switch (operator) {
                case '-':
                    num2 = Float.parseFloat(textField.getText());
                    textField.setText(String.valueOf(num1 - num2));
                    num1 = 0;
                    num2 = 0;
                    operator = ' ';
                    break;
            }
            switch (operator) {
                case '*':
                    num2 = Float.parseFloat(textField.getText());
                    textField.setText(String.valueOf(num1 * num2));
                    num1 = 0;
                    num2 = 0;
                    operator = ' ';
                    break;
            }
            switch (operator){
                case '/': num2 = Float.parseFloat(textField.getText());
                    textField.setText(String.valueOf(num1 / num2));
                    num1 = 0;
                    num2 = 0;
                    operator = ' ';
                    break;
            }
        }

    }
}
