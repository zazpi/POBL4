/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import pobl4.dao.UserDAO;
import pobl4.dominio.User;
import pobl4.presentacion.VistaLogin;
import pobl4.presentacion.VistaRegistro;
import pobl4.utils.Utils;

/**
 *
 * @author Lucas
 */
public class CtrlLogin implements ActionListener{
    UserDAO userDAO;
    VistaLogin login;
    User user;
    
    public CtrlLogin(VistaLogin login,UserDAO userDAO){
        this.login = login;
        this.userDAO = userDAO;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("entrar")){
            user = Utils.validateUser(userDAO, login.getTxUsuario(), login.getTxContraseña());
            if(user != null){
                JOptionPane.showMessageDialog(login, "Welcome, "+login.getTxUsuario()+"!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                login.closeDialog(user);
            }
            else{
                JOptionPane.showMessageDialog(login, "ERROR: user doesn't exists!", "ERROR 404", JOptionPane.ERROR_MESSAGE);
            }
                
        }
        
        if(e.getActionCommand().equals("registro")) {
        	VistaRegistro registro = new VistaRegistro(login, true,userDAO,login.getListCompanias(),login.getListTarifas());
        }
    }
    
}
