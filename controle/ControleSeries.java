package controle;
import java.util.Scanner;

import entidades.Serie;
import persistencia.ArquivoEpisodio;
import persistencia.ArquivoSerie;
import visao.VisaoSeries;

public class ControleSeries {
    private ArquivoSerie arqSerie;
    private ArquivoEpisodio arqEpisodio; // para verificar vínculo antes de excluir
    private VisaoSeries visao;
    private static Scanner console = new Scanner(System.in);

    public ControleSeries() throws Exception {
        arqSerie = new ArquivoSerie();
        arqEpisodio = new ArquivoEpisodio();
        visao = new VisaoSeries();
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\nPUCFlix 1.0");
            System.out.println("-----------");
            System.out.println("> Início > Séries");
            System.out.println("\n1) Incluir");
            System.out.println("2) Buscar");
            System.out.println("3) Alterar");
            System.out.println("4) Excluir");
            System.out.println("0) Voltar");

            System.out.print("\nOpção: ");
            try {
                opcao = Integer.valueOf(console.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> incluirSerie();
                case 2 -> buscarSerie();
                case 3 -> alterarSerie();
                case 4 -> excluirSerie();
                case 0 -> System.out.println("Retornando ao menu anterior.");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void incluirSerie() {
        try {
            Serie s = visao.leSerie();
            int id = arqSerie.create(s);
            System.out.println("Série cadastrada com ID: " + id);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar série.");
        }
    }

    private void buscarSerie() {
        try {
            System.out.print("ID da série: ");
            int id = Integer.parseInt(console.nextLine());
            Serie s = arqSerie.read(id);
            visao.mostraSerie(s);
        } catch (Exception e) {
            System.out.println("Erro na busca.");
        }
    }

    private void alterarSerie() {
        try {
            System.out.print("ID da série: ");
            int id = Integer.parseInt(console.nextLine());
            Serie s = arqSerie.read(id);
            if (s != null) {
                s = visao.alteraSerie(s);
                arqSerie.update(s);
                System.out.println("Série atualizada com sucesso.");
            } else {
                System.out.println("Série não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro na alteração.");
        }
    }

    private void excluirSerie() {
        try {
            System.out.print("ID da série: ");
            int id = Integer.parseInt(console.nextLine());

            // Verificar se há episódios vinculados
            if (!arqEpisodio.buscarPorSerie(id).isEmpty()) {
                System.out.println("Não é possível excluir a série. Há episódios vinculados a ela.");
                return;
            }

            boolean ok = arqSerie.delete(id);
            if (ok)
                System.out.println("Série excluída com sucesso.");
            else
                System.out.println("Série não encontrada ou não pôde ser excluída.");
        } catch (Exception e) {
            System.out.println("Erro na exclusão.");
        }
    }
}
