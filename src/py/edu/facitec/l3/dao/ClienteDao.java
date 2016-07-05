package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.util.ConexionManager;

public class ClienteDao {
	public static void guardarCliente (Cliente cliente){
		String sql = "insert into clientes (nombre, apellido, direccion, estado) "
				+ "values ('"+cliente.getNombre()+"', "
						+ " '"+cliente.getApellido()+"', "
								+ "'"+cliente.getDirecion()+"',"
							+ " "+cliente.isEstado()+") ";
		System.out.println(sql);
		ConexionManager.abrirConexion();  
		
		try {
			ConexionManager.stm.executeUpdate(sql); 
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		ConexionManager.cerrarConecion();
}
	
	public static Cliente buscarClientePorId(int id){
		Cliente cliente = null;
		ResultSet rs;
		
		String sql = "select * from clientes where codigo = "+id; 
		System.out.println(sql);
		ConexionManager.abrirConexion();  
		try {
			
			rs = ConexionManager.stm.executeQuery(sql); 
			
			if(rs.next()){ 
				cliente = new Cliente(); 
				
				cliente.setCodigo(rs.getInt("codigo"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDirecion(rs.getString("direccion"));	
				cliente.setEstado(rs.getBoolean("estado"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	public static void modificarCliente(Cliente cliente){
		String sql = "update clientes set nombre= '"+cliente.getNombre()+"', "
				+ "apellido='"+cliente.getApellido()+"', "
				+ "direccion='"+cliente.getDirecion()+"', "
				+ "estado="+cliente.isEstado()+" where "
				+ "codigo="+cliente.getCodigo();
		
	ConexionManager.abrirConexion();
	
	
	try {
	ConexionManager.stm.executeUpdate (sql);
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	ConexionManager.cerrarConecion();
	}
	public static void eliminarCliente (int codigo){
		String sql = "delete from clientes where codigo = "+codigo+" ";
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConecion();
	}

}
