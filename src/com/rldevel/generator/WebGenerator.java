package com.rldevel.generator;

import pattern01.helpers.CustomStringBuilder;
import pattern01.helpers.generated.Column;
import pattern01.helpers.generated.DataTable;
import pattern01.helpers.generated.Form;
import pattern01.helpers.generated.IPatternElement;
import pattern01.helpers.generated.PatternInstance;
import pattern01.helpers.generated.Text;
import pattern01.helpers.temporal_containers.CommonElement;
import pattern01.plugin.components.navigator.NodeType;

public class WebGenerator {
	
	public String GenerateCode(int tabIndex, NodeType type, IPatternElement element) {
		String generated_code ="", identifier =type.toString().toLowerCase()+"_"+((CommonElement)element).getName();
		
		CustomStringBuilder builder = new CustomStringBuilder();
		switch (type){
			case UNDEFINED:
			case PACKAGE:
			case CLASS:
		break;
		case COMMANDBUTTON:
			//TO-DO Code for COMMANDBUTTON
		break;
		case DATATABLE:
			builder.appendLn(tabIndex, "<p:DataTable id='"+identifier+"' name='"+identifier+"'");
			builder.append(" var='item_"+((CommonElement)element).getName()+"' >");
				for(IPatternElement childElement : ((DataTable)element).getCollection_Column())
					builder.append(GenerateCode(tabIndex+1, NodeType.DATATABLE, childElement));
			builder.appendLn(tabIndex,"</p:dataTable>");	
		break;
		case PANEL:
			//TO-DO Code for PANEL
		break;
		case FORM:
			builder.appendLn(tabIndex, "<h:form >");
		break;
		case TEXT:
			builder.appendLn(tabIndex, "<h:outputText value='"+((Text)element).getValue()+"' >");
		break;
		case PROPERTY:
			//TO-DO Code for PROPERTY
		break;
		case PANELGRID:
			//TO-DO Code for PANELGRID
		break;
		case PATTERNINSTANCE:
			builder.append(GenerateCode(tabIndex+1, NodeType.FORM, ((PatternInstance)element).getform()));
		break;
		case MESSAGES:
			//TO-DO Code for MESSAGES
		break;
		case COLUMN:
			builder.appendLn(tabIndex, "<p:column headerText='"+((Column)element).getHeaderText()+"' >");
				for(IPatternElement childElement : ((Column)element).getCollection_Text())
					builder.append(GenerateCode(tabIndex+1, NodeType.COLUMN, childElement));
			builder.appendLn(tabIndex, "</p:column>");
		break;
		}
		return generated_code;
	}	 
	

}
