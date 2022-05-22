public class Masa {
  private boolean ocupata;

  public Masa() {
    this.ocupata = false;
  }

  public void ocupaMasa() {
    this.ocupata = true;
  }

  public void elibereazaMasa() {
    this.ocupata = false;
  }

  public boolean eLibera() {
    return !ocupata;
  }
}
