
package Repositorio;

public class Arquitecto {
     
    int codigo;
    String nombres;
    String condicion_contrato;
    String especialidad;
    String tipo_supervision;
    int obras_asignadas;
    String pensiones;
    
    private static int contador=0;
    private static int base;
    private static int boni;
    private static int pension;
    private static int movilidad;
    private static double s_bruto;
    private static double neto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCondicion_contrato() {
        return condicion_contrato;
    }

    public void setCondicion_contrato(String condicion_contrato) {
        this.condicion_contrato = condicion_contrato;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo_supervision() {
        return tipo_supervision;
    }

    public void setTipo_supervision(String tipo_supervision) {
        this.tipo_supervision = tipo_supervision;
    }

    public int getObras_asignadas() {
        return obras_asignadas;
    }

    public void setObras_asignadas(int obras_asignadas) {
        this.obras_asignadas = obras_asignadas;
    }

    public String getPensiones() {
        return pensiones;
    }

    public void setPensiones(String pensiones) {
        this.pensiones = pensiones;
    }
    
    
    public Arquitecto(int codigo,String nombres,String condicion_contrato, 
    String especialidad,String tipo_supervision, int obras_asignadas,String pensiones)
    {
    contador++;
    this.codigo=codigo;
    this.nombres=nombres;
    this.condicion_contrato=condicion_contrato;
    this.especialidad=especialidad;
    this.tipo_supervision=tipo_supervision;
    this.obras_asignadas=obras_asignadas;
    this.pensiones=pensiones;
    
    }
    

    public int monto_movilidad()
    {
        
        if(obras_asignadas<17)
    {
        movilidad=300;
        
    return movilidad;
    }
        if(obras_asignadas>=18)
    {
        movilidad=600;
        
    return movilidad;
    }
        
    return 0;
    }
    
    public int descuento_Pensiones()
    {
    
        if(pensiones.equalsIgnoreCase("AFP"))
    {
        pension=15;
        
    return pension;
    }
        
        else if(pensiones.equalsIgnoreCase("SNP"))
    {
        pension=8;
        
    return pension;
    }
        return 0;
    }
    
    public int Bonificacion()
    {
    
        if(especialidad.equalsIgnoreCase("Estructuras"))
    {
        boni=16;
        
    return boni;
    }
        else if(especialidad.equalsIgnoreCase("Recursos Hídricos"))
    {
        boni=18;
        
    return boni;
    }
         else if(especialidad.equalsIgnoreCase("Ingeniería Vial"))
    {
        boni=22;
    return boni;
    }
    
    return 0;
    }
    
    public int SueldoBase()
    {

    if(condicion_contrato.equalsIgnoreCase("Estable"))
    {
        if(tipo_supervision.equalsIgnoreCase("Obras"))
        {
        base=4000;
        }
        else if(tipo_supervision.equalsIgnoreCase("Vías"))
                {
                base=6000;
                }
        
    return base;
    }
    
    else if(condicion_contrato.equalsIgnoreCase("Contratado"))
    {
   
        if(tipo_supervision.equalsIgnoreCase("Obras"))
        {
        base=2000;
        }
        else if(tipo_supervision.equalsIgnoreCase("Vías"))
                {
                base=4500;
                }
        
        
    return base;
    }
    
       return 0; 
    }
    
    

    public double sueldo_bruto()
    {
    s_bruto=((((base*boni)/100)+base)+movilidad);
        return s_bruto;
    }
    
    public double sueldo_neto()
    {
        double a=(s_bruto*pension)/100;
    neto=s_bruto-a;
        
        return neto;
    }
    
    public int getContador()
    {  
    return contador;
    }
    
    
}
