package demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class Teste {

	public static void main(String[] args) throws JRException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Titulo", "Demonstração");
		JasperPrint jrprint = JasperFillManager.fillReport("JasperTeste.jasper", parameters, new JREmptyDataSource(10));
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jrprint));
		File arquivo = new File("JasperTeste.docx");
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivo));
		exporter.exportReport();
	}

}
