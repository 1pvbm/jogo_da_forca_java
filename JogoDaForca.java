package exercicios_java_4_5_6;

import java.util.*;

public class JogoDaForca {
    private static final String[] palavras = {"jaguar", "tucano", "capivara", "tamandua", "pirarucu", "arara", "jabuti", "jacare", "mico", "onca", "quati", "sucuri", "tatu", "urubu", "veado", "boto", "coruja", "ema", "gamba", "paca"};
    private static final String[] dicas = {"Mamífero carnívoro", "Ave com bico colorido", "Maior roedor do mundo", "Mamífero com longa língua pegajosa", "Peixe de água doce", "Ave colorida", "Réptil com casco", "Réptil aquático", "Pequeno primata", "Grande felino", "Mamífero com cauda anelada", "Grande cobra", "Mamífero com carapaça", "Ave de rapina", "Mamífero com chifres", "Mamífero aquático", "Ave noturna", "Maior ave do Brasil", "Mamífero noturno", "Roedor noturno"};
    private static final String[] boneco = {" 0 ", "|", "/", "\\", "/", "\\"};

    public static void main(String[] args) {
        Random random = new Random();
        int indice = random.nextInt(palavras.length);
        String palavra = palavras[indice];
        char[] letras = new char[palavra.length()];
        int erros = 0;
        List<Character> letrasUsadas = new ArrayList<>();
        List<Character> letrasErradas = new ArrayList<>();
        List<Character> letrasRepetidas = new ArrayList<>();

        for (int i = 0; i < letras.length; i++) {
            letras[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        while (erros < 6 && new String(letras).contains("_")) {
            System.out.println("Palavra: " + new String(letras));
            System.out.println("Erros: " + erros);
            if (erros > 0) {
                for (int i = 0; i < erros; i++) {
                    System.out.println(boneco[i]);
                }
            }
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Letras erradas: " + letrasErradas);
            System.out.println("Letras repetidas: " + letrasRepetidas);
            System.out.print("Digite uma letra ou 'dica' para uma dica: ");
            String entrada = scanner.next();

            if (entrada.equalsIgnoreCase("dica")) {
                System.out.println("Dica: " + dicas[indice]);
            } else {
                char letra = entrada.charAt(0);
                if (letrasUsadas.contains(letra)) {
                    letrasRepetidas.add(letra);
                    System.out.println("Você já usou essa letra. Tente novamente.");
                } else {
                    letrasUsadas.add(letra);

                    if (palavra.contains(String.valueOf(letra))) {
                        for (int i = 0; i < palavra.length(); i++) {
                            if (palavra.charAt(i) == letra) {
                                letras[i] = letra;
                            }
                        }
                        System.out.println("Você acertou!");
                    } else {
                        letrasErradas.add(letra);
                        erros++;
                        System.out.println("Você errou!");
                    }
                }
            }
        }

        if (erros < 6) {
            System.out.println("Parabéns, você ganhou! A palavra era " + palavra);
        } else {
            System.out.println("Você perdeu! A palavra era " + palavra);
        }

        System.out.print("Você gostaria de jogar novamente? (s/n): ");
        String jogarNovamente = scanner.next();
        if (jogarNovamente.equalsIgnoreCase("s")) {
            main(args);
        } else {
            System.out.println("Obrigado por jogar!");
        }

        scanner.close();
    }
}