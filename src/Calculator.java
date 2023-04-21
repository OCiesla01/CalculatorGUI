import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setLayout(new FlowLayout());
        this.setResizable(false);



        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
