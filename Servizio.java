public class Servizio {
    private long id;
    private ModalitaErogazione modalitaErogazione;

    public Servizio() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setModalitaErogazione(ModalitaErogazione modalitaErogazione) {
        this.modalitaErogazione = modalitaErogazione;
    }

    public long getId() {
        return id;
    }

    public ModalitaErogazione getModalitaErogazione() {
        return modalitaErogazione;
    }
}
