package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;

import py.edu.facitec.l3.dao.ClienteDao;
import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.util.ConexionManager;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JTable;

public class ClienteFormulario extends JDialog {
	private final JLabel lblCodigo = new JLabel("Codigo:");
	
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JCheckBox chActivo;
	private JTextPane tpDireccion;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	 ButtonGroup grupoEstado = new ButtonGroup();
	private JTextField tfApellidos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFormulario dialog = new ClienteFormulario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ClienteFormulario() {
		getContentPane().setFont(new Font("Tunga", Font.PLAIN, 11));
		setModal(true);
		setBounds(100, 100, 514, 402);
		getContentPane().setLayout(null);
		lblCodigo.setBounds(10, 11, 46, 31);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 65, 46, 14);
		getContentPane().add(lblNombre);
		
		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			
			//primer evento
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
	
					
				}
			}
			
			//segundo evento
			public void keyTyped(KeyEvent e) {
				if (tfCodigo.getText().length() ==10 ){
					e.consume ();
					getToolkit().beep();
					
				}
			}
			
		});
		tfCodigo.setBounds(101, 19, 86, 23);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfApellidos.requestFocus();
				}
			}
		});
		tfNombre.setBounds(101, 61, 206, 23);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar..");
		btnBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarCliente();
					
				}
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente();
			}
		});
		btnBuscar.setBounds(241, 15, 86, 23);
		getContentPane().add(btnBuscar);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 177, 67, 23);
		getContentPane().add(lblDireccion);
		
		tpDireccion = new JTextPane();
		tpDireccion.setBounds(101, 177, 333, 43);
		getContentPane().add(tpDireccion);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 298, 451, 54);
		getContentPane().add(panel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarCliente();
			}
		});
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				modificarCliente();
			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCliente();
			}
		});
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});
		panel.add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JButton btnCerrar = new JButton("Cerrar");
		panel.add(btnCerrar);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 257, 67, 14);
		getContentPane().add(lblEstado);
		
		chActivo = new JCheckBox("Activo");
		chActivo.setBounds(101, 247, 97, 31);
		getContentPane().add(chActivo);
		
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(101, 116, 206, 23);
		getContentPane().add(tfApellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 116, 46, 14);
		getContentPane().add(lblApellidos);
		
		inicializar();

	}
	
	private void guardarCliente() {
		
		if(tfNombre.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Ingrese el Nombre");
			tfNombre.requestFocus();
			
		}else if(tfApellidos.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Ingrese el Apellido");
			tfApellidos.requestFocus();
			
		}else{			
			Cliente cliente = new Cliente(); 
			cliente.setNombre(tfNombre.getText());
			cliente.setApellido(tfApellidos.getText());
			cliente.setDirecion(tpDireccion.getText());
			cliente.setEstado(chActivo.isSelected());
			ClienteDao.guardarCliente(cliente);
			inicializar();
		}	
	}
	
	
	private void buscarCliente(){
		Cliente cliente = null;
		
		if(tfCodigo.getText().isEmpty() || tfCodigo.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Ingreso un codigo para buscar", "Aviso", 1);
			tfCodigo.requestFocus();
			
		}else{
			int id = Integer.parseInt(tfCodigo.getText());
			cliente =  ClienteDao.buscarClientePorId(id); //  
			
			if(cliente != null){ 
				
				tfNombre.setText(cliente.getNombre());
				tfApellidos.setText(cliente.getApellido());
				chActivo.setSelected(cliente.isEstado());
				tpDireccion.setText(cliente.getDirecion());
				

				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}else{
				JOptionPane.showMessageDialog(this, "No se ha encontrado un cliente con este código");
				limpiarCampos();
			}
			
		}
		
		
	}
	
	public void inicializar(){
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		tfCodigo.setText("");
		tfNombre.setText("");
		tfApellidos.setText("");
		tpDireccion.setText("");
		chActivo.setSelected(false);
		
	}
	
	private void limpiarCampos (){
		tfCodigo.selectAll(); 
		tfNombre.setText("");
		tfApellidos.setText("");
		tpDireccion.setText("");
		
	}
	
	private void modificarCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(Integer.parseInt(tfCodigo.getText()));
		cliente.setNombre(tfNombre.getText());
		cliente.setApellido(tfApellidos.getText());
		cliente.setDirecion(tpDireccion.getText());
			
			if (chActivo.isSelected()) {
				cliente.setEstado(true);
				
			}else {
				cliente.setEstado(false);
			}
			
			ClienteDao.modificarCliente(cliente);
		}
		
	private void eliminarCliente (){
		if (tfCodigo.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(this, "Debes digitar el Codigo del cliente", "aviso", 3);
			tfCodigo.requestFocus();
		}else{
			
			
			int si = JOptionPane.showConfirmDialog(this, "Estas seguro que desea eiminar el registro ", "Aviso", 
					JOptionPane.YES_NO_OPTION);
			if (si ==0){
				int clienteid =Integer.parseInt(tfCodigo.getText() );
				ClienteDao.eliminarCliente(clienteid);
				limpiarCampos();
			}else {
				limpiarCampos();
			}
		}
		
	}
} // fin de la clase