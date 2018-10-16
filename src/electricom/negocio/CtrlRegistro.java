package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import electricom.dao.UserDAO;
import electricom.dominio.Compania;
import electricom.dominio.Tarifa;
import electricom.dominio.User;
import electricom.presentacion.VistaRegistro;

public class CtrlRegistro implements ActionListener{
	
	VistaRegistro vista;
	UserDAO userDAO;
	
	public CtrlRegistro(VistaRegistro vista, UserDAO userDAO) {
		this.vista = vista;
		this.userDAO = userDAO;
	}

	private String checkInputFields() {
		List<String> inputFields = new ArrayList<>();
		String password = new String (vista.getTxContrasena().getPassword());
		String rPassword = new String (vista.getTxRContrasena().getPassword());
		inputFields.add(vista.getTxNombre().getText());
		inputFields.add(vista.getTxApellido().getText());
		inputFields.add(vista.getTxNombreUsuario().getText());
		inputFields.add(password);
		inputFields.add(rPassword);
		
		if(password.equals(rPassword)) {
		for(int i = 0; i<inputFields.size() ;i++) {
			if(inputFields.get(i).isEmpty()) {
				return "missing inputs";
			}
		}
		}else return "passwords don't match";
		
		return "ok";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("registro")) {
			String result = checkInputFields();
			if(result.equals("ok")) {
				User user = new User();
				user.setNombre(vista.getTxNombre().getText());
				user.setApellido(vista.getTxApellido().getText());
				user.setUsername(vista.getTxNombreUsuario().getText());
				user.setPassword(new String(vista.getTxRContrasena().getPassword()));
				user.setPotencia_contratada(vista.getPotenciaContrata());
				user.setTafiraID(vista.getSelectedTarifa());
				
				userDAO.create(user);
				JOptionPane.showMessageDialog(vista, "Registration Complete!", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
				vista.dispose();
			}else if (result.equals("missing inputs")){
				JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else if(result.equals("passwords don't match")){
				JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals("cancel")) {
			vista.dispose();
		}
		
	}

}
