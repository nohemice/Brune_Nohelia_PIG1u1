package formulario;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.StrokeBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke; 

import org.eclipse.wb.swing.FocusTraversalOnArray;

import clase.contacto;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private JPanel contentPane, panelDeLaAgenda;
	private JLabel lblGmail, lblOutlook, lblOtros;
	private JTabbedPane pestania;
	private JTextField txtID, txtNombres, txtApellido, txtCorreo, txtNumero;
	private JTable Jtable1, tablaConsultas;
	private JButton BTN_SAVE;
	
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
			    EstiloComponentes.aplicarEstiloTitulos(LBLtAgT);
			    LBLtAgT.setBounds(164, 0, 995, 59);
			    panelDeLaAgenda.add(LBLtAgT);
			    
			    JLabel LBL_ID = new JLabel("Identificacion");
			    EstiloComponentes.aplicarEstiloLabel(LBL_ID);
			    LBL_ID.setBounds(10, 74, 119, 14);
			    panelDeLaAgenda.add(LBL_ID);
			    
			    JLabel LBL_NOM = new JLabel("Nombres");
			    EstiloComponentes.aplicarEstiloLabel(LBL_NOM);
			    LBL_NOM.setBounds(10, 114, 75, 14);
			    panelDeLaAgenda.add(LBL_NOM);
			    	    
			    JLabel LBL_AP = new JLabel("Apellido");
			    EstiloComponentes.aplicarEstiloLabel(LBL_AP);
			    LBL_AP.setBounds(10, 160, 119, 14);
			    panelDeLaAgenda.add(LBL_AP);
			    			    			    			    
			    JLabel LBL_EMAIL = new JLabel("E-mail");
			    EstiloComponentes.aplicarEstiloLabel(LBL_EMAIL);
			    LBL_EMAIL.setBounds(10, 205, 75, 14);
			    panelDeLaAgenda.add(LBL_EMAIL);
			    			    			    			    			    
			    // campos de texto de la ventana principal
			    			    			    
			    txtID = new JTextField();
			    EstiloComponentes.EstiloCampo(txtID, PaletaNokia.VERDE_OSCURO);
			    txtID.setBounds(133, 70, 241, 31);
			    panelDeLaAgenda.add(txtID);
			    txtID.setColumns(10);
			    	    			    			    			    			    	
			    txtNombres = new JTextField();
			    txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
			    EstiloComponentes.EstiloCampo(txtNombres, PaletaNokia.VERDE_OSCURO);
			    txtNombres.setBounds(133, 109, 241, 31);
			    panelDeLaAgenda.add(txtNombres);
			    txtNombres.setColumns(10);
			    		    			    			    			    			    				    	
			    txtApellido = new JTextField();
			    EstiloComponentes.EstiloCampo(txtApellido, PaletaNokia.VERDE_OSCURO);
			    txtApellido.setBounds(133, 151, 241, 34);
			    panelDeLaAgenda.add(txtApellido);
			    txtApellido.setColumns(10);
			    			    			    			    			    			    				    				    	
			    txtCorreo = new JTextField();
			    EstiloComponentes.EstiloCampo(txtCorreo, PaletaNokia.VERDE_OSCURO);
			    txtCorreo.setBounds(133, 196, 241, 34);
			    panelDeLaAgenda.add(txtCorreo);
			    txtCorreo.setColumns(10);
			    
  	//===============================================================
	//botones ventana principal
	//=====================================================================
			    				    				    	
		JButton BTN_SAVE = new JButton("Guardar");
		BTN_SAVE.setBounds(536, 389, 187, 42);
		EstiloComponentes.aplicarEstiloBoton(BTN_SAVE);
		BTN_SAVE.setIcon(new ImageIcon(inicio.class.getResource("/img/guardar2.3.png")));
		panelDeLaAgenda.add(BTN_SAVE);
		
		BTN_SAVE.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        // --- VALIDACIÓN DE CAMPOS VACÍOS ---
		       
		        if (txtID.getText().trim().isEmpty() || 
		            txtNombres.getText().trim().isEmpty() || 
		            txtNumero.getText().trim().isEmpty()) {
		            
		            inicio.this.mostrarNotificacion("Error: Por favor rellene todos los campos del formulario");
		            return; // Detiene la ejecución aquí mismo
		        }

		        try {
		            // 1. Capturar datos de los campos de texto
		            
		            int idInt = Integer.parseInt(txtID.getText().trim());
		            String nom = txtNombres.getText();
		            String ape = txtApellido.getText();
		            String mail = txtCorreo.getText();
		            String num = txtNumero.getText();

		            // 2. Ejecutar proceso en segundo plano
		            //hilo de validacion
		            SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
		                @Override
		                protected Boolean doInBackground() throws Exception {
		                    inicio.this.actualizarEstadoUI(true);

		                    synchronized (Agenda) {
		                    
		                    for (contacto c : Agenda) {
		                        if (c.getnumero().equals(num)) {
		                            return false; // Duplicado encontrado
		                        }
		                    }

		                    Thread.sleep(600); 
		                    Agenda.add(new contacto(idInt, nom, ape, mail, num));
		                    }
		                    return true;
		                
		                }
		                @Override
		                protected void done() {
		                    try {
		                        boolean exito = get();
		                        inicio.this.actualizarEstadoUI(false);

		                        if (exito) {
		                            inicio.this.mostrarNotificacion("Contacto guardado exitosamente");
		                            inicio.this.limpiarCampos();
		                            inicio.this.refrescarTabla();
		                        } else {
		                            inicio.this.mostrarNotificacion("Error: El número ya está registrado");
		                        }
		                    } catch (Exception ex) {
		                        ex.printStackTrace();
		                        inicio.this.actualizarEstadoUI(false);
		                    }
		                }
		            };
		            worker.execute();

		        } catch (NumberFormatException nfe) {
		            // Por si el usuario escribe letras en el campo ID
		            inicio.this.mostrarNotificacion("Error: El ID debe ser un número válido");
		        }
		    }
		});
		
	//boton eliminar y sus funciones
	JButton btnEliminar = new JButton("Eliminar");
	btnEliminar.setIcon(new ImageIcon(inicio.class.getResource("/img/eliminar2.3.3.png")));
	EstiloComponentes.aplicarEstiloBoton(btnEliminar);
	btnEliminar.setBounds(776, 389, 187, 42);
	btnEliminar.addActionListener(new ActionListener() {
	
		@Override
	public void actionPerformed(ActionEvent e) {
	int fila = Jtable1.getSelectedRow();
	if (fila >= 0) {          //Lo borramos de la lista lógica
	 Agenda.remove(fila);
	 //Lo borramos de la tabla visual
	 M.removeRow(fila);
	 JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente");
	  } else {
	  JOptionPane.showMessageDialog(null, "Selecciona un contacto de la tabla");
	  	}
	   }
	});
	
			  panelDeLaAgenda.add(btnEliminar);
		 	//boton editar y sus funciones
		   	JButton btnEditar = new JButton("Editar");
		 	btnEditar.setIcon(new ImageIcon(inicio.class.getResource("/img/editar2.3.png")));
		 	EstiloComponentes.aplicarEstiloBoton(btnEditar);
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
			    	  	btnEditar.setBounds(992, 389, 187, 42);
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
			    		EstiloComponentes.EstiloTabla(Jtable1);
			    		scrollPane.setViewportView(Jtable1);
			    		CrearModelo();
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
			    			    			    			    			    			    				    				    				    				    				    				    				    				    				    		    			    				    				    				    				    				    				    				    				    				    				    				    	
	JLabel LBL_Numero = new JLabel("Telefono");
	EstiloComponentes.aplicarEstiloLabel(LBL_Numero);
	LBL_Numero.setBounds(10, 250, 119, 14);
	panelDeLaAgenda.add(LBL_Numero);
			    			   
	txtNumero = new JTextField();
	txtNumero.setBounds(133, 241, 241, 34);
	EstiloComponentes.EstiloCampo(txtNumero, PaletaNokia.VERDE_OSCURO);
	panelDeLaAgenda.add(txtNumero);
	txtNumero.setColumns(10);
	 	//GATO DE LA PESTA;A PRINCIPAL
	JLabel LBL_Numero_1 = new JLabel("");
	LBL_Numero_1.setIcon(new ImageIcon(inicio.class.getResource("/img/GYFANI.png")));
	LBL_Numero_1.setBounds(47, 265, 262, 183);
	panelDeLaAgenda.add(LBL_Numero_1);
	//BOTON DE BUSQUEDA RAPIDA
	JButton btnLupa = new JButton("");
	EstiloComponentes.aplicarEstiloBoton(btnLupa);
	btnLupa.setIcon(new ImageIcon(inicio.class.getResource("/img/mostrar2.3.png")));
	btnLupa.setBounds(390, 389, 107, 42);
	btnLupa.setToolTipText("Buscar contactos (Ctrl+F)"); // Muestra ayuda al pasar el ratón
	panelDeLaAgenda.add(btnLupa);
	Action accionBuscar = new AbstractAction() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	       inicio.this.mostrarPopupBusqueda();
	    }
	};

	// 3. Ahora lo vinculas
	btnLupa.addActionListener(accionBuscar);
	
	JPanel root = (JPanel) this.getContentPane();
	root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
	    .put(KeyStroke.getKeyStroke("control F"), "abrirBuscador");
	root.getActionMap().put("abrirBuscador", accionBuscar);
	
	panelDeLaAgenda.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{LBLtAgT, LBL_ID, LBL_NOM, LBL_AP, LBL_EMAIL, txtID, txtNombres, txtApellido, txtCorreo, BTN_SAVE, scrollPane, Jtable1, LBL_Numero, txtNumero, LBL_Numero_1, btnLupa}));
	
