
package Repositorio;

import javafx.scene.control.ComboBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmArquitecto extends JFrame{
    

    Arquitecto arquitecto;
    JScrollPane barra;
    JTextArea area;

    
    JButton btnRegistrar,btnMostrar,btnLimpiar,btnSalir;
    JLabel lblCodigo,lblNombres,lblCondicion_contrato,lblEspecialidad,lblTipo_supervision,lblobras_Asignadas,lblPensiones;    
    JTextField txtCodigo,txtNombres,txtObras_asignadas;
    JComboBox combCondicion_contrato,combEspecialidad,combTipo_supervision,combPensiones;

    
    public FrmArquitecto()
    {
    
        initComponents();
        setLocationRelativeTo(null);
   
    }
    
    public void initComponents()
    {
        setSize(700, 630);
        setLayout(null);
        barra=new JScrollPane();
        
        barra = new JScrollPane();
        area = new JTextArea(10,10);
        barra.setViewportView(area);
        barra.setBounds(50,340,500,200);
        getContentPane().add(barra);
        area.setEditable(false);

        
        lblCodigo=new JLabel("Código:");
        lblCodigo.setBounds(50, 40, 100, 30);
        add(lblCodigo);
        
        txtCodigo=new JTextField();
        txtCodigo.setBounds(190, 40, 200, 30);
        add(txtCodigo);
        
        lblNombres=new JLabel("Nombres:");
        lblNombres.setBounds(50, 80, 200, 30);
        add(lblNombres);
        
        txtNombres=new JTextField();
        txtNombres.setBounds(190, 80, 200, 30);
        add(txtNombres);
        
        lblCondicion_contrato=new JLabel("Condición de Contrato:");
        lblCondicion_contrato.setBounds(50, 120, 200, 30);
        add(lblCondicion_contrato);
        
        String[] CCondi={"-Seleccione-","Estable","Contratado"};
        combCondicion_contrato=new JComboBox(CCondi);
        combCondicion_contrato.setBounds(190,120,200,30);
        add(combCondicion_contrato);
        
        lblEspecialidad=new JLabel("Especialidad:");
        lblEspecialidad.setBounds(50, 160, 200, 30);
        add(lblEspecialidad);
        
        String[] CEspe={"-Seleccione-","Estructuras","Recursos Hídricos","Ingeniería Vial"};
        combEspecialidad=new JComboBox(CEspe);
        combEspecialidad.setBounds(190,160,200,30);
        add(combEspecialidad);
        
        lblTipo_supervision=new JLabel("Tipo de Supervisón:");
        lblTipo_supervision.setBounds(50, 200, 200, 30);
        add(lblTipo_supervision);
        
        String[] CTipo={"-Seleccione-","Obras","Vías"};
        combTipo_supervision=new JComboBox(CTipo);
        combTipo_supervision.setBounds(190,200,200,30);
        add(combTipo_supervision);
        
        lblobras_Asignadas=new JLabel("Obras asignadas:");
        lblobras_Asignadas.setBounds(50, 240, 200, 30);
        add(lblobras_Asignadas);
        
        txtObras_asignadas=new JTextField();
        txtObras_asignadas.setBounds(190, 240, 200, 30);
        add(txtObras_asignadas);
        
        lblPensiones=new JLabel("Sistema de pensiones:");
        lblPensiones.setBounds(50, 280, 200, 30);
        add(lblPensiones);
        
        String[] CPensi={"-Seleccione-","AFP","SNP"};
        combPensiones=new JComboBox(CPensi);
        combPensiones.setBounds(190,280,200,30);
        add(combPensiones);

        
        btnRegistrar=new JButton("Guardar");
        btnRegistrar.setBounds(480, 50, 130, 30);
        add(btnRegistrar);
        btnRegistrar.addActionListener        (event -> Guardar());
        
        btnMostrar=new JButton("Mostrar");
        btnMostrar.setBounds(480, 90, 130, 30);
        add(btnMostrar);
        btnMostrar.addActionListener        (event -> Mostrar());
        
        btnLimpiar=new JButton("Limpiar");
        btnLimpiar.setBounds(480, 130, 130, 30);
        add(btnLimpiar);
        btnLimpiar.addActionListener        (event -> Limpiar());
           
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(480, 170, 130, 30);
        add(btnSalir);
        btnSalir.addActionListener        (event -> Salir());
        
    }
    
    public void Guardar()
    { 
        int codigo=Integer.parseInt(txtCodigo.getText());
        String nombres=txtNombres.getText();
        String condicion_contrato=(String) combCondicion_contrato.getSelectedItem();
        String especialidad=(String) combEspecialidad.getSelectedItem();
        String tipo_supervision=(String) combTipo_supervision.getSelectedItem(); 
        int obras_asignadas=Integer.parseInt(txtObras_asignadas.getText());
        String pensiones=(String) combPensiones.getSelectedItem(); 
        
        
        arquitecto=new Arquitecto(codigo, nombres, condicion_contrato, especialidad, tipo_supervision, obras_asignadas, pensiones);
        
        txtCodigo.setText(""); 
        txtNombres.setText(""); 
        txtObras_asignadas.setText(""); 
        combCondicion_contrato.setSelectedIndex(0);
        combEspecialidad.setSelectedIndex(0);
        combTipo_supervision.setSelectedIndex(0);
        combPensiones.setSelectedIndex(0);
        txtCodigo.requestFocus();
        
    }
    
    public void Mostrar()
    {
    
       area.append( "\n");
       area.append("    Objeto Número:  "+arquitecto.getContador() +"\n");
       area.append("    Código: "+arquitecto.codigo +"\n");
       area.append("    Nombre completo: "+arquitecto.nombres+ "\n");
       area.append("    Condición de contrato:  "+arquitecto.condicion_contrato+ "\n");
       area.append("    Especialidad:   "+arquitecto.especialidad+ "\n");
       area.append("    Tipo de supervisión:    "+arquitecto.tipo_supervision +"\n");
       area.append("    Número de obras asignadas:  "+arquitecto.obras_asignadas +"\n");
       area.append("    Tipo de Pension:    "+ arquitecto.pensiones+"\n");
       area.append("    Sueldo base:    "+ arquitecto.SueldoBase()+"\n");
       area.append("    Bonificación:   "+ arquitecto.Bonificacion()+"%"+"\n");
       area.append("    Descuento pensión:  "+ arquitecto.descuento_Pensiones()+"%"+"\n");
       area.append("    Monto de movilidad:    "+arquitecto.monto_movilidad() +"\n");
       area.append("    Sueldo neto:    "+arquitecto.sueldo_neto()+ "\n");
       area.append("    Sueldo bruto:   "+arquitecto.sueldo_bruto()+"\n");
         
    }
    
    public void Limpiar()
    {
        txtCodigo.setText(""); 
        txtNombres.setText(""); 
        txtObras_asignadas.setText(""); 
        combCondicion_contrato.setSelectedIndex(0);
        combEspecialidad.setSelectedIndex(0);
        combTipo_supervision.setSelectedIndex(0);
        combPensiones.setSelectedIndex(0);
        txtCodigo.requestFocus();
        area.setText("");

    }
    
    public void Salir()
    {
    System.exit(0);
    }
    
    public static void main(String[] args) {
        
        FrmArquitecto ventana=new FrmArquitecto();
                         ventana.setVisible(true);
        
    }
    
}
