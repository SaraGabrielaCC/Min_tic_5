package mintic.Reto51.Controller.DTOs;

import mintic.Reto51.Entities.Client;

public class TotalAndClient {

    private Long total;
    private Client client;

    public TotalAndClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
