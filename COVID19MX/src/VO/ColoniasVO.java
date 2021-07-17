/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author JUAN100CORR
 */
public class ColoniasVO {
    
     private int CLAVE_COLONIA;
    private String COLONIA_NOMBRE;
    private int CP;
    
   
    public ColoniasVO(){}
    
     public ColoniasVO(int CLA_COL, String NOM_COL){
         
         this.CLAVE_COLONIA = CLA_COL;
         this.COLONIA_NOMBRE = NOM_COL;
     
     }

    /**
     * @return the CLAVE_COLONIA
     */
    public int getCLAVE_COLONIA() {
        return CLAVE_COLONIA;
    }

    /**
     * @param CLAVE_COLONIA the CLAVE_COLONIA to set
     */
    public void setCLAVE_COLONIA(int CLAVE_COLONIA) {
        this.CLAVE_COLONIA = CLAVE_COLONIA;
    }

    /**
     * @return the COLONIA_NOMBRE
     */
    public String getCOLONIA_NOMBRE() {
        return COLONIA_NOMBRE;
    }

    /**
     * @param COLONIA_NOMBRE the COLONIA_NOMBRE to set
     */
    public void setCOLONIA_NOMBRE(String COLONIA_NOMBRE) {
        this.COLONIA_NOMBRE = COLONIA_NOMBRE;
    }

    /**
     * @return the CP
     */
    public int getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(int CP) {
        this.CP = CP;
    }
    
     public String toString(){
    return this.COLONIA_NOMBRE;
    }
    
}
