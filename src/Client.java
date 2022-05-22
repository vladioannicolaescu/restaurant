public class Client {

  private final TipClient tipClient;
  private Ospatar ospatar;

  public Client(TipClient tipClient) {
    this.tipClient = tipClient;
  }

  public TipClient tipClient() {
    return tipClient;
  }

  public void primesteOspatar(Ospatar ospatar) {
    this.ospatar = ospatar;
  }

  public void comanda(Comanda comanda) {
    ospatar.executaComanda(comanda);
  }
}
