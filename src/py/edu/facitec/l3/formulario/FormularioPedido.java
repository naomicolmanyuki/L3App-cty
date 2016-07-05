package py.edu.facitec.l3.formulario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class FormularioPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormularioPedido dialog = new FormularioPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormularioPedido() {
		setBounds(100, 100, 879, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(15, 27, 69, 20);
		contentPanel.add(lblCodigo);
		
		JLabel lblComprobante = new JLabel("Comprobante:");
		lblComprobante.setBounds(15, 63, 126, 20);
		contentPanel.add(lblComprobante);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(15, 110, 101, 20);
		contentPanel.add(lblProveedor);
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(15, 161, 69, 20);
		contentPanel.add(lblRuc);
		
		JLabel lblTotalPedido = new JLabel("Total pedido:");
		lblTotalPedido.setBounds(15, 209, 101, 20);
		contentPanel.add(lblTotalPedido);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(543, 27, 69, 20);
		contentPanel.add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(131, 206, 146, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 158, 146, 26);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 24, 146, 26);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 60, 146, 26);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 107, 146, 26);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(627, 24, 146, 26);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(292, 107, 404, 26);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(711, 106, 115, 29);
		contentPanel.add(btnBuscar);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(408, 161, 115, 20);
		contentPanel.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(543, 161, 248, 68);
		contentPanel.add(textPane);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(15, 272, 55, 20);
		contentPanel.add(lblCodigo_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(15, 297, 82, 26);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(116, 272, 69, 20);
		contentPanel.add(lblNombre);
		
		textField_8 = new JTextField();
		textField_8.setBounds(116, 297, 197, 26);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(328, 272, 69, 20);
		contentPanel.add(lblCantidad);
		
		textField_9 = new JTextField();
		textField_9.setBounds(328, 297, 107, 26);
		contentPanel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(454, 272, 69, 20);
		contentPanel.add(lblPrecio);
		
		textField_10 = new JTextField();
		textField_10.setBounds(450, 297, 115, 26);
		contentPanel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setBounds(582, 272, 69, 20);
		contentPanel.add(lblSubtotal);
		
		textField_11 = new JTextField();
		textField_11.setBounds(581, 297, 115, 26);
		contentPanel.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(711, 296, 115, 29);
		contentPanel.add(btnBuscar_1);
	}
}
