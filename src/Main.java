import java.util.Scanner;

class Kendaraan {
    private String platNomor;
    private int jumlahPenumpang;
    private int kapasitas;
    public Driver driver;

    public Kendaraan(String platNomor, int kapasitas) {
        this.platNomor = platNomor;
        this.kapasitas = kapasitas;
        this.jumlahPenumpang = 0;
    }

    void setDriver(Driver driver) {
        this.driver = driver;
        System.out.println("Driver " + driver.nama + " telah ditetapkan ke kendaraan " + this.platNomor);
    }

    void penumpangNaik(int jumlah) {
        if (jumlahPenumpang + jumlah > kapasitas) {
            System.out.println("Penumpang melebihi kapasitas.");
        } else {
            jumlahPenumpang += jumlah;
            System.out.println(jumlah + " penumpang naik. Total penumpang sekarang: " + jumlahPenumpang);
        }
    }

    void penumpangTurun(int jumlah) {
        if (jumlah > jumlahPenumpang) {
            System.out.println("Tidak cukup penumpang untuk diturunkan.");
        } else {
            jumlahPenumpang -= jumlah;
            System.out.println(jumlah + " penumpang turun. Total penumpang sekarang: " + jumlahPenumpang);
        }
    }
}

class Bus extends Kendaraan {
    String jenisBus;

    public Bus(String platNomor, int kapasitas, String jenisBus) {
        super(platNomor, kapasitas);
        this.jenisBus = jenisBus;
    }

    void penumpangNaik(int jumlah) {
        super.penumpangNaik(jumlah);
        System.out.println("Selamat datang di Bus jenis " + jenisBus + ".");
    }
}

class Truk extends Kendaraan {
    double kapasitasMuatan;
    public Truk(String platNomor, int kapasitas, double kapasitasMuatan) {
        super(platNomor, kapasitas);
        this.kapasitasMuatan = kapasitasMuatan;
    }
}

class Driver {
    String nama;

    public Driver(String nama) {
        this.nama = nama;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Bus");
        System.out.println("2. Truk");
        System.out.print("Pilihan: ");
        int jenisKendaraan = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");

        Kendaraan kendaraan;

        switch (jenisKendaraan) {
            case 1:
                kendaraan = new Bus("BUS123", 40, "Eksekutif");
                break;
            case 2:
                kendaraan = new Truk("TRK123", 2, 5.5);
                break;
            default:
                System.out.println("Jenis kendaraan tidak valid.");
                return;
        }

        System.out.print("Masukkan nama driver: ");
        String namaDriver = scanner.nextLine();
        Driver driver = new Driver(namaDriver);
        kendaraan.setDriver(driver);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah penumpang");
            System.out.println("2. Turunkan penumpang");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jumlah penumpang naik: ");
                    int jumlah = scanner.nextInt();
                    kendaraan.penumpangNaik(jumlah);
                    break;
                case 2:
                    System.out.print("Jumlah penumpang turun: ");
                    int jumlahTurun = scanner.nextInt();
                    kendaraan.penumpangTurun(jumlahTurun);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
