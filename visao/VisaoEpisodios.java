package visao;
import java.util.Scanner;

import entidades.Episodio;

public class VisaoEpisodios {
    private static Scanner console = new Scanner(System.in);

    public Episodio leEpisodio(int idSerie) {
        System.out.println("\nCadastro de Episódio");

        System.out.print("Nome do Episódio: ");
        String nome = console.nextLine();

        System.out.print("Temporada: ");
        int temporada = Integer.parseInt(console.nextLine());

        System.out.print("Data de Lançamento (DD/MM/AAAA): ");
        String dataLancamento = console.nextLine();

        System.out.print("Duração (minutos): ");
        int duracao = Integer.parseInt(console.nextLine());

        System.out.print("Sinopse: ");
        String sinopse = console.nextLine();

        return new Episodio(idSerie, nome, temporada, dataLancamento, duracao, sinopse);
    }

    public void mostraEpisodio(Episodio ep) {
        if (ep == null) {
            System.out.println("Episódio não encontrado.");
        } else {
            System.out.println("\n--- Detalhes do Episódio ---");
            System.out.println(ep);
        }
    }

    public Episodio alteraEpisodio(Episodio ep) {
        System.out.println("\nAlteração de Episódio");
        System.out.println("Deixe em branco para manter o valor atual.");

        System.out.print("Novo nome (" + ep.getNome() + "): ");
        String nome = console.nextLine();
        if (!nome.isEmpty()) ep = new Episodio(ep.getId(), ep.getIdSerie(), nome, ep.getTemporada(), ep.getDataLancamento(), ep.getDuracao(), ep.getSinopse());

        System.out.print("Nova temporada (" + ep.getTemporada() + "): ");
        String temporadaStr = console.nextLine();
        if (!temporadaStr.isEmpty()) {
            int temporada = Integer.parseInt(temporadaStr);
            ep = new Episodio(ep.getId(), ep.getIdSerie(), ep.getNome(), temporada, ep.getDataLancamento(), ep.getDuracao(), ep.getSinopse());
        }

        System.out.print("Nova data de lançamento (" + ep.getDataLancamento() + "): ");
        String data = console.nextLine();
        if (!data.isEmpty()) ep = new Episodio(ep.getId(), ep.getIdSerie(), ep.getNome(), ep.getTemporada(), data, ep.getDuracao(), ep.getSinopse());

        System.out.print("Nova duração (" + ep.getDuracao() + "): ");
        String durStr = console.nextLine();
        if (!durStr.isEmpty()) {
            int dur = Integer.parseInt(durStr);
            ep = new Episodio(ep.getId(), ep.getIdSerie(), ep.getNome(), ep.getTemporada(), ep.getDataLancamento(), dur, ep.getSinopse());
        }

        System.out.print("Nova sinopse: ");
        String sinopse = console.nextLine();
        if (!sinopse.isEmpty()) ep = new Episodio(ep.getId(), ep.getIdSerie(), ep.getNome(), ep.getTemporada(), ep.getDataLancamento(), ep.getDuracao(), sinopse);

        return ep;
    }
}