//========================================================
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
	    EstiloComponentes.aplicarEstiloLabel(lblBuscar);
	    lblBuscar.setBounds(10, 14, 155, 20);
	    panelConsultas.add(lblBuscar);

	    JTextField txtFiltro =new JTextField();
	    EstiloComponentes.EstiloCampo(txtFiltro, PaletaNokia.VERDE_OSCURO);
	    txtFiltro.setBounds(217, 11, 173, 29);
	    panelConsultas.add(txtFiltro);

	    //Botón para Ordenar Alfabeticamente
	    JButton btnOrdenar = new JButton("A-Z");
	    EstiloComponentes.aplicarEstiloBoton(btnOrdenar);
	    btnOrdenar.setBounds(400, 6, 76, 39);
	    panelConsultas.add(btnOrdenar);
 
	    //Barra de progreso
	    barraProgreso = new JProgressBar();
	    barraProgreso.setForeground(new Color(46, 68, 44));
	    barraProgreso.setFont(new Font("Nokian", Font.BOLD, 11));
	    barraProgreso.setBounds(97, 417, 512, 20);
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
	    modeloConsultas = new DefaultTableModel(null, new String[]{"I D", "Nombres", "Apellidos", "Correo", "Numero"});
	    tablaConsultas.setModel(modeloConsultas);
	    EstiloComponentes.EstiloTabla(tablaConsultas);
	    //MEDIDAS DE LAS CELDAS DE LA SEGUNDA TABLA

	    tablaConsultas.getColumnModel().getColumn(0).setPreferredWidth(35);//ID
	    tablaConsultas.getColumnModel().getColumn(1).setPreferredWidth(80);//NOMBRE
	    tablaConsultas.getColumnModel().getColumn(2).setPreferredWidth(80);//APELLIDO
	    tablaConsultas.getColumnModel().getColumn(3).setPreferredWidth(115);//CORREO
	    tablaConsultas.getColumnModel().getColumn(4).setPreferredWidth(40);//NUMERO
	    scrollConsultas.setViewportView(tablaConsultas);

	    //CONTADOR DE CONTACTOS
	    JLabel txtTotal = new JLabel("Total contactos: 0");
	    EstiloComponentes.aplicarEstiloLabel(txtTotal);
	    txtTotal.setBounds(180, 346, 214, 20);
	    panelConsultas.add(txtTotal);

	    txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
	        @Override
			public void keyReleased(java.awt.event.KeyEvent evt) {
	            String busqueda = txtFiltro.getText().toLowerCase();
	            modeloConsultas.setRowCount(0); // Limpiar tabla de consultas

	            for (Object obj : Agenda) {
	                contacto c = (contacto) obj;
	                if (c.getapellidos().toLowerCase().contains(busqueda)) {
	                    modeloConsultas.addRow(new Object[]{c.getid(), c.getnombres(), c.getapellidos(), c.getcorreo(), c.getnumero()});
	                }
	            }
	            // Actualizar estadística rápida
	            txtTotal.setText("Resultados encontrados: " + modeloConsultas.getRowCount());
	        }
	    });
	    btnOrdenar.addActionListener(e -> {
	        // Ordenamos el ArrayList Agenda comparando los apellidos
	        Agenda.sort((o1, o2) -> o1.getapellidos().compareToIgnoreCase(o2.getapellidos()));

	        // Refrescar la tabla de la pestaña 2
	        txtFiltro.setText(""); // Limpiamos filtro para mostrar todos
	        modeloConsultas.setRowCount(0);
	        for (Object obj : Agenda) {
	            contacto c = (contacto) obj;
	            modeloConsultas.addRow(new Object[]{c.getid(), c.getnombres(), c.getapellidos(), c.getcorreo(), c.getnumero()});
	        }
	        JOptionPane.showMessageDialog(null, "Lista ordenada por apellidos");
	    });
	 // Título de la sección
	    JLabel lblTituloEst = new JLabel("Estadística  por  Dominio  de  Correo");
	    EstiloComponentes.aplicarEstiloLabel(lblTituloEst);
	    lblTituloEst.setBounds(10, 51, 380, 20);
	    panelConsultas.add(lblTituloEst);

	    // Etiquetas para los resultados
	    lblGmail = new JLabel("Gmail: 0");
	    lblGmail.setIcon(null);
	    EstiloComponentes.aplicarEstiloLabel(lblGmail);
	    lblGmail.setBounds(57, 186, 84, 20);
	    panelConsultas.add(lblGmail);

	    lblOutlook = new JLabel("Outlook/Hotmail: 0");
	    EstiloComponentes.aplicarEstiloLabel(lblOutlook);
	    lblOutlook.setBounds(196, 186, 155, 20);
	    panelConsultas.add(lblOutlook);

	    lblOtros = new JLabel("Otros: 0");
	    EstiloComponentes.aplicarEstiloLabel(lblOtros);
	    lblOtros.setBounds(57, 346, 64, 20);
	    panelConsultas.add(lblOtros);

	    // Botón para procesar la estadística
	    JButton btnAnalizar = new JButton("Analizar Correos");
	    EstiloComponentes.aplicarEstiloBoton(btnAnalizar);
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
	                            String correo = c.getcorreo().toLowerCase();
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
	    EstiloComponentes.aplicarEstiloBoton(btnExportarCSV);
	    btnExportarCSV.setBounds(992, 389, 187, 42);
	    panelConsultas.add(btnExportarCSV);
	    //ICONOS DE LOS BOTONES
	    JLabel Lupita = new JLabel("");
	    Lupita.setIcon(new ImageIcon(inicio.class.getResource("/img/LUPITA.png")));
	    Lupita.setBounds(175, -2, 32, 42);
	    panelConsultas.add(Lupita);
	    
	    JLabel LBLCyE = new JLabel("ESTADISTICAS Y CONSULTAS");
	    EstiloComponentes.aplicarEstiloTitulos(LBLCyE);
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
	                    // Escribimos los encabezados
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
	    
	}
	
	public void filtrarPorApellido(String busqueda) {
	    // 1. Limpiamos la tabla de la pestaña 2 para meter solo lo que encontremos
	    modeloConsultas.setRowCount(0); 

	    // 2. Buscamos en tu ArrayList 'Agenda'
	    for (Object obj : Agenda) {
	        contacto c = (contacto) obj; // Convertimos el objeto a tipo contacto
	        
	        // Comparamos el apellido (todo en minúsculas para que no falle)
	        if (c.getapellidos().toLowerCase().contains(busqueda.toLowerCase())) {
	            // Si coincide, lo agregamos a la tabla de consultas
	            modeloConsultas.addRow(new Object[]{
	                c.getid(), c.getnombres(), c.getapellidos(), c.getcorreo(), c.getnumero()
	            });
	        }
	    }
	    
	}
	
	private void mostrarPopupBusqueda() {
	   //JDialog que servirá como barra de búsqueda flotante
	    JDialog popup = new JDialog(this, "Buscar Rápido", false); 
	    popup.setUndecorated(false); // Estilo retro sin bordes
	    popup.setSize(400, 300);
	    popup.setLocationRelativeTo(this); // Centrado sobre la ventana principal
	    
	    JPanel panelPrincipal = new JPanel(new BorderLayout());
	    panelPrincipal.setBackground(new Color(160, 200, 120));
	    
	    JPanel panelBusqueda = new JPanel(new BorderLayout());
	    panelBusqueda.setBorder(BorderFactory.createLineBorder(new Color(46, 68, 44), 2));
	    panelBusqueda.setBackground(new Color(160, 200, 120));

	    // Campo de texto con tu fuente Nokian
	    JTextField txtPopUp = new JTextField(" Escriba para buscar...");
	    txtPopUp.setFont(new Font("Nokian", Font.BOLD, 14));
	    txtPopUp.setBackground(new Color(160, 200, 120));
	    txtPopUp.setForeground(new Color(46, 68, 44));
	    txtPopUp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(46, 68, 44))); // Línea inferior

	    String[] columnas = {"Nombre", "Numero", "Email"}; // Ajusta a tus datos
	    DefaultTableModel modeloPopup = new DefaultTableModel(columnas, 0) { 
	    	@Override
	        public boolean isCellEditable(int row, int column) { return false; } 
	    };
	    
	    JTable tablaPopup = new JTable(modeloPopup);
	    EstiloComponentes.EstiloTabla(tablaPopup);
	    
	    JScrollPane scroll = new JScrollPane(tablaPopup);
	    scroll.getViewport().setBackground(new Color(160, 200, 120));
	    scroll.setBorder(BorderFactory.createLineBorder(new Color(46, 68, 44), 1));
	    scroll.getViewport().setBackground(new Color(160, 200, 120));
	    scroll.setBorder(null);
	    // Borrar el texto por defecto al ganar foco
	    txtPopUp.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) { 
	        	if(txtPopUp.getText().equals(" Escriba para buscar...")) {
	            txtPopUp.setText(""); 
	        }
	        }
	    });

	    // Acción al presionar ENTER
	    txtPopUp.addActionListener(e -> {
	        String criterio = txtPopUp.getText().trim();
	        if (!criterio.isEmpty()) {
	        	buscarContactosHebra(criterio, modeloPopup);
	   
	        }

	    });
	    
	 // Crear el título con la fuente Nokian y el color verde oscuro
	    JLabel lblTitulo = new JLabel("BUSQUEDA  RAPIDA:");
	    EstiloComponentes.aplicarEstiloLabel(lblTitulo);
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    JPanel panelNorte = new JPanel(new GridLayout(2, 1)); // 2 filas, 1 columna
	    panelNorte.setBackground(new Color(160, 200, 120));
	    panelNorte.add(lblTitulo);
	    panelNorte.add(txtPopUp);
	   // lblTitulo.setBorder(BorderFactory.createEmptyPadding(10, 0, 10, 0)); // Espaciado
	    
	    panelPrincipal.add(panelNorte, BorderLayout.NORTH);
	    panelPrincipal.add(scroll, BorderLayout.CENTER);
	    
	    panelBusqueda.removeAll(); 
	    panelBusqueda.add(panelPrincipal, BorderLayout.CENTER);
	    
	    // 3. Añadimos el marco final al popup
	    popup.getContentPane().removeAll();
	    popup.getContentPane().add(panelBusqueda);
	    
	    // 4. Refrescamos y mostramos
	    popup.revalidate();
	    popup.repaint();
	    popup.setVisible(true);
	    txtPopUp.requestFocusInWindow(); 
	}
	    public void buscarContactosHebra(String texto, DefaultTableModel modelo) {
	        SwingWorker<List<Object[]>, Void> worker = new SwingWorker<>() {
	            @Override
	            protected List<Object[]> doInBackground() {
	                List<Object[]> filtrados = new ArrayList<>();
	                String busqueda = texto.toLowerCase();
	                
	                synchronized (Agenda) {
	                
	                for (Object obj : Agenda) {
	                    contacto c = (contacto) obj;
	                    // Buscamos coincidencia en nombres o apellidos
	                    if (c.getnombres().toLowerCase().contains(busqueda) || 
	                        c.getapellidos().toLowerCase().contains(busqueda)) {
	                        
	                        filtrados.add(new Object[]{
	                            c.getnombres() + " " + c.getapellidos(), 
	                            c.getnumero(), 
	                            c.getcorreo()
	                        });
	                    }
	                }
	                }
	                return filtrados; 
	            
	            }
	            @Override
	            protected void done() {
	                try {
	                    List<Object[]> resultados = get();
	                    modelo.setRowCount(0); // Limpia la tabla antes de mostrar nuevos resultados
	                    for (Object[] fila : resultados) {
	                        modelo.addRow(fila);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    
	                    System.err.println("Error al actualizar la tabla: " + e.getMessage());
	                
	                }
	            }
	        };
	        worker.execute();
	    }
			
	public void actualizarEstadoUI(boolean cargando) {
	    // Esto evita que el usuario presione el botón varias veces mientras se procesa
	    if (BTN_SAVE != null) {
	        BTN_SAVE.setEnabled(!cargando);
	    }
	    
	    if (cargando) {
	        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	    } else {
	        setCursor(Cursor.getDefaultCursor());
	    }
	}

	public void mostrarNotificacion(String mensaje) {
	    JOptionPane.showMessageDialog(this, mensaje);
	}

	public void limpiarCampos() {
	    txtID.setText("");
	    txtNombres.setText("");
	    txtApellido.setText("");
	    txtCorreo.setText("");
	    txtNumero.setText("");
	}

	public void refrescarTabla() {
	    if (M != null) {
	        M.setRowCount(0); // Limpia las filas actuales de la JTable
	        for (clase.contacto c : Agenda) {
	            // Se cargan los datos usando los métodos de la clase contacto
	            Object[] fila = {
	                c.getid(), 
	                c.getnombres(), 
	                c.getapellidos(), 
	                c.getcorreo(), 
	                c.getnumero()
	            };
	            M.addRow(fila);
	        }
	    }
	}

}

	