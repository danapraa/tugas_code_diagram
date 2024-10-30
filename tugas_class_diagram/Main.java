// Interface Transportasi
interface Transportasi {
    void bahanBakar();
    void kecepatan();
}

// Class Roda
class Roda {
    private int jumlahRoda;

    public Roda(int jumlahRoda) {
        this.jumlahRoda = jumlahRoda;
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }
}

// Class Mesin
class Mesin {
    public void mesinInfo() {
        System.out.println("Mesin diaktifkan.");
    }
}

// Class Setir
class Setir {
    public void arahSetir(String arah) {
        System.out.println("Mobil berbelok ke " + arah);
    }
}

// Class Mio, turunan dari AutoCarRpl
class Mio extends AutoCarRpl {
    public Mio(int jumlahRoda, Mesin mesin, Setir setir) {
        super(jumlahRoda, mesin, setir);
    }
}

// Class Fuel, turunan dari AutoCarRpl
class Fuel extends AutoCarRpl {
    public Fuel(int jumlahRoda, Mesin mesin, Setir setir) {
        super(jumlahRoda, mesin, setir);
    }
}

// Class AutoCarRpl mengimplementasi interface Transportasi
class AutoCarRpl implements Transportasi {
    private Roda roda;
    private Mesin mesin;
    private Setir setir;

    public AutoCarRpl(int jumlahRoda, Mesin mesin, Setir setir) {
        this.roda = new Roda(jumlahRoda);
        this.mesin = mesin;
        this.setir = setir;
    }

    @Override
    public void bahanBakar() {
        System.out.println("Mengisi bahan bakar pada mobil.");
    }

    @Override
    public void kecepatan() {
        System.out.println("Mengatur kecepatan mobil.");
    }

    public void start() {
        System.out.println("Mobil dinyalakan.");
        mesin.mesinInfo();
    }

    public void drive(String arah) {
        System.out.println("Mobil sedang berjalan.");
        setir.arahSetir(arah);
    }

    public int getJumlahRoda() {
        return roda.getJumlahRoda();
    }
}

// Main Class untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek Setir dan Mesin
        Setir setir = new Setir();
        Mesin mesin = new Mesin();

        // Membuat objek AutoCarRpl (misalnya dengan 4 roda)
        AutoCarRpl mobil = new AutoCarRpl(4, mesin, setir);

        // Menampilkan operasi mobil
        mobil.start();
        mobil.drive("kiri");
        mobil.bahanBakar();
        mobil.kecepatan();

        // Menampilkan jumlah roda
        System.out.println("Jumlah roda: " + mobil.getJumlahRoda());

        // Menggunakan kelas turunan Mio dan Fuel
        Mio mio = new Mio(2, mesin, setir);
        mio.start();
        System.out.println("Jumlah roda Mio: " + mio.getJumlahRoda());

        Fuel fuel = new Fuel(4, mesin, setir);
        fuel.start();
        System.out.println("Jumlah roda Fuel: " + fuel.getJumlahRoda());
    }
}
