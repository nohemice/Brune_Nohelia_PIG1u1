package formulario;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.StrokeBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

public class EstiloComponentes {

	public static void aplicarEstiloBoton(JButton boton) {
		boton.setBackground(PaletaNokia.VERDE_OSCURO);
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Nokian", Font.BOLD, 18));
		boton.setFocusPainted(false);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public static void aplicarEstiloLabel(JLabel label) {
	    label.setForeground(PaletaNokia.VERDE_OSCURO);
	    label.setFont(new Font("Nokian", Font.BOLD, 14));
	}
	public static void aplicarEstiloTitulos(JLabel label) {
	    label.setForeground(PaletaNokia.VERDE_OSCURO);
	    label.setFont(new Font("BM neco", Font.PLAIN, 44));
	}

	public static void EstiloCampo(JTextField campo, Color colorBorde) {
	    // 1. logica de borde punteado
	    float[] dash = {6f, 4f};
	    BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
	    StrokeBorder bordePunteado = new StrokeBorder(stroke, colorBorde);
	    EmptyBorder margenInterno = new EmptyBorder(0, 8, 0, 8);
	    campo.setBorder(new CompoundBorder(bordePunteado, margenInterno));

	   
	    campo.setForeground(PaletaNokia.VERDE_OSCURO); // El color de letra
	    campo.setBackground(PaletaNokia.VERDE_CLARO); // color fondo
	    campo.setFont(new Font("Nokian", Font.BOLD, 14)); // tipo de letra
	}
	
	public static void EstiloTabla(JTable tabla) {
		
		// 1. BLOQUEO DE EDICIÓN Y CUADRO BLANCO (Renderer Personalizado)
        DefaultTableCellRenderer rendererNokia = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                // Forzamos hasFocus a FALSE para que NUNCA dibuje el recuadro blanco
                Component c = super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
                
                if (isSelected) {
                    c.setBackground(new Color(100, 110, 70));
                    c.setForeground(PaletaNokia.VERDE_CLARO);
                } else {
                    c.setBackground(PaletaNokia.VERDE_CLARO);
                    c.setForeground(PaletaNokia.VERDE_OSCURO);
                }

                // Quitamos bordes internos de la celda
                if (c instanceof JComponent) {
                    ((JComponent) c).setBorder(BorderFactory.createEmptyBorder());
                }
                return c;
            }
        };
		
		
		tabla.setDefaultRenderer(Object.class, rendererNokia);
        tabla.setDefaultRenderer(String.class, rendererNokia);
        
     //DESACTIVA EL DOBLE CLIC EN LAS TABLAS
        tabla.setDefaultEditor(Object.class, null);
        tabla.setDefaultEditor(String.class, null);
		    // 2. Definir el trazo para los bordes
		    float[] dash = {6f, 4f};
		    BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
		    
		    // 3. Configuración de comportamiento y selección limpia
		    tabla.setRowSelectionAllowed(true);       // Permite seleccionar la fila del contacto
		    tabla.setColumnSelectionAllowed(false);   // Bloquea selección vertical
		    tabla.setCellSelectionEnabled(false);     // Evita que se seleccione un cuadrito individual
		    tabla.setShowGrid(true);
		    tabla.setFillsViewportHeight(true);
		    tabla.setRowHeight(25); 
		    tabla.setIntercellSpacing(new Dimension(4, 4));
		    
		    // 4. COLORES DE LA TABLA
		    tabla.setGridColor(PaletaNokia.VERDE_OSCURO);
		    tabla.setFont(new Font("Nokian", Font.BOLD, 14));
		    tabla.setForeground(PaletaNokia.VERDE_OSCURO);
		    tabla.setBackground(PaletaNokia.VERDE_CLARO);
		    
		    // Cambiar el color de fondo cuando una fila esté seleccionada (para evitar azules raros de Windows)
		    tabla.setSelectionBackground(PaletaNokia.VERDE_OSCURO);
		    tabla.setSelectionForeground(PaletaNokia.VERDE_CLARO);
		    
		    // 5. Estilo del Encabezado
		    tabla.getTableHeader().setBackground(PaletaNokia.VERDE_OSCURO);
		    tabla.getTableHeader().setForeground(PaletaNokia.TEXTO_NOKIA);
		    tabla.getTableHeader().setFont(new Font("Nokian", Font.BOLD, 14));
		    tabla.getTableHeader().setBorder(new javax.swing.border.StrokeBorder(stroke, PaletaNokia.VERDE_OSCURO));
		    
		    // 6. Borde exterior de la tabla
		    tabla.setBorder(new javax.swing.border.StrokeBorder(stroke, PaletaNokia.VERDE_OSCURO));
		}
	
}
