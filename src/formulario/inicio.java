package formulario;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.StrokeBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clase.contacto;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class inicio extends JFrame {
	ArrayList<contacto> Agenda = new ArrayList<>();

	DefaultTableModel M;
	DefaultTableModel modeloConsultas;
	private void CrearModelo() {
		try {
			M = (new DefaultTableModel (null, new String[] { "I D", "Nombres", "Apellidos","Correo", "Numero"}) {}); //encabezado de la tabla en la pestaña Mi Agenda
					Jtable1.setModel(M);

					Jtable1.getColumnModel().getColumn(0).setPreferredWidth(35); //ID
					Jtable1.getColumnModel().getColumn(1).setPreferredWidth(80); //NOMBRES
					Jtable1.getColumnModel().getColumn(2).setPreferredWidth(80); //APELLIDOS
					Jtable1.getColumnModel().getColumn(3).setPreferredWidth(120); //CORREO
					Jtable1.getColumnModel().getColumn(4).setPreferredWidth(35); //NUMERO

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error ");
		}
	}

	private static final long serialVersionUID = 1L;
	private JProgressBar barraProgreso;
	private JPanel contentPane;
	private JLabel lblGmail, lblOutlook, lblOtros;
	private JPanel panelDeLaAgenda;
	private JTabbedPane pestania;
	private JTextField txtID;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTable Jtable1;
	private JTextField txtNumero;
	private JTable tablaConsultas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					inicio frame = new inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//la ventana y sus medidas
	public inicio() {
		setForeground(new Color(46, 68, 44));
		setTitle("Agenda Telefonica");
		setBackground(new Color(46, 68, 44));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 200, 120));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//el JtabbedPane pestania y sus medidas
		pestania =new JTabbedPane();
		pestania.setForeground(new Color(255, 255, 255));
		pestania.setFont(new Font("Nokian", Font.BOLD, 11));
		pestania.setBackground(new Color(46, 68, 44));
		pestania.setBorder(null);
		pestania.setBounds(0, 0, 1212, 475);
		contentPane.add(pestania);
			    	
		float[] dash2 = {6f, 4f}; 
		java.awt.BasicStroke stroke = new java.awt.BasicStroke(3, java.awt.BasicStroke.CAP_SQUARE, java.awt.BasicStroke.JOIN_MITER, 10.0f, dash2, 0.0f);
		
		//el nombre que va llevar la pestaña en primer Jtabbed de la ventana del programa de agenda telefonica
		panelDeLaAgenda = new JPanel();
		panelDeLaAgenda.setBackground(new Color(160, 200, 120));
		panelDeLaAgenda.setForeground(new Color(0, 0, 0));
		panelDeLaAgenda.setBorder(new MatteBorder(3, 3, 3, 3, new Color(46, 68, 47)));
		panelDeLaAgenda.setLayout(null);
		pestania.addTab("Mi Agenda", panelDeLaAgenda);
		pestania.setBackgroundAt(0, new Color(160, 200, 120));
		//==============================================================================
				//etiquetas de la ventana principal

			    JLabel LBLtAgT = new JLabel("Agenda      Telefonica");
			    LBLtAgT.setForeground(new Color(46, 68, 44));
			    LBLtAgT.setFont(new Font("BM neco", Font.PLAIN, 44));
			    LBLtAgT.setBounds(164, 0, 995, 59);
			    panelDeLaAgenda.add(LBLtAgT);
			    
			    JLabel LBL_ID = new JLabel("Identificacion");
			    LBL_ID.setForeground(new Color(46, 68, 44));
			    LBL_ID.setFont(new Font("Nokian", Font.BOLD, 14));
			    LBL_ID.setBounds(10, 74, 119, 14);
			    panelDeLaAgenda.add(LBL_ID);
			    
			    JLabel LBL_NOM = new JLabel("Nombres");
			    LBL_NOM.setForeground(new Color(46, 68, 44));
			    LBL_NOM.setFont(new Font("Nokian", Font.BOLD, 14));
			    LBL_NOM.setBounds(10, 114, 75, 14);
			    panelDeLaAgenda.add(LBL_NOM);
			    	    
			    JLabel LBL_AP = new JLabel("Apellido");
			    LBL_AP.setForeground(new Color(46, 68, 44));
			    LBL_AP.setFont(new Font("Nokian", Font.BOLD, 14));
			    LBL_AP.setBounds(10, 160, 119, 14);
			    panelDeLaAgenda.add(LBL_AP);
			    			    			    			    
			    JLabel LBL_EMAIL = new JLabel("E-mail");
			    LBL_EMAIL.setForeground(new Color(46, 68, 44));
			    LBL_EMAIL.setFont(new Font("Nokian", Font.BOLD, 14));
			    LBL_EMAIL.setBounds(10, 205, 75, 14);
			    panelDeLaAgenda.add(LBL_EMAIL);
			    			    			    			    			    
			    // campos de texto de la ventana principal
			    			    			    
			    txtID = new JTextField();
			    txtID.setForeground(new Color(46, 68, 44));
			    txtID.setBackground(new Color(160, 200, 120));
			    personalizarCampo(txtID, new Color(46, 68, 44));
			    txtID.setBounds(133, 70, 241, 31);
			    panelDeLaAgenda.add(txtID);
			    txtID.setColumns(10);
			    	    			    			    			    			    	
			    txtNombres = new JTextField();
			    txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
			    txtNombres.setFont(new Font("Nokian", Font.BOLD, 11));
			    txtNombres.setForeground(new Color(46, 68, 44));
			    txtNombres.setBackground(new Color(160, 200, 120));
			    personalizarCampo(txtNombres, new Color(46, 68, 44));
			    txtNombres.setBounds(133, 109, 241, 31);
			    panelDeLaAgenda.add(txtNombres);
			    txtNombres.setColumns(10);
			    		    			    			    			    			    				    	
			    txtApellido = new JTextField();
			    txtApellido.setForeground(new Color(46, 68, 44));
			    txtApellido.setFont(new Font("Nokian", Font.BOLD, 11));
			    txtApellido.setBackground(new Color(160, 200, 120));
			    txtApellido.setBounds(133, 151, 241, 34);
			    personalizarCampo(txtApellido, new Color(46, 68, 44));
			    panelDeLaAgenda.add(txtApellido);
			    txtApellido.setColumns(10);
			    			    			    			    			    			    				    				    	
			    txtCorreo = new JTextField();
			    txtCorreo.setForeground(new Color(46, 68, 44));
			    txtCorreo.setFont(new Font("Nokian", Font.BOLD, 11));
			    txtCorreo.setBackground(new Color(160, 200, 120));
			    txtCorreo.setBounds(133, 196, 241, 34);
			    personalizarCampo(txtCorreo, new Color(46, 68, 44));
			    panelDeLaAgenda.add(txtCorreo);
			    txtCorreo.setColumns(10);
			    
			    JButton BTN_SAVE = new JButton("Guardar");
			    BTN_SAVE.setIcon(new ImageIcon(inicio.class.getResource("/img/guardar2.3.png")));
			    BTN_SAVE.setForeground(new Color(255, 255, 255));
			    BTN_SAVE.setBackground(new Color(46, 68, 44));
			    BTN_SAVE.setFont(new Font("Nokian", Font.BOLD, 18));
			    BTN_SAVE.addActionListener(new ActionListener() {
			    
			    @Override
				public void actionPerformed(ActionEvent e) {
	
//condiciones para guardar la informacion de la ventana principal

			    String i = txtID.getText();
			    String n = txtNombres.getText();
			    String a = txtApellido.getText();
			    String d = txtCorreo.getText();
			    String t = txtNumero.getText();
			    if (!i.isEmpty()) {
			    	if(!n.isEmpty()) {
			    		if(!a.isEmpty()){
			    			if(!d.isEmpty()) {
			    				if(!t.isEmpty()) {

			    			    	contacto con = new contacto(Integer.parseInt(i), n, a, d, t);
			    			    		Agenda.add(con);

			    			    			    			    			    			    				    				    				    				    							JOptionPane.showMessageDialog(null, "Contacto guardado con éxito!");
			    			    			    			    			    			    				    				    				    				    							txtID.setText("");
			    			    			    			    			    			    				    				    				    				    							txtNombres.setText("");
			    			    			    			    			    			    				    				    				    				    							txtApellido.setText("");
			    			    			    			    			    			    				    				    				    				    							txtCorreo.setText("");
			    			    			    			    			    			    				    				    				    				    							txtNumero.setText("");

			    			    			    			    			    			    				    				    				    				    							}else {
			    			    			    			    			    			    				    				    				    				    								JOptionPane.showMessageDialog(null, "El campo Numero esta vacio");
			    			    			    			    			    			    				    				    				    				    							}
			    			    			    			    			    			    				    				    				    				    						}else {
			    			    			    			    			    			    				    				    				    				    							JOptionPane.showMessageDialog(null, "El campo Correo esta vacío");
			    			    			    			    			    			    				    				    				    				    						}
			    			    			    			    			    			    				    				    				    				    					}else{
			    			    			    			    			    			    				    				    				    				    						JOptionPane.showMessageDialog(null, "El campo Apellido esta vacío");
			    			    			    			    			    			    				    				    				    				    					}
			    			    			    			    			    			    				    				    				    				    				}else{
			    			    			    			    			    			    				    				    				    				    					JOptionPane.showMessageDialog(null, "El campo Nombres está vacío");
			    			    			    			    			    			    				    				    				    				    					}
			    			    			    			    			    			    				    				    				    				    			}else{
			    			    			    			    			    			    				    				    				    				    				JOptionPane.showMessageDialog(null, "El campo ID está vacío");
			    			    			    			    			    			    				    				    				    				    			}

			    			    			    			    			    			    				    				    				    				    		}
			    			    			    			    			    			    				    				    				    				    	});
			    			    			    			    			    			    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    	//===============================================================
			    			    			    			    			    			    				    				    				    				    				    	//botones ventana principal
			    			    			    			    			    			    				    				    				    				    	//=====================================================================
			    			    			    			    			    			    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    	BTN_SAVE.setBounds(595, 388, 193, 34);
			    			    			    			    			    			    				    				    				    				    				    	panelDeLaAgenda.add(BTN_SAVE);
			    			    			    			    			    			    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    	//boton eliminar y sus funciones
			    			    			    			    			    			    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    	JButton btnEliminar = new JButton("Eliminar");
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.setIcon(new ImageIcon(inicio.class.getResource("/img/eliminar2.3.3.png")));
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.setForeground(new Color(255, 255, 255));
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.setBackground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.setFont(new Font("Nokian", Font.BOLD, 18));
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.addActionListener(new ActionListener() {
			    			    			    			    			    			    				    				    				    				    				    				    	    @Override
						public void actionPerformed(ActionEvent e) {
			    			    			    			    			    			    				    				    				    				    				    				    	        int fila = Jtable1.getSelectedRow();
			    			    			    			    			    			    				    				    				    				    				    				    	        if (fila >= 0) {
			    			    			    			    			    			    				    				    				    				    				    				    	            //Lo borramos de la lista lógica
			    			    			    			    			    			    				    				    				    				    				    				    	            Agenda.remove(fila);
			    			    			    			    			    			    				    				    				    				    				    				    	            //Lo borramos de la tabla visual
			    			    			    			    			    			    				    				    				    				    				    				    	            M.removeRow(fila);
			    			    			    			    			    			    				    				    				    				    				    				    	            JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente");
			    			    			    			    			    			    				    				    				    				    				    				    	        } else {
			    			    			    			    			    			    				    				    				    				    				    				    	            JOptionPane.showMessageDialog(null, "Selecciona un contacto de la tabla");
			    			    			    			    			    			    				    				    				    				    				    				    	        }
			    			    			    			    			    			    				    				    				    				    				    				    	    }
			    			    			    			    			    			    				    				    				    				    				    				    	});
			    			    			    			    			    			    				    				    				    				    				    				    	btnEliminar.setBounds(816, 388, 173, 34);
			    			    			    			    			    			    				    				    				    				    				    				    	panelDeLaAgenda.add(btnEliminar);
			    			    			    			    			    			    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    	//boton editar y sus funciones
			    			    			    			    			    			    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    	JButton btnEditar = new JButton("Editar");
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.setIcon(new ImageIcon(inicio.class.getResource("/img/editar2.3.png")));
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.setForeground(new Color(255, 255, 255));
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.setBackground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.setFont(new Font("Nokian", Font.BOLD, 18));
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.addActionListener(new ActionListener() {
			    			    			    			    			    			    				    				    				    				    				    				    				    	    @Override
						public void actionPerformed(ActionEvent e) {
			    			    			    			    			    			    				    				    				    				    				    				    				    	        int fila = Jtable1.getSelectedRow();
			    			    			    			    			    			    				    				    				    				    				    				    				    	        if (fila >= 0) {
			    			    			    			    			    			    				    				    				    				    				    				    				    	            // Obtenemos los nuevos datos de los cuadros de texto
			    			    			    			    			    			    				    				    				    				    				    				    				    	            int id = Integer.parseInt(txtID.getText());
			    			    			    			    			    			    				    				    				    				    				    				    				    	            String nom = txtNombres.getText();
			    			    			    			    			    			    				    				    				    				    				    				    				    	            String ape = txtApellido.getText();
			    			    			    			    			    			    				    				    				    				    				    				    				    	            String corr = txtCorreo.getText();
			    			    			    			    			    			    				    				    				    				    				    				    				    	            String tel = txtNumero.getText();

			    			    			    			    			    			    				    				    				    				    				    				    				    	            // Actualizamos el objeto en el ArrayList
			    			    			    			    			    			    				    				    				    				    				    				    				    	            contacto conEditado = new contacto(id, nom, ape, corr, tel);
			    			    			    			    			    			    				    				    				    				    				    				    				    	            Agenda.set(fila, conEditado);

			    			    			    			    			    			    				    				    				    				    				    				    				    	            // Actualizamos la tabla visualmente
			    			    			    			    			    			    				    				    				    				    				    				    				    	            M.setValueAt(id, fila, 0);
			    			    			    			    			    			    				    				    				    				    				    				    				    	            M.setValueAt(nom, fila, 1);
			    			    			    			    			    			    				    				    				    				    				    				    				    	            M.setValueAt(ape, fila, 2);
			    			    			    			    			    			    				    				    				    				    				    				    				    	            M.setValueAt(corr, fila, 3);
			    			    			    			    			    			    				    				    				    				    				    				    				    	            M.setValueAt(tel, fila, 4);

			    			    			    			    			    			    				    				    				    				    				    				    				    	            JOptionPane.showMessageDialog(null, "Contacto actualizado");
			    			    			    			    			    			    				    				    				    				    				    				    				    	        } else {
			    			    			    			    			    			    				    				    				    				    				    				    				    	            JOptionPane.showMessageDialog(null, "Selecciona qué contacto quieres editar");
			    			    			    			    			    			    				    				    				    				    				    				    				    	        }
			    			    			    			    			    			    				    				    				    				    				    				    				    	    }
			    			    			    			    			    			    				    				    				    				    				    				    				    	});
			    			    			    			    			    			    				    				    				    				    				    				    				    	btnEditar.setBounds(1020, 388, 156, 34);
			    			    			    			    			    			    				    				    				    				    				    				    				    	panelDeLaAgenda.add(btnEditar);
			    			    			    			    			    			    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	JScrollPane scrollPane = new JScrollPane();
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.setEnabled(false);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.setBorder(null);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.setViewportBorder(null);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.setBounds(390, 64, 807, 314);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.setBackground(new Color(160, 200, 120));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	scrollPane.getViewport().setBackground(new Color(160, 200, 120));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	panelDeLaAgenda.add(scrollPane);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	
			    		Jtable1 = new JTable();
			    		Jtable1.setColumnSelectionAllowed(true);
			    		Jtable1.setCellSelectionEnabled(true);
			    		Jtable1.setShowGrid(true);
			    		Jtable1.setGridColor(new Color(46, 68, 44));
			    		Jtable1.setFillsViewportHeight(true);
			    		Jtable1.setRowHeight(20);
			    		Jtable1.setIntercellSpacing(new Dimension(2, 2));
			    		Jtable1.setFont(new Font("Nokian", Font.BOLD, 14));
			    		Jtable1.setForeground(Color.WHITE);
			    		Jtable1.setBackground(new Color(160, 200, 120));
			    		Jtable1.getTableHeader().setBackground(new Color(46, 68, 44)); // Verde oscuro
			    		Jtable1.getTableHeader().setForeground(Color.WHITE);
			    		Jtable1.getTableHeader().setFont(new Font("Nokian", Font.BOLD, 14));
			    		Jtable1.getTableHeader().setBorder(new javax.swing.border.StrokeBorder(stroke, new Color(46, 68, 44)));
			    		//((DefaultTableCellRenderer)Jtable1.getDefaultRenderer(Object.class)).setOpaque(true);
			    		Jtable1.setBorder(new javax.swing.border.StrokeBorder(stroke, new Color(46, 68, 44)));
			    		scrollPane.setViewportView(Jtable1);
			    		
			    			    			    			    			    			    				    				    				    				    				    				    				    				    	Jtable1.addMouseListener(new java.awt.event.MouseAdapter() {
			    	    @Override
						public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	        int fila = Jtable1.getSelectedRow();
			    	        if (fila >= 0) {
			    	            // Pasamos los datos de la tabla a los cuadros de texto
			    	            txtID.setText(Jtable1.getValueAt(fila, 0).toString());
			    	            txtNombres.setText(Jtable1.getValueAt(fila, 1).toString());
			    	            txtApellido.setText(Jtable1.getValueAt(fila, 2).toString());
			    	            txtCorreo.setText(Jtable1.getValueAt(fila, 3).toString());
			    	            txtNumero.setText(Jtable1.getValueAt(fila, 4).toString());
			    	         }
			    	    }
			    	});
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	//boton mostrar y sus funciones
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	JButton btnMostrar = new JButton("Mostrar");
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	btnMostrar.setForeground(new Color(255, 255, 255));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	btnMostrar.setBackground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	btnMostrar.setFont(new Font("Nokian", Font.BOLD, 18));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	btnMostrar.addActionListener(new ActionListener() {
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		@Override
						public void actionPerformed(ActionEvent e) {


			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		        // IMPORTANTE: Limpia la tabla antes de mostrar para no duplicar datos
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		        M.setRowCount(0);

			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		        for (contacto element : Agenda) {
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            contacto c = element;

			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            // Creamos un arreglo con los datos exactos del contacto
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            // Asegúrate de que los nombres de los métodos (getId, etc) coincidan con tu clase contacto
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            Object fila[] = {
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		                c.getId(),
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		                c.getNombres(),
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		                c.getApellidos(),
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		                c.getCorreo(),
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		                c.getNumero()
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            };

			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            // Agregamos la fila completa de un solo golpe
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		            M.addRow(fila);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		        }
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		    }
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    		});
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    	btnMostrar.setBounds(429, 388, 129, 34);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    	panelDeLaAgenda.add(btnMostrar);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	//etiqueta numero con su caja de texto de la ventana principal
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	JLabel LBL_Numero = new JLabel("Telefono");
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero.setForeground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero.setFont(new Font("Nokian", Font.BOLD, 14));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero.setBounds(10, 250, 119, 14);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	panelDeLaAgenda.add(LBL_Numero);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero = new JTextField();
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero.setForeground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero.setFont(new Font("Nokian", Font.BOLD, 11));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero.setBackground(new Color(160, 200, 120));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero.setBounds(133, 241, 241, 34);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	personalizarCampo(txtNumero, new Color(46, 68, 44));
			    			    			    		    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	panelDeLaAgenda.add(txtNumero);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	txtNumero.setColumns(10);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	JLabel LBL_Numero_1 = new JLabel("");
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero_1.setIcon(new ImageIcon(inicio.class.getResource("/img/GYFANI.png")));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero_1.setForeground(new Color(46, 68, 44));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero_1.setFont(new Font("Nokian", Font.BOLD, 14));
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	LBL_Numero_1.setBounds(47, 265, 262, 183);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	panelDeLaAgenda.add(LBL_Numero_1);
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    				    				    				    				    	panelDeLaAgenda.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{LBLtAgT, LBL_ID, LBL_NOM, LBL_AP, LBL_EMAIL, txtID, txtNombres, txtApellido, txtCorreo, BTN_SAVE, scrollPane, Jtable1, btnMostrar, LBL_Numero, txtNumero, LBL_Numero_1}));

