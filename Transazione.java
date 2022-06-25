public class Transazione {
    private long id;
    private Servizio servizio;
    private Borsello borsello;
    private float ammontare;

    public Transazione() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setServizio(Servizio servizio) {
        this.servizio = servizio;
    }

    public void setBorsello(Borsello borsello) {
        this.borsello = borsello;
    }

    public void setAmmontare(float ammontare) {
        this.ammontare = ammontare;
    }

    public long getId() {
        return id;
    }

    public Servizio getServizio() {
        return servizio;
    }

    public Borsello getBorsello() {
        return borsello;
    }

    public float getAmmontare() {
        return ammontare;
    }
}
