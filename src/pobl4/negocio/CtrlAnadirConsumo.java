/**
 * 
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import pobl4.dao.ConsumoDAO;
import pobl4.dominio.Consumo;
import pobl4.main.Main;
import pobl4.presentacion.VistaAnadirConsumo;

/**
 * @author Lucas
 *
 */
public class CtrlAnadirConsumo implements ActionListener{

	VistaAnadirConsumo vista;
	ConsumoDAO consumoDAO;
	public CtrlAnadirConsumo(VistaAnadirConsumo vista,ConsumoDAO consumoDAO) {
		this.vista = vista;
		this.consumoDAO = consumoDAO;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("examinar")) {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fc.setMultiSelectionEnabled(true);
			fc.addChoosableFileFilter(new CSVFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(vista);
			
		     if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File [] files = fc.getSelectedFiles();
		            System.out.println(files.length);
		        }
		     
		}
		
	}
	
	public List<Consumo> leerFicheros(File...files){
		List<Consumo> list = new ArrayList<>();
		for(File f: files) {
			try(BufferedReader in = new BufferedReader(new FileReader(f.getAbsolutePath()))){
				String line;
				in.readLine();
				while((line = in.readLine())!=null) {
					Consumo consumo = new Consumo();
					String data [] = line.split(";");
					if(data.length > 1) {
					String fechas [] = data[1].split("/");

					consumo.setUsuarioID(Main.USERID);
					consumo.setConsumo(Double.valueOf(data[3].replace(",", ".")));
					consumo.setHora(Integer.valueOf(data[2]));
					consumo.setDia(Integer.valueOf(fechas[0]));
					consumo.setMes(Integer.valueOf(fechas[1]));
					consumo.setAño(Integer.valueOf(fechas[2]));
					list.add(consumo);
					}
					
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	


	
}
