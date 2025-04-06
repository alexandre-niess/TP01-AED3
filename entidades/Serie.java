package entidades;
import java.io.*;
import aed3.Registro;

public class Serie implements Registro {

    private int id;
    private String nome;
    private int anoLancamento;
    private String sinopse;
    private String streaming;

    public Serie() {
        this(-1, "", 0, "", "");
    }

    public Serie(String nome, int anoLancamento, String sinopse, String streaming) {
        this(-1, nome, anoLancamento, sinopse, streaming);
    }

    public Serie(int id, String nome, int anoLancamento, String sinopse, String streaming) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.sinopse = sinopse;
        this.streaming = streaming;
    }

    // Getters e Setters
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }

    public String getNome() { return nome; }
    public int getAnoLancamento() { return anoLancamento; }
    public String getSinopse() { return sinopse; }
    public String getStreaming() { return streaming; }

    public String toString() {
        return "\nID..........: " + id +
               "\nNome........: " + nome +
               "\nAno.........: " + anoLancamento +
               "\nStreaming...: " + streaming +
               "\nSinopse.....: " + sinopse;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(id);
        dos.writeUTF(nome);
        dos.writeInt(anoLancamento);
        dos.writeUTF(sinopse);
        dos.writeUTF(streaming);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        this.id = dis.readInt();
        this.nome = dis.readUTF();
        this.anoLancamento = dis.readInt();
        this.sinopse = dis.readUTF();
        this.streaming = dis.readUTF();
    }
}
