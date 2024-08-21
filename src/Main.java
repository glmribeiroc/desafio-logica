import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println(desafioResistores("10 ohms"));
        System.out.println(desafioResistores("100 ohms"));
        System.out.println(desafioResistores("220 ohms"));
        System.out.println(desafioResistores("330 ohms"));
        System.out.println(desafioResistores("470 ohms"));
        System.out.println(desafioResistores("680 ohms"));
        System.out.println(desafioResistores("1k ohms"));
        System.out.println(desafioResistores("2M ohms"));

        int[][] matriz1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matriz2 = {
                {1, 2, 3},
                {4, 10, 12},
                {6, 7, 33}
        };

        System.out.println(percorrerMatriz(matriz1));
        System.out.println(percorrerMatriz(matriz2));
    }

    private static final Map<Integer, String> colorMap = new HashMap<>();
    private static final String RESISTENCIA = "dourado";
    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static String desafioResistores(String ohmsString) {
        ohmsString = ohmsString.replace("ohms", "");
        double ohms = 0;
        int multiplicador = 0;

        if (ohmsString.contains("k")) {
            ohms = Double.parseDouble(ohmsString.replace("k", "")) * 1000;
            ohmsString = String.valueOf(ohms);
            multiplicador = 2;
        } else if (ohmsString.contains("M")) {
            ohms = Double.parseDouble(ohmsString.replace("M", "")) * 100000;
            ohmsString = String.valueOf(ohms);
            multiplicador = 5;
        } else {
            ohms = Double.parseDouble(ohmsString);
            if (ohms > 99) multiplicador = 1;
        }



        int firstDigit = Integer.parseInt(String.valueOf(ohmsString.charAt(0)));
        int secondDigit = Integer.parseInt(String.valueOf(ohmsString.charAt(1)));

        String color1 = colorMap.get(firstDigit);
        String color2 = colorMap.get(secondDigit);
        String color3 = colorMap.get(multiplicador);

        return color1 + " " + color2 + " " + color3 + " " + RESISTENCIA;
    }

    public static List<Integer> percorrerMatriz(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        int topo = 0, baixo = matriz.length - 1;
        int esquerda = 0, direita = matriz[0].length - 1;

        while (topo <= baixo && esquerda <= direita) {
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[topo][i]);
            }
            topo++;

            for (int i = topo; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
            }
            direita--;

            if (topo <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                }
                baixo--;
            }

            if (esquerda <= direita) {
                for (int i = baixo; i >= topo; i--) {
                    resultado.add(matriz[i][esquerda]);
                }
                esquerda++;
            }
        }

        return resultado;
    }
}