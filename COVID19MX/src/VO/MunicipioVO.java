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
public class MunicipioVO {
    
    private int CLAVE_MUNICIPIO;
    private String MUNICIPIO;
   
    public MunicipioVO(){}
    
     public MunicipioVO(int CLA_MUN, String NOM_MUN){
         
         this.CLAVE_MUNICIPIO = CLA_MUN;
         this.MUNICIPIO = NOM_MUN;
     
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

    /**
     * @return the MUNICIPIO
     */
    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    /**
     * @param MUNICIPIO the MUNICIPIO to set
     */
    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }
    public String toString(){
    return this.MUNICIPIO;
    }
   
}
