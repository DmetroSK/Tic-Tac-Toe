package Interfaces;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Game implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame("Tic Tac Toe");
	JPanel bottom_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JButton resetButton = new JButton("Reset");
	JButton[] buttons = new JButton[9];
	
	
	boolean player_click=true;

	Game(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.BLACK);
		resetButton.setForeground(Color.WHITE);
		resetButton.setFont(new Font("Times New Romen",Font.BOLD,50));

		
		button_panel.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Brush Script MT",Font.BOLD,120));
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		bottom_panel.setLayout(new GridLayout(1,1));
		bottom_panel.setBackground(Color.BLACK);		
		bottom_panel.add(resetButton);
		frame.add(bottom_panel,BorderLayout.SOUTH);
		frame.add(button_panel);
		
	}
	
	


	public void actionPerformed(ActionEvent e) {
		
	
				for(int i=0;i<9;i++) {
					if(e.getSource()==buttons[i]) {
						if(player_click) {
							if(buttons[i].getText()=="") {
								buttons[i].setText("X");
								player_click=false;
								check();
							}
						}
						
						else {
							if(buttons[i].getText()=="") {
								buttons[i].setText("O");
								player_click=true;
								check();
							}
						}
					}
				}
				
				
				resetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							reset();
						}});
	}
				
		 
	
	
	
	
	public void check() {
		
		
		
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xPlayerWins(0,1,2);
		}
		
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xPlayerWins(3,4,5);
		}
		
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xPlayerWins(6,7,8);
		}
		
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xPlayerWins(0,3,6);
		}
		
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xPlayerWins(1,4,7);
		}
		
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
			xPlayerWins(2,5,8);
		}
		
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xPlayerWins(0,4,8);
		}
		
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xPlayerWins(2,4,6);
		}
		
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oPlayerWins(0,1,2);
		}
		
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oPlayerWins(3,4,5);
		}
		
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oPlayerWins(6,7,8);
		}
		
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oPlayerWins(0,3,6);
		}
		
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oPlayerWins(1,4,7);
		}
		
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
			oPlayerWins(2,5,8);
		}
		
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oPlayerWins(0,4,8);
		}
		
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oPlayerWins(2,4,6);
		}
		
		if((buttons[0].getText() != "") && (buttons[1].getText()!="") && (buttons[2].getText()!="") &&
				(buttons[3].getText()!="") && (buttons[4].getText()!="") && (buttons[5].getText()!="") &&
				(buttons[6].getText()!="") && (buttons[7].getText()!="") && (buttons[8].getText()!="")) {
			draw();
		}
		
		
	}
	
	public void xPlayerWins(int a,int b,int c) {
		buttons[a].setBackground(Color.WHITE);
		buttons[a].setForeground(Color.BLACK);
		
		buttons[b].setBackground(Color.WHITE);
		buttons[b].setForeground(Color.BLACK);
		
		buttons[c].setBackground(Color.WHITE);
		buttons[c].setForeground(Color.BLACK);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(null, "X Wins");	
	
	}
	public void oPlayerWins(int a,int b,int c) {
		buttons[a].setBackground(Color.WHITE);
		buttons[a].setForeground(Color.BLACK);
		
		buttons[b].setBackground(Color.WHITE);
		buttons[b].setForeground(Color.BLACK);
		
		buttons[c].setBackground(Color.WHITE);
		buttons[c].setForeground(Color.BLACK);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(null, "O Wins");	
	}
	
	public void draw() {
	
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			buttons[i].setBackground(Color.DARK_GRAY);
		}
		JOptionPane.showMessageDialog(null, "Draw");	
	}
	
	public void reset() {
		
		
		for(int i=0;i<9;i++) {
			buttons[i].setText("");
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setEnabled(true);
		}
	
	}
}