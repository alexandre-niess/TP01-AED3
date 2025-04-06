import controle.ControleEpisodios;

import controle.ControleSeries;

public class Main {
  public static void main(String[] args) {
      int opcao;
      java.util.Scanner console = new java.util.Scanner(System.in);

      do {
          System.out.println("\nPUCFlix 1.0");
          System.out.println("-----------");
          System.out.println("> Início\n");
          System.out.println("1) Séries");
          System.out.println("2) Episódios");
          System.out.println("3) Atores (em breve)");
          System.out.println("0) Sair");

          System.out.print("\nOpção: ");
          try {
              opcao = Integer.parseInt(console.nextLine());
          } catch (NumberFormatException e) {
              opcao = -1;
          }

          switch (opcao) {
              case 1 -> {
                  try {
                      ControleSeries cs = new ControleSeries();
                      cs.menu();
                  } catch (Exception e) {
                      System.out.println("Erro ao acessar o módulo de séries.");
                      e.printStackTrace();
                  }
              }

              case 2 -> {
                  try {
                      ControleEpisodios ce = new ControleEpisodios();
                      ce.menu();
                  } catch (Exception e) {
                      System.out.println("Erro ao acessar o módulo de episódios.");
                      e.printStackTrace();
                  }
              }

              case 3 -> System.out.println("Módulo de Atores ainda não implementado.");

              case 0 -> System.out.println("Encerrando o sistema...");

              default -> System.out.println("Opção inválida.");
          }

      } while (opcao != 0);

      console.close();
  }
}
