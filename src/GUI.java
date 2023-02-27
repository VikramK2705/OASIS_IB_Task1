import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI  {

    private int attempts;
    String result;
    private int count=0;
    private JLabel label,label2,askAttempt,askRange,labelx;
    private JFrame frame,frame1;
    private JPanel panel,panel1;
    private JTextField number,attempt,minimum,maximum;

    public GUI(){

            frame1=new JFrame();
            frame1.setTitle("Game Menu");
            frame1.setLocationRelativeTo(null);
            frame1.setSize(500, 400);

            panel1=new JPanel();
            panel1.setLayout(null);
            frame1.add(panel1);

            askAttempt=new JLabel("Enter no of guesses you need");
            askRange=new JLabel("Enter range of numbers");
            askAttempt.setBounds(100,20,200,50);
            askRange.setBounds(100,70,200,50);
            panel1.add(askAttempt);
            panel1.add(askRange);

            attempt=new JTextField();
            attempt.setBounds(300,35,50,20);
            panel1.add(attempt);

            minimum=new JTextField();
            minimum.setBounds(300,85,50,20);
            maximum=new JTextField();
            maximum.setBounds(400,85,50,20);

            JButton button = new JButton("Submit");
            button.setBounds(100,120,100,25);
            button.addActionListener(e -> {
                submitmenu(e);
            });
            panel1.add(button);

            panel1.add(maximum);
            panel1.add(minimum);
            frame1.setVisible(true);
    }
    public GUI(int min,int max,int attemp){
        attempts=attemp;
        count=(int)Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println(max+" "+min+" "+attempts);
        frame = new JFrame();

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main Game");
        frame.setLocationRelativeTo(null);

        JButton button = new JButton("Submit");
        number = new JTextField();
        number.setBounds(100, 80, 250, 25);

        button.addActionListener(e -> {
            actionPerformed(e,attempts--);
        });
        button.setBounds(100, 110, 100, 25);
        labelx = new JLabel("This computer is thinking of a number between "+min+" and "+max);
        labelx.setBounds(100, 20, 350, 25);
        label = new JLabel(" Can you guess it in "+attemp +" attempts?");
        label.setBounds(100, 50, 350, 25);
        label2 = new JLabel(result);
        label2.setBounds(100, 140, 150, 50);
        panel = new JPanel();
        panel.add(button);
        panel.add(label);
        panel.add(labelx);
        panel.add(number);
        panel.setLayout(null);
        panel.add(label2);
        frame.add(panel);
        frame.setSize(500, 400);

        frame.setVisible(true);
    }
    public GUI(int i){
        JFrame f=new JFrame();
        f.setSize(600,300);
        f.setLocationRelativeTo(null);
        f.setTitle("Congratulations!!");
        JPanel panel=new JPanel();
        f.add(panel);

        JLabel label= new JLabel("You guessed right!   You won the game");
        label.setFont(new Font("Sans Serif", Font.BOLD, 19));
        label.setBounds(30,50,500,50);
        panel.setLayout(null);
        panel.add(label);

        f.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }


    public void actionPerformed(ActionEvent e,int attempts) {

        if(attempts>0){
            if((number.getText()).equals(String.valueOf(count))) {
                label2.setText("Correct \n The answer is " + count);
                new GUI(1);

            }
            else{
                label2.setText("Wrong Answer");
            }
        }
        else{
            label2.setText("You are out of attempts \n YOU LOST!");

        }


    }
    public void submitmenu(ActionEvent e){
        int max=Integer.valueOf(maximum.getText()) ;
        int min=Integer.valueOf(minimum.getText());
        int attempts=Integer.valueOf(attempt.getText());

        new GUI(min,max,attempts);
    }
}