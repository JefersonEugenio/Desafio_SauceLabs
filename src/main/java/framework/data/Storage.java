package framework.data;

import java.util.ArrayList;

public class Storage {

    private ArrayList<String> lista;

    public Storage() {

        lista = new ArrayList<>();

    }

    public ArrayList<String> getDataProduct() {
        return lista;
    }

    public void addProduct(String product) {
        lista.add(product);
    }

    public void printProducts() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto na lista.");
        } else {
            System.out.println("Produtos no carrinho:");
            for (String item : lista) {
                System.out.println(item);
            }
        }
    }

}
