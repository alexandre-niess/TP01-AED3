package entidades;
import java.io.*;
import aed3.Registro;

public class Episodio implements Registro {

    private int id;
    private int idSerie;
    private String nome;
    private int temporada;
    private String dataLancamento;
    private int duracao; // em minutos
    private String sinopse;

    public Episodio() {
        this(-1, -1, "", 0, "", 0, "");
    }

    public Episodio(int idSerie, String nome, int temporada, String dataLancamento, int duracao, String sinopse) {
        this(-1, idSerie, nome, temporada, dataLancamento, duracao, sinopse);
    }

    public Episodio(int id, int idSerie, String nome, int temporada, String dataLancamento, int duracao, String sinopse) {
        this.id = id;
        this.idSerie = idSerie;
        this.nome = nome;
        this.temporada = temporada;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.sinopse = sinopse;
    }

    // Getters e Setters
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }

    public int getIdSerie() { return idSerie; }
    public String getNome() { return nome; }
    public int getTemporada() { return temporada; }
    public String getDataLancamento() { return dataLancamento; }
    public int getDuracao() { return duracao; }
    public String getSinopse() { return sinopse; }

    public String toString() {
        return "\nID..............: " + id +
               "\nID da Série.....: " + idSerie +
               "\nNome............: " + nome +
               "\nTemporada.......: " + temporada +
               "\nData Lançamento.: " + dataLancamento +
               "\nDuração.........: " + duracao + " min" +
               "\nSinopse.........: " + sinopse;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(id);
        dos.writeInt(idSerie);
        dos.writeUTF(nome);
        dos.writeInt(temporada);
        dos.writeUTF(dataLancamento);
        dos.writeInt(duracao);
        dos.writeUTF(sinopse);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.id = dis.readInt();
        this.idSerie = dis.readInt();
        this.nome = dis.readUTF();
        this.temporada = dis.readInt();
        this.dataLancamento = dis.readUTF();
        this.duracao = dis.readInt();
        this.sinopse = dis.readUTF();
    }
}
