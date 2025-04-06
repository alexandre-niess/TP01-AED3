package indexacao;

import java.io.*;

import aed3.RegistroArvoreBMais;

public class ParIdSerieIdEpisodio implements RegistroArvoreBMais<ParIdSerieIdEpisodio> {

    private int idSerie;
    private int idEpisodio;

    public ParIdSerieIdEpisodio() {
        this(-1, -1);
    }

    public ParIdSerieIdEpisodio(int idSerie, int idEpisodio) {
        this.idSerie = idSerie;
        this.idEpisodio = idEpisodio;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public int getIdEpisodio() {
        return idEpisodio;
    }

    @Override
    public String toString() {
        return "[" + idSerie + ";" + idEpisodio + "]";
    }

    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(idSerie);
        dos.writeInt(idEpisodio);
        return baos.toByteArray();
    }

    @Override
    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.idSerie = dis.readInt();
        this.idEpisodio = dis.readInt();
    }

    @Override
    public int compareTo(ParIdSerieIdEpisodio outro) {
        if (this.idSerie != outro.idSerie)
            return this.idSerie - outro.idSerie;
        return this.idEpisodio - outro.idEpisodio;
    }

    @Override
    public int size() {
        return 8; // 2 inteiros
    }

    @Override
    public ParIdSerieIdEpisodio clone() {
        return new ParIdSerieIdEpisodio(idSerie, idEpisodio);
    }
}
