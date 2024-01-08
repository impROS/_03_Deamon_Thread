/*
Daemon Thread terimi, Java dilinde bir tür thread'i ifade eder.
Daemon thread'ler, bir Java programının ana thread'inin çalışmaya devam ettiği sürece çalışan
ve genellikle sistem hizmetlerini, otomatik görevleri veya diğer yardımcı işlemleri gerçekleştiren thread'lerdir.

Daemon thread'ler, diğer tüm non-daemon thread'ler tamamlandığında veya sonlandığında otomatik olarak sonlanır.
Yani, eğer programın ana thread'i ve diğer non-daemon thread'ler tamamlandıysa, daemon thread'ler de sonlanır.

Daemon thread'ler genellikle arka planda çalışan sistem servislerini veya belirli görevleri yerine getirmek için
kullanılır. Örneğin, bir otomatik güncelleme işlemi, veritabanı temizleme, loglama gibi işlemleri
gerçekleştirebilirler.

Daemon thread'ler genellikle düşük önceliklidir, bu nedenle diğer thread'lerle rekabet etmeyerek daha az
aynak tüketirler.

Bu örnek, bir daemon thread oluşturarak bu thread'in sürekli bir şekilde çalışmasını sağlar.
Ana thread, bir süre bekledikten sonra programdan çıkar.
Bu durumda, daemon thread de programın çıkmasına bağlı olarak sonlanacaktır.*/


public class Main {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true);

        daemonThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread exiting");
    }
}

