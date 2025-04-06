package controle;
import java.util.Scanner;

import entidades.Episodio;
import entidades.Serie;
import persistencia.ArquivoEpisodio;
import persistencia.ArquivoSerie;
import visao.VisaoEpisodios;

import java.util.ArrayList;

public class ControleEpisodios {

    private ArquivoEpisodio arqEpisodio;
    private ArquivoSerie arqSerie;
    private VisaoEpisodios visao;
    private static Scanner console = new Scanner(System.in);

    public ControleEpisodios() throws Exception {
        arqEpisodio = new ArquivoEpisodio();
        arqSerie = new ArquivoSerie();
        visao = new VisaoEpisodios();
    }

    public void menu() {
        try {
            System.out.print("Digite o ID da série para gerenciar os episódios: ");
            int idSerie = Integer.parseInt(console.nextLine());

            Serie serie = arqSerie.read(idSerie);
            if (serie == null) {
                System.out.println("Série não encontrada.");
                return;
            }

            int opcao;
            do {
                System.out.println("\nPUCFlix 1.0");
                System.out.println("-----------");
                System.out.println("> Série: " + serie.getNome() + " (ID " + idSerie + ")");
                System.out.println("1) Incluir Episódio");
                System.out.println("2) Buscar Episódio");
                System.out.println("3) Alterar Episódio");
                System.out.println("4) Excluir Episódio");
                System.out.println("5) Listar por Temporada");
                System.out.println("0) Voltar");

                System.out.print("\nOpção: ");
                opcao = Integer.parseInt(console.nextLine());

                switch (opcao) {
                    case 1 -> incluir(idSerie);
                    case 2 -> buscar();
                    case 3 -> alterar();
                    case 4 -> excluir();
                    case 5 -> listarPorTemporada(idSerie);
                    case 0 -> System.out.println("Retornando...");
                    default -> System.out.println("Opção inválida.");
                }

            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Erro no menu de episódios.");
            e.printStackTrace();
        }
    }

    private void incluir(int idSerie) {
        try {
            Episodio ep = visao.leEpisodio(idSerie);
            int id = arqEpisodio.create(ep);
            System.out.println("Episódio incluído com ID: " + id);
        } catch (Exception e) {
            System.out.println("Erro ao incluir episódio.");
        }
    }

    private void buscar() {
        try {
            System.out.print("ID do Episódio: ");
            int id = Integer.parseInt(console.nextLine());
            Episodio ep = arqEpisodio.read(id);
            visao.mostraEpisodio(ep);
        } catch (Exception e) {
            System.out.println("Erro na busca.");
        }
    }

    private void alterar() {
        try {
            System.out.print("ID do Episódio: ");
            int id = Integer.parseInt(console.nextLine());
            Episodio ep = arqEpisodio.read(id);
            if (ep != null) {
                ep = visao.alteraEpisodio(ep);
                arqEpisodio.update(ep);
                System.out.println("Episódio atualizado.");
            } else {
                System.out.println("Episódio não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro na alteração.");
        }
    }

    private void excluir() {
        try {
            System.out.print("ID do Episódio: ");
            int id = Integer.parseInt(console.nextLine());
            if (arqEpisodio.delete(id))
                System.out.println("Episódio excluído.");
            else
                System.out.println("Episódio não encontrado.");
        } catch (Exception e) {
            System.out.println("Erro na exclusão.");
        }
    }

    private void listarPorTemporada(int idSerie) {
        try {
            ArrayList<Episodio> lista = arqEpisodio.buscarPorSerie(idSerie);
            if (lista.isEmpty()) {
                System.out.println("Nenhum episódio encontrado.");
                return;
            }

            lista.sort((a, b) -> {
                if (a.getTemporada() != b.getTemporada())
                    return Integer.compare(a.getTemporada(), b.getTemporada());
                return a.getNome().compareToIgnoreCase(b.getNome());
            });

            System.out.println("\n--- Episódios por Temporada ---");
            int tempAtual = -1;
            for (Episodio ep : lista) {
                if (ep.getTemporada() != tempAtual) {
                    tempAtual = ep.getTemporada();
                    System.out.println("\nTemporada " + tempAtual + ":");
                }
                System.out.println("  - " + ep.getNome() + " (ID " + ep.getId() + ")");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar episódios.");
        }
    }
}
