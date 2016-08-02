package br.com.empresa.sgpbid.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class TabMenuProgramaBean {
	
	public static final int TAB_PROGRAMA = 0; 
	public static final int TAB_DETALHE = 1;
	
	private int index = TAB_PROGRAMA;
    
	public int getIndex() {
        return index;
    }
 
    public void setIndex(int index) {
        this.index = index;
    }
 
    public String tabPrograma(){
    	return navegar(TAB_PROGRAMA);
    }
    public String tabDetalhe(){
    	return navegar(TAB_DETALHE);
    }
    private String navegar(int index){
        this.index = index;
        switch (index) {
			case TAB_PROGRAMA:				
				return ProgramaMB.CADASTRO_JSF;
			case TAB_DETALHE:
				return ProgramaMB.DETALHE_PROGRAMA_JSF;	
			default:
				return ProgramaMB.CONSULTA_JSF;
		}
    }
}