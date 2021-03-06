package br.com.kproj.salesman.infrastructure.configuration.parsers;

import br.com.kproj.salesman.infrastructure.entity.OperationRegionEntity;
import br.com.kproj.salesman.infrastructure.exceptions.InternalArchitectureException;
import com.google.common.collect.Lists;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class RegionsParser {


	private static final String ATTRIBUTE_NAME = "name";
	private static final String FILE_NAME = "/configurations/regions.xml";
	
	
	public static List<OperationRegionEntity> getRegions() {

		return  loadOperationRegions();
	}
	
	
	@SuppressWarnings("unchecked")
	protected static List<OperationRegionEntity> loadOperationRegions() {
		SAXBuilder sab = new SAXBuilder();
		try {
			InputStream inputStream = findFile();
			
			if (inputStream == null)
				return Lists.newArrayList();
			
			Document doc = (Document) sab.build(inputStream);
			Element rootElement = (Element) doc.getRootElement();
			List<OperationRegionEntity> listRegions = new ArrayList<>();
			
			List<Element> childrenRoot = rootElement.getChildren();
			
			for (Element el : childrenRoot) {
				
				OperationRegionEntity region = convertToRegion(el);
				listRegions.add(region);
			}
			
			return listRegions;
		} catch (JDOMException e) {
			throw new InternalArchitectureException("Erro ao obter as configuracoes.", e);
			
		} catch (IOException e) {
			throw new InternalArchitectureException("Erro ao obter o arquivos de configuracoes.", e);
		}
	}
	
	private static OperationRegionEntity convertToRegion(Element element) {
		OperationRegionEntity position = new OperationRegionEntity();
		
		String name = element.getAttributeValue(ATTRIBUTE_NAME);

        position.setName(name);
		
		return position;
		
	}
	
	private static InputStream findFile() {
		
		try {
			return RegionsParser.class.getResourceAsStream(FILE_NAME);
		} catch (Exception e) {
			throw new InternalArchitectureException("Nao foi possivel encontrar o arquivo:" + FILE_NAME);
		}
		
	}
}
