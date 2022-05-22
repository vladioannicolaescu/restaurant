public class Main {

  public static void main(String[] args) {

    Restaurant restaurant = Restaurant.getInstance();

    Client client1 = new Client(TipClient.IN_RESTAURANT);
    Client client2 = new Client(TipClient.LA_DOMICILIU);

    restaurant.adaugaClient(client1);
    restaurant.adaugaClient(client2);

    client1.comanda(new ComandaMancareSiBautura());
    client2.comanda(new ComandaMancare());

  }
}
