package fag;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
	
	static double numero1;
	static String operacao;

	public static void main(String[] args) {
	
		//janela 
		JFrame frame = new JFrame("Calculadora simples");	//janela com titulo
		frame.setSize(350,600);	//tam janela
        frame.setResizable(false);	//n deixa o usuario mexer dos lados pra aumentar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//a aplicacao termina quando clica no x
		
		//outra janela
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);	//cor de fundo
		
		//cria o visor da caluclçadora
		panel.setLayout(null);
		JTextField visor =  new JTextField("0");
	    visor.setBounds(0, 0, 350, 80);
	    visor.setEditable(false);
		panel.add(visor, BorderLayout.NORTH);	//coloca em cima o visor
		
		//afdicionando no janelao(frame)
		frame.add(panel);
		
		//botoes
		//numeros
		JButton b0 = new JButton("0");
		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "0");
			}
		});
		panel.add(b0);
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "1");
			}
		});
		panel.add(b1);
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "2");
			}
		});
		panel.add(b2);
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "3");
			}
		});
		panel.add(b3);
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "4");
			}
		});
		panel.add(b4);
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "5");
			}
		});
		panel.add(b5);
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "6");
			}
		});
		panel.add(b6);
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "7");
			}
		});
		panel.add(b7);
		
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "8");
			}
		});
		panel.add(b8);
		
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "9");
			}
		});
		panel.add(b9);
		
		
		//operacoes
		JButton soma = new JButton("+");
		soma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numero1 =  Double.parseDouble(visor.getText());
				operacao = "+";
				
				visor.setText("");
						
			}
		});
		panel.add(soma);
		
		JButton div = new JButton("/");
		div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					numero1 =  Double.parseDouble(visor.getText());
					operacao = "/";
					
					visor.setText("");
				
			}
		});
		panel.add(div);
		
		JButton mult = new JButton("*");
		mult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numero1 =  Double.parseDouble(visor.getText());
				operacao = "*";
				
				visor.setText("");
			}
		});
		panel.add(mult);
		
		JButton menos = new JButton("-");
		menos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numero1 =  Double.parseDouble(visor.getText());
				operacao = "-";
				
				visor.setText("");
			}
		});
		panel.add(menos);
		
		
		//outros dois botao
		JButton limpar = new JButton("<-");
		limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.setText("");
			}
		});
		panel.add(limpar);
		
		JButton igual = new JButton("=");
		igual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(igual);
		
		
		//exibindo frame
		frame.setVisible(true);
		
	
	}

}
