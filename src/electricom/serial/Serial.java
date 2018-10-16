package electricom.serial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;

public class Serial {
	private static final Logger LOGGER = Logger.getLogger(Serial.class.getName());
	InputStream in;
	OutputStream out;
	CommPort commPort;
	SerialPort serialPort;
	
	public Serial() {
	}
	public void conectar ( CommPortIdentifier portIdentifier ) throws Exception
    {
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error puerta en uso");
        }
        else
        {
             commPort = portIdentifier.open("Mi programa",2000);
            
            if ( commPort instanceof SerialPort )
            {
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                
                in = serialPort.getInputStream();
                out = serialPort.getOutputStream();
                serialPort.notifyOnDataAvailable(true);
            }
            else
            {
                System.out.println("Error este programa solo funciona con linea serie");
            }
        }     
    }	
	
    public CommPortIdentifier encontrarPuerto()
    {
        java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while ( portEnum.hasMoreElements() ) 
        {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            if (this.getPortTypeName(portIdentifier.getPortType()).equals("Serial")) {
            	return portIdentifier;
            }
            System.out.println(portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()) );
        } 
        return null;
   	/* try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier( "/dev/ttyUSB0" );
			if (this.getPortTypeName(portIdentifier.getPortType()).equals("Serial")) {
           	System.out.println(portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()) );
           	
           	return portIdentifier;
           }

		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	return null;*/
    }

    public void escribir (byte msg)
    {
        try
        {  
            this.out.write(msg);
        }
        catch ( IOException e )
        {
        	LOGGER.log(Level.SEVERE,e.getMessage());
        }            
    }
    
    public int leer ()
    {
    	int bytes = 0;
        try
        {  
        	bytes = this.in.read();
        }
        catch ( IOException e )
        {
        	LOGGER.log(Level.SEVERE,e.getMessage());
        } 
        return bytes;
    }
    

    
    public String getPortTypeName ( int portType )
    {
        switch ( portType )
        {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "Parallel";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }
    public void cerrar() {
    	commPort.close();
    }

	public void addListener(SerialPortEventListener listener) {
		try {
			serialPort.addEventListener(listener);
		} catch (TooManyListenersException e) {
			LOGGER.log(Level.SEVERE,e.getMessage());
		}
		
	}
	
	public InputStream getInput() {
		return in;
	}
}
