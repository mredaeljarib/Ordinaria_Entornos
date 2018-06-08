import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		ApiManager​ apiManager​ = new ApiManager​();
		Conversion​ conversion = new Conversion​();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cantidad = new JLabel("Cantidad :");
		cantidad.setBounds(102, 56, 100, 17);
		contentPane.add(cantidad);

		JLabel origen = new JLabel("Divisa Origen :");
		origen.setBounds(102, 137, 143, 19);
		contentPane.add(origen);

		JLabel destino = new JLabel("Divisa destino :");
		destino.setBounds(102, 210, 143, 15);
		contentPane.add(destino);

		JLabel factor = new JLabel("Factor :");
		factor.setBounds(102, 441, 70, 15);
		contentPane.add(factor);

		JLabel resultado = new JLabel("Resultado :");
		resultado.setBounds(323, 441, 114, 15);
		contentPane.add(resultado);

		JLabel resultado_2 = new JLabel("");
		resultado_2.setBounds(323, 509, 192, 15);
		contentPane.add(resultado_2);

		JLabel factor_2 = new JLabel("");
		factor_2.setBounds(102, 509, 197, 15);
		contentPane.add(factor_2);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(323, 56, 114, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		String[] divisa = { "EUR", "USD", "JPY" };

		JComboBox comboOrigen = new JComboBox(divisa);
		comboOrigen.setBounds(323, 132, 114, 24);
		contentPane.add(comboOrigen);

		JComboBox comboDestino = new JComboBox(divisa);
		comboDestino.setBounds(323, 205, 114, 24);
		contentPane.add(comboDestino);

		JButton Convertir = new JButton("Convertir");
		Convertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					if (Double.valueOf(txtCantidad.getText()) == 0) {

					} else {

						if (Double.valueOf(txtCantidad.getText()) < 0) {

							resultado_2.setText("Mayor que cero ");
							resultado_2.getText();
							factor_2.setText("0");
							factor_2.getText();
						} else {
							String org = (String) comboOrigen.getSelectedItem();
							String des = (String) comboDestino.getSelectedItem();

							factor_2.setText(String.valueOf(apiManager​.averiguaCambio(org, des)));
							factor_2.getText();

							resultado_2.setText(String.valueOf(conversion.calculaConversion(
									Double.valueOf(txtCantidad.getText()), apiManager​.averiguaCambio(org, des))));
							resultado_2.getText();
						}

					}
				} catch (Exception e1) {
					resultado_2.setText("Solo numero");
					resultado_2.getText();
					factor_2.setText("0");
					factor_2.getText();
				}
			}
		});
		Convertir.setBounds(320, 340, 117, 25);
		contentPane.add(Convertir);
	}
}
