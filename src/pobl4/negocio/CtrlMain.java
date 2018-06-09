/**
 * 
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import pobl4.dao.ConsumoDAO;
import pobl4.dominio.Consumo;
import pobl4.main.Main;
import pobl4.presentacion.VistaConsumo;

/**
 * @author root
 *
 */
public class CtrlMain implements ActionListener {
	
	List<Consumo> listConsumo;
	ConsumoDAO consumoDAO;
	Main vista;
	public CtrlMain(Main vista, List<Consumo> listConsumo,ConsumoDAO consumoDAO) {
		this.listConsumo = listConsumo;
		this.consumoDAO = consumoDAO;
		this.vista = vista;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("consumo")) {
			VistaConsumo consumo = new VistaConsumo(vista, true, listConsumo, consumoDAO);
		}

	}

}
