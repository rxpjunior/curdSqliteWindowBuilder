package crudSqliteWindowBuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class inicio {
	
	String nome;
	String situacao;
	int idade;
	double peso;
	double altura;
	double imc;

	private JFrame frmCalculoDeImc;
	private JTextField txtNomee;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtImc;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio window = new inicio();
					window.frmCalculoDeImc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frmCalculoDeImc = new JFrame();
		frmCalculoDeImc.setTitle("Calculo de IMC");
		frmCalculoDeImc.setBounds(100, 100, 433, 315);
		frmCalculoDeImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculoDeImc.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(119, 47, 46, 14);
		frmCalculoDeImc.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Altura");
		lblNewLabel_2.setBounds(119, 78, 46, 14);
		frmCalculoDeImc.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(119, 113, 46, 14);
		frmCalculoDeImc.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("IMC");
		lblNewLabel_4.setBounds(119, 185, 46, 14);
		frmCalculoDeImc.getContentPane().add(lblNewLabel_4);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(72, 230, 352, 14);
		frmCalculoDeImc.getContentPane().add(lblStatus);
		
		txtNomee = new JTextField();
		txtNomee.setBounds(168, 44, 86, 20);
		frmCalculoDeImc.getContentPane().add(txtNomee);
		txtNomee.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setText("");
		txtAltura.setBounds(168, 75, 86, 20);
		frmCalculoDeImc.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setText("");
		txtPeso.setBounds(168, 110, 86, 20);
		frmCalculoDeImc.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		txtImc = new JTextField();
		txtImc.setEditable(false);
		txtImc.setText("");
		txtImc.setBounds(168, 182, 86, 20);
		frmCalculoDeImc.getContentPane().add(txtImc);
		txtImc.setColumns(10);
		
		JButton btnCalcula = new JButton("Calcular");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome=txtNomee.getText();
				try {
					peso=Double.parseDouble(txtPeso.getText().replace(",", "."));
					altura=Double.parseDouble(txtAltura.getText().replace(",", "."));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Você entrou com um valor errado para peso e/ou altura");
					peso=0;
					altura=0;
					situacao = "Não foi possível calcular";
					txtAltura.setText("");
					txtPeso.setText("");
					txtNomee.setText("");
				}
				
				imc=(peso/(altura*altura));
				System.out.println(imc);
				DecimalFormat  aux = new DecimalFormat("0.00");
				String aux2=aux.format(imc);
				txtImc.setText(aux2);
				if(imc<18.5) situacao="Abaixo do Peso";
				if(imc>=18.5 & imc < 24.9) situacao="Peso Normal";
				if(imc>=25 & imc < 29.9) situacao="Sobrepeso";
				if(imc>=30 & imc < 34.9) situacao="Obesidade grau 1";
				if(imc>=35 & imc < 39.9) situacao="Obesidade grau 2";
				if(imc>=40) situacao="Obesidade grau 3";
				lblStatus.setText(nome+" a situação do seu IMC é: "+situacao);
				
				
			}
		});
		btnCalcula.setBounds(165, 141, 89, 23);
		frmCalculoDeImc.getContentPane().add(btnCalcula);
		
		
	}
}
