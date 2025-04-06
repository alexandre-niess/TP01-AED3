package persistencia;

import aed3.Arquivo;
import aed3.ArvoreBMais;
import entidades.Episodio;
import indexacao.ParIdSerieIdEpisodio;
import java.util.ArrayList;

public class ArquivoEpisodio extends Arquivo<Episodio> {

    ArvoreBMais<ParIdSerieIdEpisodio> indiceSerieEpisodio;

    public ArquivoEpisodio() throws Exception {
        super("episodios", Episodio.class.getConstructor());

        indiceSerieEpisodio = new ArvoreBMais<>(
            ParIdSerieIdEpisodio.class.getConstructor(), 
            8, 
            ".\\dados\\episodios\\arvoreSerieEpisodio.db"
        );
    }

    @Override
    public int create(Episodio e) throws Exception {
        int id = super.create(e);
        indiceSerieEpisodio.create(new ParIdSerieIdEpisodio(e.getIdSerie(), id));
        return id;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Episodio e = super.read(id);
        if (e != null) {
            boolean ok = super.delete(id);
            if (ok)
                indiceSerieEpisodio.delete(new ParIdSerieIdEpisodio(e.getIdSerie(), id));
            return ok;
        }
        return false;
    }

    public ArrayList<Episodio> buscarPorSerie(int idSerie) throws Exception {
        ArrayList<Episodio> episodios = new ArrayList<>();
        ArrayList<ParIdSerieIdEpisodio> pares = indiceSerieEpisodio.read(new ParIdSerieIdEpisodio(idSerie, -1));
        for (ParIdSerieIdEpisodio par : pares) {
            Episodio e = this.read(par.getIdEpisodio());
            if (e != null)
                episodios.add(e);
        }
        return episodios;
    }
}
