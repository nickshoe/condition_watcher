public class Borsello {
    private long id;
    private FonteFinanziamento fonteFinanziamento;

    public Borsello() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setFonteFinanziamento(FonteFinanziamento fonteFinanziamento) {
        this.fonteFinanziamento = fonteFinanziamento;
    }

    public long getId() {
        return id;
    }

    public FonteFinanziamento getFonteFinanziamento() {
        return fonteFinanziamento;
    }
}
