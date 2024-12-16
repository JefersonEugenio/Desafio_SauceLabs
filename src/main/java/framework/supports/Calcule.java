package framework.supports;

import java.util.Locale;

public class Calcule {

    public String calculeTotal (String itemTotal, String tax) {

        double itemTotalDouble = Double.parseDouble(itemTotal.replaceAll("[^\\d.]", ""));
        double taxDouble = Double.parseDouble(tax.replaceAll("[^\\d.]", ""));

        double total = itemTotalDouble+taxDouble;

        String formattedTotal = String.format(Locale.US, "%.2f", total);

        return formattedTotal;
    }
}