//===============================================================================
	//CONFIGURACIONES DE LA SEGUNDA PESTAÑA DEL PROGRAMA DE AGENDA TELEFONICA
//===============================================================================

		//nombre de la pestaña de consultas
		JPanel panelConsultas = new JPanel();
		panelConsultas.setBackground(new Color(160, 200, 120));
	    panelConsultas.setLayout(null);
	    pestania.addTab("Consultas y Estadísticas", panelConsultas);

	    //boton de busqueda de contactos de la agenda

	    JLabel lblBuscar = new JLabel("Buscar por apellido");
	    lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblBuscar.setForeground(new Color(46, 68, 44));
	    lblBuscar.setFont(new Font("Nokian", Font.BOLD, 14));
	    lblBuscar.setBounds(10, 14, 155, 20);
	    panelConsultas.add(lblBuscar);

	    JTextField txtFiltro = new JTextField();
	    txtFiltro.setForeground(new Color(46, 68, 44));
	    txtFiltro.setBackground(new Color(160, 200, 120));
	    txtFiltro.setFont(new Font("Nokian", Font.BOLD, 11));
	    txtFiltro.setBounds(217, 11, 173, 29);
	    personalizarCampo(txtFiltro, new Color(46, 68, 44));
	    panelConsultas.add(txtFiltro);

	    //Botón para Ordenar Alfabeticamente
	    JButton btnOrdenar = new JButton("A-Z");
	    btnOrdenar.setForeground(new Color(255, 255, 255));
	    btnOrdenar.setBackground(new Color(46, 68, 44));
	    btnOrdenar.setFont(new Font("Nokian", Font.BOLD, 11));
	    btnOrdenar.setBounds(400, 14, 64, 23);
	    panelConsultas.add(btnOrdenar);

	    //Barra de progreso
	    barraProgreso = new JProgressBar();
	    barraProgreso.setForeground(new Color(46, 68, 44));
	    barraProgreso.setFont(new Font("Nokian", Font.BOLD, 11));
	    barraProgreso.setBounds(97, 423, 512, 14);
	    barraProgreso.setStringPainted(true); // Muestra el porcentaje %
	    barraProgreso.setVisible(false); // Empieza oculta
	    panelConsultas.add(barraProgreso);

	    //Tabla de la segunda pestaña
	    JScrollPane scrollConsultas = new JScrollPane();
	    scrollConsultas.setEnabled(false);
	    scrollConsultas.setBounds(390, 64, 807, 314);
	    scrollConsultas.setBackground(new Color(160, 200, 120));
	    scrollConsultas.getViewport().setBackground(new Color(160, 200, 120));
	    panelConsultas.add(scrollConsultas);


	    // Encabezado de la segunda tabla (TABLA DE CONSULTAS)
	    tablaConsultas = new JTable();
	    tablaConsultas.setShowVerticalLines(false);
	    tablaConsultas.setShowHorizontalLines(false);
	    tablaConsultas.setShowGrid(false);
	    tablaConsultas.setBorder(null);
	    tablaConsultas.setEnabled(false);
		tablaConsultas.setIntercellSpacing(new Dimension(2, 2));
	    tablaConsultas.setRowHeight(20);
	    tablaConsultas.setFillsViewportHeight(true);
	    tablaConsultas.setBackground(new Color(160, 200, 120));
	    tablaConsultas.setForeground(new Color(46, 68, 44));
	    tablaConsultas.setFont(new Font("Nokian", Font.BOLD, 14));
	    tablaConsultas.getTableHeader().setBackground(new Color(46, 68, 44)); // Verde oscuro
	    tablaConsultas.getTableHeader().setForeground(Color.WHITE);
	    tablaConsultas.getTableHeader().setFont(new Font("Nokian", Font.BOLD, 14));
		tablaConsultas.getTableHeader().setBorder(new javax.swing.border.StrokeBorder(stroke, new Color(46, 68, 44)));
		tablaConsultas.setBorder(new javax.swing.border.StrokeBorder(stroke, new Color(46, 68, 44)));
	    modeloConsultas = new DefaultTableModel(null, new String[]{"I D", "Nombres", "Apellidos", "Correo", "Numero"});
	    tablaConsultas.setModel(modeloConsultas);

	    //MEDIDAS DE LAS CELDAS DE LA SEGUNDA TABLA

	    tablaConsultas.getColumnModel().getColumn(0).setPreferredWidth(35);//ID
	    tablaConsultas.getColumnModel().getColumn(1).setPreferredWidth(80);//NOMBRE
	    tablaConsultas.getColumnModel().getColumn(2).setPreferredWidth(80);//APELLIDO
	    tablaConsultas.getColumnModel().getColumn(3).setPreferredWidth(115);//CORREO
	    tablaConsultas.getColumnModel().getColumn(4).setPreferredWidth(40);//NUMERO
	    scrollConsultas.setViewportView(tablaConsultas);

	    //CONTADOR DE CONTACTOS
	    JLabel txtTotal = new JLabel("Total contactos: 0");
	    txtTotal.setForeground(new Color(46, 68, 44));
	    txtTotal.setFont(new Font("Nokian", Font.BOLD, 14));
	    txtTotal.setBounds(180, 346, 214, 20);
	    panelConsultas.add(txtTotal);

	    txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
	        @Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
	            String busqueda = txtFiltro.getText().toLowerCase();
	            modeloConsultas.setRowCount(0); // Limpiar tabla de consultas

	            for (Object obj : Agenda) {
	                contacto c = (contacto) obj;
	                if (c.getApellidos().toLowerCase().contains(busqueda)) {
	                    modeloConsultas.addRow(new Object[]{c.getId(), c.getNombres(), c.getApellidos(), c.getCorreo(), c.getNumero()});
	                }
	            }
	            // Actualizar estadística rápida
	            txtTotal.setText("Resultados encontrados: " + modeloConsultas.getRowCount());
	        }
	    });
	    btnOrdenar.addActionListener(e -> {
	        // Ordenamos el ArrayList Agenda comparando los apellidos
	        Agenda.sort((o1, o2) -> o1.getApellidos().compareToIgnoreCase(o2.getApellidos()));

	        // Refrescar la tabla de la pestaña 2
	        txtFiltro.setText(""); // Limpiamos filtro para mostrar todos
	        modeloConsultas.setRowCount(0);
	        for (Object obj : Agenda) {
	            contacto c = (contacto) obj;
	            modeloConsultas.addRow(new Object[]{c.getId(), c.getNombres(), c.getApellidos(), c.getCorreo(), c.getNumero()});
	        }
	        JOptionPane.showMessageDialog(null, "Lista ordenada por apellidos");
	    });
	 // Título de la sección
	    JLabel lblTituloEst = new JLabel("Estadística  por  Dominio  de  Correo");
	    lblTituloEst.setForeground(new Color(46, 68, 44));
	    lblTituloEst.setFont(new Font("Nokian", Font.BOLD, 14));
	    lblTituloEst.setBounds(10, 51, 380, 20);
	    panelConsultas.add(lblTituloEst);

	    // Etiquetas para los resultados
	    lblGmail = new JLabel("Gmail: 0");
	    lblGmail.setIcon(null);
	    lblGmail.setForeground(new Color(46, 68, 44));
	    lblGmail.setFont(new Font("Nokian", Font.BOLD, 14));
	    lblGmail.setBounds(57, 186, 84, 20);
	    panelConsultas.add(lblGmail);

	    lblOutlook = new JLabel("Outlook/Hotmail: 0");
	    lblOutlook.setForeground(new Color(46, 68, 44));
	    lblOutlook.setFont(new Font("Nokian", Font.BOLD, 14));
	    lblOutlook.setBounds(196, 186, 155, 20);
	    panelConsultas.add(lblOutlook);

	    lblOtros = new JLabel("Otros: 0");
	    lblOtros.setForeground(new Color(46, 68, 44));
	    lblOtros.setFont(new Font("Nokian", Font.BOLD, 14));
	    lblOtros.setBounds(57, 346, 64, 20);
	    panelConsultas.add(lblOtros);

	    // Botón para procesar la estadística
	    JButton btnAnalizar = new JButton("Analizar Correos");
	    btnAnalizar.setForeground(new Color(255, 255, 255));
	    btnAnalizar.setBackground(new Color(46, 68, 44));
	    btnAnalizar.setFont(new Font("Nokian", Font.BOLD, 18));
	    btnAnalizar.setBounds(654, 389, 291, 42);
	    panelConsultas.add(btnAnalizar);

	    btnAnalizar.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {
	            // 1. Validar si hay contactos para analizar
	            if (Agenda.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "No hay contactos para analizar");
	                return;
	            }

	            //Preparar la barra
	            barraProgreso.setVisible(true);
	            barraProgreso.setValue(0);
	            btnAnalizar.setEnabled(false); // Desactivar botón durante proceso

	            //Crear un Timer para simular el progreso
	            javax.swing.Timer timer = new javax.swing.Timer(15, new ActionListener() {
	                int progreso = 0;

	                @Override
	                public void actionPerformed(ActionEvent e2) {
	                    progreso++;
	                    barraProgreso.setValue(progreso);

	                    // Cuando llega al 100%
	                    if (progreso == 100) {
	                        ((javax.swing.Timer)e2.getSource()).stop(); // Detener timer

	                        //LÓGICA DE CONTEO
	                        int gmail = 0, outlook = 0, otros = 0;
	                        for (Object obj : Agenda) {
	                            contacto c = (contacto) obj;
	                            String correo = c.getCorreo().toLowerCase();
	                            if (correo.contains("@gmail")) {
									gmail++;
								} else if (correo.contains("@outlook") || correo.contains("@hotmail")) {
									outlook++;
								} else if (!correo.isEmpty()) {
									otros++;
								}
	                        }

	                        //Actualizar etiquetas
	                        lblGmail.setText("Gmail: " + gmail);
	                        lblOutlook.setText("Outlook: " + outlook);
	                        lblOtros.setText("Otros: " + otros);

	                        // Finalizar visualmente
	                        JOptionPane.showMessageDialog(null, "Análisis finalizado con éxito");
	                        barraProgreso.setVisible(false);
	                        btnAnalizar.setEnabled(true);
	                    }
	                }
	            });
	            timer.start(); // Iniciar la carga
	        }
	    });

	 // ==========================================
	 // BOTÓN EXPORTAR (En panelConsultas)
	 // ==========================================
	 //Declaramos el botón indicando el tipo de objeto (JButton)
	    
	    JButton btnExportarCSV = new JButton("Exportar Lista");
	    btnExportarCSV.setForeground(new Color(255, 255, 255));
	    btnExportarCSV.setBackground(new Color(46, 68, 44));
	    btnExportarCSV.setBounds(992, 389, 187, 42);
	    btnExportarCSV.setFont(new Font("Nokian", Font.BOLD, 18));
	    panelConsultas.add(btnExportarCSV);
	    
	    JLabel Lupita = new JLabel("");
	    Lupita.setIcon(new ImageIcon(inicio.class.getResource("/img/LUPITA.png")));
	    Lupita.setBounds(175, -2, 32, 42);
	    panelConsultas.add(Lupita);
	    
	    JLabel LBLCyE = new JLabel("ESTADISTICAS Y CONSULTAS");
	    LBLCyE.setForeground(new Color(46, 68, 44));
	    LBLCyE.setFont(new Font("BM neco", Font.PLAIN, 42));
	    LBLCyE.setBounds(486, 4, 734, 49);
	    panelConsultas.add(LBLCyE);
	    
	    JLabel ICOtros_1 = new JLabel("");
	    ICOtros_1.setIcon(new ImageIcon(inicio.class.getResource("/img/inter2.3.png")));
	    ICOtros_1.setBounds(213, 249, 100, 97);
	    panelConsultas.add(ICOtros_1);
	    
	    JLabel ICOtros_1_1 = new JLabel("");
	    ICOtros_1_1.setIcon(new ImageIcon(inicio.class.getResource("/img/OTROSiNTERFAZ2.3.png")));
	    ICOtros_1_1.setBounds(37, 249, 125, 97);
	    panelConsultas.add(ICOtros_1_1);
	    
	    JLabel Lupita_1_1_1 = new JLabel("");
	    Lupita_1_1_1.setIcon(new ImageIcon(inicio.class.getResource("/img/OUTLOOKINTER2.3.png")));
	    Lupita_1_1_1.setBounds(208, 64, 155, 123);
	    panelConsultas.add(Lupita_1_1_1);
	    
	    JLabel Lupita_1_1_1_1 = new JLabel("");
	    Lupita_1_1_1_1.setIcon(new ImageIcon(inicio.class.getResource("/img/GOOGLEINTER2.3.png")));
	    Lupita_1_1_1_1.setBounds(37, 64, 125, 123);
	    panelConsultas.add(Lupita_1_1_1_1);
