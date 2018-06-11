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
import pobl4.utils.Utils;

/**
 * @author Lucas
 *
 */
public class CtrlAnadirConsumo implements ActionListener{

	VistaAnadirConsumo vista;
	ConsumoDAO consumoDAO;
	List<File> files;
	public CtrlAnadirConsumo(VistaAnadirConsumo vista,ConsumoDAO consumoDAO) {
		this.vista = vista;
		this.consumoDAO = consumoDAO;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Examinar")) {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fc.setMultiSelectionEnabled(true);
			fc.addChoosableFileFilter(new CSVFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(vista);
			
		     if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File [] selectedFiles = fc.getSelectedFiles();
		            setFileList(selectedFiles);
		            List<String> lista = new ArrayList<>();
		            for(File f: files)
		            	lista.add(f.getName());
		            vista.setList(lista);
		        }
		     
		}
		
		if(e.getActionCommand().equals("Eliminar")) {
			String selectedItem = vista.getSelectedItem();
			if(selectedItem != null)
				for(int i = 0; i< files.size(); i++)
					if(files.get(i).getName().equals(selectedItem))
						files.remove(i);
			
			vista.removeSelectedItem();
		}
		
		if(e.getActionCommand().equals("Aceptar")) {
			if(files != null) {
				Utils.createConsumes(consumoDAO, leerFicheros());
			}
			
			vista.dispose();
			
		}
		
	}
	
	public List<Consumo> leerFicheros(){
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
		          System.out.println("bukatuta");
		return list;
		
	}
	
	private void setFileList(File...selectedFiles) {
		files = new ArrayList<>();
		for(int i = 0;i< selectedFiles.length;i++)
			files.add(selectedFiles[i]);
	}
	


	
}
