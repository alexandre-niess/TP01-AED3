package persistencia;
import aed3.*;
import entidades.Serie;

public class ArquivoSerie extends Arquivo<Serie> {

    public ArquivoSerie() throws Exception {
        super("series", Serie.class.getConstructor());
        // Neste momento, não é necessário um índice indireto (como CPF),
        // pois não temos um campo único além do ID.
    }

    // Podemos adicionar métodos específicos para buscar por nome ou streaming no futuro,
    // mas para esta fase, apenas o ID é necessário.
}
