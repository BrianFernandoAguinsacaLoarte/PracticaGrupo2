
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.DetalleCenso;


public class ModeloTablaDetalle extends AbstractTableModel {

    LinkedList<DetalleCenso> detalles = new LinkedList<>();
    
    
    @Override
    public int getRowCount() {
        return detalles.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        DetalleCenso detalleCenso = null;
        
        try {
            detalleCenso = detalles.get(fila);
        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (detalleCenso != null)? detalleCenso.getFechaCenso(): "";
            case 1:
                    return (detalleCenso != null)? detalleCenso.getId_persona(): "";
            case 2: 
                    return (detalleCenso != null)? detalleCenso.getMotivo(): "";
            case 3: 
                    return (detalleCenso != null)? detalleCenso.getFechaDivorcio(): "";
            case 4: 
                    return (detalleCenso != null)? detalleCenso.getEstadoCivilAnterior(): "";
            case 5: 
                    return (detalleCenso != null)? detalleCenso.getEstadoCivilActual(): "";
                
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                    return "Fecha Censo";
            case 1:
                    return "Cliente";
            case 2: 
                    return "Motivo";
            case 3: 
                    return "Fecha Divorcio/Separamiento";
            case 4: 
                    return "Estado Civil Anterior";
            case 5: 
                    return "Estado Civil Actual";
            default:
                return null;
        }
    }
    
    //Getter and Setter

    public LinkedList<DetalleCenso> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleCenso> detalles) {
        this.detalles = detalles;
    }
    
    
    
    
}
