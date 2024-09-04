package terceiro_exercicio;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Terceiro {
    public static void main(String[] args) {

        try {

            File inputFile = new File("src/terceiro_exercicio/dados.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(inputFile);

            document.getDocumentElement().normalize();

            NodeList rowList = document.getElementsByTagName("row");

            List<Double> faturamentos = new ArrayList<>();
            double totalFaturamento = 0.0;

            for (int i = 0; i < rowList.getLength(); i++) {
                Node rowNode = rowList.item(i);
                if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rowElement = (Element) rowNode;
                    String valorStr = rowElement.getElementsByTagName("valor").item(0).getTextContent();
                    double faturamento = Double.parseDouble(valorStr);
                    if (faturamento > 0) {
                        faturamentos.add(faturamento);
                        totalFaturamento += faturamento;
                    }
                }
            }

            double mediaMensal = !faturamentos.isEmpty() ? totalFaturamento / faturamentos.size() : 0;

            // Configuração do DecimalFormat para ponto como separador decimal e vírgula como separador de milhar
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            // Formatação dos valores
            String mediaMensalFormatada = df.format(mediaMensal);
            String menorFaturamentoFormatado = df.format(faturamentos.stream().min(Double::compare).orElse(0.0));
            String maiorFaturamentoFormatado = df.format(faturamentos.stream().max(Double::compare).orElse(0.0));

            double menorFaturamento = faturamentos.stream().min(Double::compare).orElse(0.0);
            double maiorFaturamento = faturamentos.stream().max(Double::compare).orElse(0.0);

            long diasAcimaMedia = faturamentos.stream().filter(f -> f > mediaMensal).count();

            System.out.println("Menor valor de faturamento: R$ " + menorFaturamentoFormatado);
            System.out.println("Maior valor de faturamento: R$ " + maiorFaturamentoFormatado);
            System.out.println("Média mensal de faturamento: R$ " + mediaMensalFormatada);
            System.out.println("Número de dias com faturamento superior à média: " + diasAcimaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


