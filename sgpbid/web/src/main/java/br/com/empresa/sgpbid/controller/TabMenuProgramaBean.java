package br.com.empresa.sgpbid.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class TabMenuProgramaBean {
	
	public static final int TAB_PROGRAMA = 0; 
	public static final int TAB_DETALHE = 1;
	public static final int TAB_COMPONENTE = 2;
  	
    public String navegar(int index){
        switch (index) {
			case TAB_PROGRAMA:				
				return ProgramaMB.CADASTRO_JSF;
			case TAB_DETALHE:
				return ProgramaMB.DETALHE_PROGRAMA_JSF;	
			case TAB_COMPONENTE:
				return ComponenteMB.CONSULTA_JSF;
			default:
				return ProgramaMB.CONSULTA_JSF;
		}
    }
}