/**
 * 
 */
package pobl4.negocio;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author root
 *
 */
public class CSVFilter extends FileFilter {

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if(f.isDirectory()) {
			return true;
		}
		
		String extension = getExtension(f);
		if(extension!=null) {
			if(extension.equals("csv"))
				return true;
		}
		return false;
	}
	
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
