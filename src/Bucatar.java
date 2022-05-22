public class Bucatar {

  private final Specializare specializare;
  private final Nivel nivel;
  private int comenziExecutate;

  public Bucatar() {
    this.nivel = genereazaNivel();
    this.specializare = genereazaSpecializare();
    this.comenziExecutate = 0;
  }

  public Bucatar(Specializare specializare, Nivel nivel) {
    this.nivel = nivel;
    this.specializare = specializare;
    this.comenziExecutate = 0;
  }

  public void executaComanda() {
    this.comenziExecutate++;
  }

  public int nrComenziExecutate() {
    return this.comenziExecutate;
  }

  /* Genereaza o specializare la intamplare pentru bucatar */
  private Specializare genereazaSpecializare() {
    Specializare[] specializari = Specializare.values();
    int nrSpecializare = (int) (Math.random() * specializari.length);
    return specializari[nrSpecializare];
  }

  /* Genereaza un nivel la intamplare pentru bucatar */
  private Nivel genereazaNivel() {
    Nivel[] nivele = Nivel.values();
    int nrNivel = (int) (Math.random() * nivele.length);
    return nivele[nrNivel];
  }
}
