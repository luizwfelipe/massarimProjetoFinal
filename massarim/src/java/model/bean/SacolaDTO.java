package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SacolaDTO {
    private static List<ProdutoDTO> item = new ArrayList<>();

    public static void addItem(ProdutoDTO produto) {
        item.add(produto);
    }

    public static SacolaDTO CGSacola(HttpServletRequest request) { // faz o CREATE/GET do produto na SACOLA
        SacolaDTO sacola = (SacolaDTO) request.getAttribute("sacola");
        if (sacola == null) {
            sacola = new SacolaDTO();
            request.setAttribute("sacola", sacola);
        }
        return sacola;
    }

    public void removerItem(int idProduto) {
        item.removeIf(produto -> produto.getIdProduto() == idProduto);
    }

    public static List<ProdutoDTO> getItem() {
        return item;
    }

    public static float calcularTotal() {
        float total = 0;
        for (ProdutoDTO produto : item) {
            total += produto.getPreco();
        }
        return total;
    }
}