//=================================================================================================	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(160, 200, 120));
	    pestania.addTab("Configuraciones", null, panel, null);
	    panel.setLayout(null);
	    
	    JLabel lblConfiguracionesID = new JLabel("idioma");
	    lblConfiguracionesID.setForeground(new Color(46, 68, 44));
	    lblConfiguracionesID.setFont(new Font("BM neco", Font.PLAIN, 60));
	    lblConfiguracionesID.setBounds(236, 11, 393, 89);
	    lblConfiguracionesID.setVerticalAlignment(SwingConstants.TOP);
	    panel.add(lblConfiguracionesID);
	    
	    JComboBox CmbIdioma = new JComboBox();
	    CmbIdioma.setBackground(new Color(46, 68, 44));
	    CmbIdioma.setForeground(new Color(255, 255, 255));
	    CmbIdioma.setFont(new Font("Nokian", Font.BOLD, 65));
	    CmbIdioma.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    		String combo = CmbIdioma.getSelectedItem().toString();
	    		//idioma ingles
	    		//ventana 1
	    		if(combo.equals("English")) 
	    		{
	    		LBL_ID.setText("Identification");
	    		LBL_NOM.setText("Name");
	    		LBL_AP.setText("Last Name");
	    		LBL_Numero.setText("Phone Number");
	    		LBLtAgT.setText("Contact Manager");
	    		btnMostrar.setText("Show");
	    		BTN_SAVE.setText("Save");
	    		btnEliminar.setText("Delete");
	    		btnEditar.setText("Edit");
	    		//ventana 2
	    		lblBuscar.setText("Search");
	    		lblTituloEst.setText("Email  Domain  Statistics");
	    		LBLCyE.setText("Query and Statistics");
	    		lblOtros.setText("Others:");
	    		txtTotal.setText("Contacts Count:");
	    		btnAnalizar.setText("Scan  Emails");
	    		btnExportarCSV.setText("Export  List");
	    		//Ventana3
	    	
	    		lblConfiguracionesID.setText("Language");
	    		
	    	}
	    		else if(combo.equals("French"))
	    	{
    		LBL_ID.setText("Identification");
    		LBL_NOM.setText("Prenom");
    		LBL_AP.setText("Nom");
    		LBL_Numero.setText("Telephone");
    		LBLtAgT.setText("Gestionnaire de Contacts");
    		btnMostrar.setText("Afficher");
    		BTN_SAVE.setText("Engregistrer");
    		btnEliminar.setText("Supprimer");
    		btnEditar.setText("Modifier");
    		//ventana 2
    		lblBuscar.setText("Chercher");
    		lblTituloEst.setText("Statistiques par Domaine de Messagerie");
    		LBLCyE.setText("Consultation et Statistiques");
    		lblOtros.setText("Autres:");
    		txtTotal.setText("Contacts Count:");
    		btnAnalizar.setText("Analyser les E-mails");
    		btnExportarCSV.setText("Exporter  Liste");
    		//Ventana3
    	
    		lblConfiguracionesID.setText("Langue");
	    	}
	    	else 
	    	{
	    		LBL_ID.setText("Identificacion");
	    		LBL_NOM.setText("Nombre");
	    		LBL_AP.setText("Apellido");
	    		LBL_Numero.setText("Telefono");
	    		LBLtAgT.setText("Agenda  Telefonica");
	    		btnMostrar.setText("Mostrar");
	    		BTN_SAVE.setText("Guardar");
	    		btnEliminar.setText("Eliminar");
	    		btnEditar.setText("Editar");
	    		//ventana 2
	    		lblBuscar.setText("Buscar por apellido");
	    		lblTituloEst.setText("Estadisticas por Dominio de Correo ");
	    		LBLCyE.setText("Consultas y estadisticas");
	    		lblOtros.setText("Otros:");
	    		txtTotal.setText("Total contactos:");
	    		btnAnalizar.setText("Analizar correos");
	    		btnExportarCSV.setText("Exportar lista");
	    		//ventana3
	    		lblConfiguracionesID.setText("idioma");
	    	}
	    	}
	    	
	    	
	    	
	    	}
	    	
	    );
	    CmbIdioma.setModel(new DefaultComboBoxModel(new String[] {"Spanish", "English", "French"}));
	    CmbIdioma.setBounds(236, 101, 393, 148);
	    panel.add(CmbIdioma);
	    
	   
	    
	    
