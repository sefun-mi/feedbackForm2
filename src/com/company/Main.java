package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
	    CustomFrame frame = new CustomFrame();

    }
}

class CustomFrame extends JFrame implements ActionListener{

    JLabel titleLabel;
    JLabel nameLabel;
    JTextField nameField;
    JLabel numberLabel;
    JTextField numberField;
    JLabel complaintLabel;
    JTextField complaintField;
    JButton button;

    CustomFrame(){
        titleLabel = new JLabel("Customer Feedback Form");
        titleLabel.setBounds(20,20,20,20);

        nameLabel = new JLabel("Customer Name");
        nameLabel.setBounds(50,50,50,50);

        nameField = new JTextField(20);
        nameField.setBounds(100,100,100,100);

        numberLabel = new JLabel("Customer Number");
        numberLabel.setBounds(130,130,130,130);

        numberField = new JTextField(20);
        numberField.setBounds(200,200,200,200);

        complaintLabel = new JLabel("Customer Complaint");
        complaintLabel.setBounds(250,250,250,250);

        complaintField = new JTextField(100);
        complaintField.setBounds(300,300,300,300);

        button = new JButton("submit feedback");
        button.addActionListener(this);

        this.add(titleLabel);
        this.add(nameField);
        this.add(nameLabel);
        this.add(numberLabel);
        this.add(numberField);
        this.add(complaintField);
        this.add(complaintLabel);
        this.setVisible(true);

        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        File myFile = new File("feedBack.txt");

        try{
            myFile.createNewFile();
            FileWriter myWriter = new FileWriter("feedBack.txt");
            myWriter.write("Name: "+ nameField.getText());
            myWriter.write("Number: "+ numberField.getText());
            myWriter.write("Complaint: "+ complaintField.getText());
            myWriter.close();

            JDialog d = new JDialog(this, "message");

            // create a label
            JLabel l = new JLabel("submission complete");

            d.add(l);

            d.setSize(100, 100);

            // set visibility of dialog
            d.setVisible(true);

        }catch (Exception ex){
            System.out.println("Something went wrong");
        }
    }

}
