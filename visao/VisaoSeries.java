package visao;
import java.util.Scanner;

import entidades.Serie;

public class VisaoSeries {
    private static Scanner console = new Scanner(System.in);

    public Serie leSerie() {
        System.out.println("\nCadastro de Série");
        System.out.print("Nome: ");
        String nome = console.nextLine();

        System.out.print("Ano de Lançamento: ");
        int ano = Integer.parseInt(console.nextLine());

        System.out.print("Sinopse: ");
        String sinopse = console.nextLine();

        System.out.print("Streaming (Netflix, Prime, etc.): ");
        String streaming = console.nextLine();

        return new Serie(nome, ano, sinopse, streaming);
    }

    public void mostraSerie(Serie serie) {
        if (serie == null) {
            System.out.println("Série não encontrada.");
        } else {
            System.out.println("\n--- Detalhes da Série ---");
            System.out.println(serie);
        }
    }

    public Serie alteraSerie(Serie serie) {
        System.out.println("\nAlteração de Série");
        System.out.println("Deixe em branco para manter o valor atual.");

        System.out.print("Nome (" + serie.getNome() + "): ");
        String nome = console.nextLine();
        if (!nome.isEmpty()) serie = new Serie(serie.getId(), nome, serie.getAnoLancamento(), serie.getSinopse(), serie.getStreaming());

        System.out.print("Ano (" + serie.getAnoLancamento() + "): ");
        String anoStr = console.nextLine();
        if (!anoStr.isEmpty()) {
            int ano = Integer.parseInt(anoStr);
            serie = new Serie(serie.getId(), serie.getNome(), ano, serie.getSinopse(), serie.getStreaming());
        }

        System.out.print("Sinopse (" + serie.getSinopse() + "): ");
        String sinopse = console.nextLine();
        if (!sinopse.isEmpty()) serie = new Serie(serie.getId(), serie.getNome(), serie.getAnoLancamento(), sinopse, serie.getStreaming());

        System.out.print("Streaming (" + serie.getStreaming() + "): ");
        String streaming = console.nextLine();
        if (!streaming.isEmpty()) serie = new Serie(serie.getId(), serie.getNome(), serie.getAnoLancamento(), serie.getSinopse(), streaming);

        return serie;
    }
}
