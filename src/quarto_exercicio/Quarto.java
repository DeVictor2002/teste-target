package quarto_exercicio;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

public class Quarto {

    public static void main(String[] args) {

        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        double totalFaturamento = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        System.out.println("Percentual de representação por estado:");
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / totalFaturamento) * 100;
            System.out.println(estado + ": " + df.format(percentual) + "%");
        }
        System.out.println("Faturamento total: " + df.format(totalFaturamento));
    }
}