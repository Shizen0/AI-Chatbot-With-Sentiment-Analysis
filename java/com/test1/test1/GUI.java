package com.test1.test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;


import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GUI {

	public JFrame frmShizenbot;
	public JTextField textField;
	public JTextArea chatTextField;
	public String text;
	public boolean nameSet = false;
	public String name;
	Chatbot shizenbot = new Chatbot();

	NaiveBayes nb = new NaiveBayes();
	boolean replystatus=false;
	public JScrollPane scroll;

	public static void main(String[] args) {
		GUI window = new GUI();
		window.frmShizenbot.setVisible(true);
	}
	
	GUI() {
		
		frmShizenbot = new JFrame();
		frmShizenbot.setTitle("ShizenBot");
		frmShizenbot.getContentPane().setBackground(Color.WHITE);
		frmShizenbot.getContentPane().setLayout(null);
		frmShizenbot.setIconImage(Toolkit.getDefaultToolkit().getImage(("D:\\Eclipseworkspace 2020\\ChatbotApplication\\src\\main\\java\\images\\shizen.png")));
		JButton sendButton = new JButton("Send");
	
		sendButton.setBackground(Color.LIGHT_GRAY);
		sendButton.setFont(new Font("Calibri", Font.BOLD, 9));
		sendButton.setForeground(Color.BLACK);
		sendButton.setBounds(428, 564, 55, 49);
		frmShizenbot.getContentPane().add(sendButton);
		
		JPanel sendTextPanel = new JPanel();
		sendTextPanel.setBounds(10, 564, 473, 49);
		
		sendTextPanel.setLayout(null);
		
		textField = new JTextField();
		
		textField.setBounds(0, 0, 418, 49);
		sendTextPanel.add(textField);
		textField.setFont(new Font("Calibri", Font.PLAIN, 19));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(sendTextPanel);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 493, 623);
		frmShizenbot.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel chatPanel = new JPanel();
		chatPanel.setBackground(Color.WHITE);
		chatPanel.setBounds(0, 0, 483, 562);
		mainPanel.add(chatPanel);
		chatPanel.setLayout(null);
		
		chatTextField = new JTextArea();
	
		chatTextField.setFont(new Font("Calibri", Font.PLAIN, 15));
		chatTextField.setBounds(10, 0, 473, 552);
		
		JScrollBar scrollPane = new JScrollBar();
		scrollPane.setBounds(456, 0, 17, 552);
		chatPanel.add(chatTextField);
		chatTextField.add(scrollPane);
		chatTextField.setEditable(false);
		
		chatTextField.setText("Shizen Bot: Before We start let me know your name\n");
		
		frmShizenbot.setResizable(false);
		chatTextField.setLineWrap(true);

	
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					recieveText();
					
		        }
			}
		});
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recieveText();	
			}	
		});
		
		frmShizenbot.setBounds(100, 100, 507, 660);
		frmShizenbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 String recieveText()  {
	
		String botreply = shizenbot.response(textField.getText());
		if(nameSet==true) {
		
				chatTextField.setText( chatTextField.getText() +  name +": " + textField.getText() + "\n ");				
				chatTextField.setText( chatTextField.getText() +  "ShizenBot: " + botreply + "\n ");
				replystatus = false;
		}
		
		else {
			name = textField.getText();
			chatTextField.setText( chatTextField.getText() +  name +": " + textField.getText() + "\n ");
			nameSet=true;
		}
		
		System.out.println(textField.getText());
		textField.setText("");	
		
		return textField.getText();
	}
}
