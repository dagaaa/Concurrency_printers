public class Drukowanie implements Runnable {
   private int nr;
   private MonitorDrukarek monitorDrukarek;

  public Drukowanie(int nr ,MonitorDrukarek m){
      this.nr=nr;
      monitorDrukarek=m;
  }

    @Override
    public void run() {
      try {
          Integer drukarka = monitorDrukarek.zarezerwuj();
          drukuj(drukarka);
          monitorDrukarek.zwolnij(drukarka);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

    }
    public void drukuj(Integer nrDruk) throws InterruptedException {
        System.out.println("jestem drukareczka o numerze: " +nrDruk+" zaczynam drukowac tresc:  "  +nr);
        Thread.sleep(3000);
        System.out.println("jestem drukareczka o numerze: " +nrDruk+" koncze drukowac tresc:  "  +nr);
    }
}