//=================================================================================================
	    btnExportarCSV.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {

	            if (modeloConsultas.getRowCount() == 0) {
	                JOptionPane.showMessageDialog(null, "No hay datos en la tabla de consultas para exportar.");
	                return;
	            }

	            JFileChooser selector = new JFileChooser();
	            selector.setDialogTitle("Exportar Resultados Ordenados");
	            selector.setFileFilter(new FileNameExtensionFilter("Archivo CSV (*.csv)", "csv"));

	            // Corregido: Usamos JFileChooser.APPROVE_OPTION que es el estándar
	            int resultado = selector.showSaveDialog(null);

	            if (resultado == JFileChooser.APPROVE_OPTION) {
	                String ruta = selector.getSelectedFile().getAbsolutePath();

	                // Asegurar extensión .csv
	                if (!ruta.toLowerCase().endsWith(".csv")) {
	                    ruta += ".csv";
	                }

	                try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
	                    // Escribimos los encabezados (5 columnas según tu tabla)
	                    pw.println("ID;Nombres;Apellidos;Correo;Numero");

	                    // Recorremos las filas del MODELO
	                    for (int i = 0; i < modeloConsultas.getRowCount(); i++) {
	                        String id = (modeloConsultas.getValueAt(i, 0) != null) ? modeloConsultas.getValueAt(i, 0).toString() : "";
	                        String nom = (modeloConsultas.getValueAt(i, 1) != null) ? modeloConsultas.getValueAt(i, 1).toString() : "";
	                        String ape = (modeloConsultas.getValueAt(i, 2) != null) ? modeloConsultas.getValueAt(i, 2).toString() : "";
	                        String cor = (modeloConsultas.getValueAt(i, 3) != null) ? modeloConsultas.getValueAt(i, 3).toString() : "";
	                        String num = (modeloConsultas.getValueAt(i, 4) != null) ? modeloConsultas.getValueAt(i, 4).toString() : "";

	                        pw.println(id + ";" + nom + ";" + ape + ";" + cor + ";" + num);
	                    }

	                    JOptionPane.showMessageDialog(null, "¡Lista exportada correctamente!");
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(null, "Error al escribir el archivo: " + ex.getMessage());
	                }
	            }
	        }
	    });

		CrearModelo();
	}

//============================================================
		//LINEA PUNTUADA PARA CAMPOS DE TEXTO Y OTROS.
//============================================================
		private void personalizarCampo(JTextField campo, Color color) {

			float[] dash = {6f, 4f};
			BasicStroke stroke = new BasicStroke(
					3,
					BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_MITER,
					10.0f,
					dash,
					0.0f
			);

			// 2. Crear el borde punteado
			StrokeBorder bordePunteado = new StrokeBorder(stroke, color);

			// 3. Crear un margen interno (Padding) para que el texto no toque el borde
			// (Arriba, Izquierda, Abajo, Derecha)
			EmptyBorder margenInterno = new EmptyBorder(0, 8, 0, 8);

			// 4. Combinar ambos bordes y aplicar
			campo.setBorder(new CompoundBorder(bordePunteado, margenInterno));

			// Tip extra: Cambiar la fuente para que combine con el estilo
			campo.setFont(new Font("Nokian", Font.BOLD, 14));




		}
}

	