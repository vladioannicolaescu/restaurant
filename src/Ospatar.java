public class Ospatar {

  private SelectorBucatar selectorBucatar;

  public Ospatar() {
    this.selectorBucatar = new SelectorEchilibru();
  }

  public void schimbaSelector(SelectorBucatar selector) {
    this.selectorBucatar = selector;
  }

  public void executaComanda(Comanda comanda) {
    Bucatar bucatar = selectorBucatar.selecteazaBucatar(comanda);
    // TODO implementeaza procesul de selectare altfel da NullPointerException
//    bucatar.executaComanda();
  }
}
