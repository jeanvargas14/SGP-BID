package br.com.empresa.sgpbid.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
 
@ManagedBean
@SessionScoped
public class TabMenuProgramaBean {
	
	public static final int TAB_PROGRAMA = 0; 
	public static final int TAB_DETALHE = 1;
	
	private int index = TAB_PROGRAMA;
    
	@Inject
	private ProgramaMB programaMB;
	
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
				return programaMB.editar();
			case TAB_DETALHE:
				return programaMB.detalhePrograma();	
			default:
				return programaMB.abrirConPrograma();
		}
    }
}