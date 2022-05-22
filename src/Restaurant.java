import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* SINGLETON */
public class Restaurant {

  public static final int NR_MESE_INITIAL = 10;
  public static final int NR_BUCATARI_INITIAL = 10;
  public static final int NR_OSPATARI_INITIAL = 3;

  private static Restaurant instance;
  private final List<Masa> mese;
  private final List<Bucatar> bucatari;
  private final List<Ospatar> ospatari;

  private final Queue<Comanda> comenzi;

  /* Pentru a putea modifica ulterior nr. de mese, de bucatari sau de ospatari,
  * avem urmatoarele fielduri */
  private int nrMese;
  private int nrBucatari;
  private int nrOspatari;

  private Restaurant() {
    this.mese = new ArrayList<>();
    this.bucatari = new ArrayList<>();
    this.ospatari = new ArrayList<>();

    /* In momentul construirii restaurantului, adaugam in lista de mese numarul
    * de mese specificat */
    this.nrMese = NR_MESE_INITIAL;
    for (int i = 0; i < NR_MESE_INITIAL; i++) {
      this.mese.add(new Masa());
    }

    /* In momentul construirii restaurantului, angajam numarul de bucatari
    * mentionat */
    this.nrBucatari = NR_BUCATARI_INITIAL;
    for (int i = 0; i < NR_BUCATARI_INITIAL; i++) {
      this.bucatari.add(new Bucatar());
    }

    /* In momentul construirii restaurantului, angajam numarul de ospatari
     * mentionat */
    this.nrOspatari = NR_OSPATARI_INITIAL;
    for (int i = 0; i < NR_OSPATARI_INITIAL; i++) {
      this.ospatari.add(new Ospatar());
    }

    /* Initializeaza coada de comenzi */
    this.comenzi = new LinkedList<>();
  }

  public static Restaurant getInstance() {
    if (instance == null) {
      instance = new Restaurant();
    }

    return instance;
  }

  public void adaugaMasa() {
    this.nrMese++;
    this.mese.add(new Masa());
  }

  public void angajeazaBucatar(Specializare specializare, Nivel nivel) {
    this.nrBucatari++;
    this.bucatari.add(new Bucatar(specializare, nivel));
  }

  public void angajeazaOspatar() {
    this.nrOspatari++;
    this.ospatari.add(new Ospatar());
  }

  public void adaugaClient(Client client) {
    if (client.tipClient() == TipClient.IN_RESTAURANT) {
      Masa masa = gasesteMasa();

      if (masa != null) {
        masa.ocupaMasa();
        /* Nu ne intereseaza momentan ce client si la ce masa se afla, ci doar
        * faptul ca un client ocupa o masa. Cand va pleca, va elibera tot o
        * masa, irelevant care. */
      } else {
        System.out.println("Momentan nu mai e loc in restaurant");
        return;
      }
    }

    /* Fiecare client va avea un ospatar responsabil pentru comanda sa. */
    Ospatar ospatar = gasesteOspatar();
    client.primesteOspatar(ospatar);
  }

  private Masa gasesteMasa() {
    for (Masa masa : mese) {
      if (masa.eLibera()) {
        return masa;
      }
    }

    return null;
  }

  private Ospatar gasesteOspatar() {
    int indexOspatar = (int) (Math.random() * nrOspatari);
    return ospatari.get(indexOspatar);
  }

}
