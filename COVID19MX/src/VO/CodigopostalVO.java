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
public class CodigopostalVO {
   
    private int CP;
    private String CP_NOMBRE;
    private int CLAVE_MUNICIPIO;
    
   
    public CodigopostalVO(){}
    
     public CodigopostalVO(int CLA_CP, String NOM_CP){
         
         this.CP = CLA_CP;
         this.CP_NOMBRE = NOM_CP;
     
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

    /**
     * @return the CP_NOMBRE
     */
    public String getCP_NOMBRE() {
        return CP_NOMBRE;
    }

    /**
     * @param CP_NOMBRE the CP_NOMBRE to set
     */
    public void setCP_NOMBRE(String CP_NOMBRE) {
        this.CP_NOMBRE = CP_NOMBRE;
    }

    /**
     * @return the CLAVE_MUNICIPIO
     */
    public int getCLAVE_MUNICIPIO() {
        return CLAVE_MUNICIPIO;
    }

    /**
     * @param CLAVE_MUNICIPIO the CLAVE_MUNICIPIO to set
     */
    public void setCLAVE_MUNICIPIO(int CLAVE_MUNICIPIO) {
        this.CLAVE_MUNICIPIO = CLAVE_MUNICIPIO;
    }
    public String toString(){
    return this.CP_NOMBRE;
    }
}
