package e31192281_queue;

import java.util.Scanner;

/**
 *
 * @author Ihsan
 */
public class Main {

    int angka; //deklarasi variabel angka bertipe data integer
    Main next; //deklarasi variabel next sebagai bagian dari class Main
    static Scanner input = new Scanner(System.in);
    /*
     deklarasi variabel in sebagai bagian dari Scanner serta penambahan keyword
     static agar kelas lain dapat mengakses tanpa melakukan inisiasi
     */

    public void input() {
        System.out.println("Masukkan angka      : "); //perintah untuk menampilkan tulisan pada saat di run
        angka = input.nextInt(); //deklarasi nilai angka sebagai inputan nilai integer
        next = null; //pengindikasian dimana next bernilai null
    }

    public void baca() {
        System.out.println(angka); //perintah untuk menampilkan angka pada saat di run
    }

    public static void main(String[] args) {
        int pilihan = 0; //deklarasi  variabel pilihan bernilai 0 dan bertipe integer
        Queue que = new Queue(); //deklarasi variabel que pada queue
        while (pilihan != 4) { //perulangan while do dengan terdapat 4 kondisi
            System.out.println("1. Enqueue"); //perintah untuk menampilkan pilihan no 1 enqueue saat di run
            System.out.println("2. Dequeue"); //perintah untuk menampilkan pilihan no 2 dequeue saat di run
            System.out.println("3. Lihat"); //perintah untuk menampilkan pilihan no 3 lihat saat di run
            System.out.println("4. Keluar"); // perintah untuk menampilkan pilihan no 4 keluar saat di run
            System.out.println("Masukkan pilihan : "); //perintah untuk menampilkan tulisan saat di run
            pilihan = input.nextInt(); //mengambil data pada input untuk digunakan pada variabel pilihan
            if (pilihan == 1) { //kondisi dimana jika memilih pilihan 1
                que.enqueue(); //mengambil fungsi pada void enqueue
            } else if (pilihan == 2) { //kondisi dimana jika memilih pilihan 2
                que.dequeue(); //mengambil fungsi pada void dequeue
            } else if (pilihan == 3) { //kondisi dimana jika memilih pilihan 3
                que.lihat(); //mengambil fungsi void lihat
            } else if (pilihan == 4) { //kondisi dimana jika memilih pilihan 4
                System.out.println("KELUAR"); //perintah yang memunculkan tulisan keluar saat memilih pilihan nomor 4
            } else {
                System.out.println("SALAH"); //perintah yang memunculkan tulisan salah ketika terjadi kondisi inputan nomor selain nomor 1-4
            }
            System.out.print(""); //perintah untuk memunculkan jarak saat program berjalan
        }
    }
}

class Queue {

    Main batasAtas; //deklarasi variabel dari class Main
    Main batasBawah; //deklarasi variabel dari class Main

    public Queue() {
        batasAtas = null; //deklarasi nilai batasAtas yaitu null
        batasBawah = null; //deklarasi nilai batasBawah yaitu null
    }

    public void enqueue() {
        Main baru = new Main(); //deklarasi variabel baru pada Main
        baru.input(); //penginputan angka
        if (batasAtas == null) { //kondisi yang terjadi jika batas atas bernilai null
            batasAtas = baru; //nilai dari batas atas akan sama dengan baru yaitu inputan yang paling atas
        } else {
            batasBawah.next = baru; //kondisi yang terjadi jika batas atas tidak bernilai null maka atas bawah sebagai batas atas
        }
        batasBawah = baru;
    }
    /*
     void enqueue adalah sebuah fungsi untuk menambah data angka dimana data yang dimasukkan
     akan berada diurutan paling awal. Kemudian perintah Main baru = new Main()berguna untuk
     membuat angka baru berdasarkan input. Jika batas atas = null maka batas atas menjadi
     data awal dan akhir akan sama dengan baru. Lalu jika data awal tidak sama null maka
     akan menjalankan perintah batas bawah.next() = baru yang gunanya untuk menguhubungkan
     data baru ke bagian bawah atau awal.
     */

    public void dequeue() {
        if (batasAtas == null) { //kondisi yang terjadi jika nilai batas atas = null
            System.out.println("Kosong"); //perintah untuk menampilkan tulisan Kosong saat kondisi if terpenuhi
        } else {
            System.out.println("Keluar Data dengan Angka : " + batasAtas.angka); //perintah untuk menampilkan tulisan jika kondisi if tidak terpenuhi
            batasAtas = batasAtas.next; //kondisi yang terjadi jika batas atas tidak bernilai null maka batas atas tetap menjadi batas atas
        }
    }
    /*
     void dequeue adalah fungsi untuk menghapus data terbaru yang telah ditambahkan. Jika batas atas
     bernilai null maka program akan menampilkan kosong. Lalu jika batas atas tidak bernilai null maka 
     program akan menampilkan tulisan keluar data dengan angka diikuti angkanya serta menjalankan
     batasAtas = batasAtas yang digunakan untuk memindahkan batas atas ke bagian sebelum data terbaru.
     */

    public void lihat() {
        if (batasAtas == null) { //kondisi yang terjadi jika nilai batas atas sama dengan null
            System.out.println("Kosong"); //perintah untuk menampilkan tulisan Kosong saat kondisi if terpenuhi
        } else {
            System.out.println("Angka yang ada adalah : "); //perintah untuk menampilkan tulisan angka yang ada adalah jika kondisi if tidak terpenuhi
            for (Main a = batasAtas; a != null; a = a.next) { //perulangan dimana a adalah batas atas dan a adalah negasi dari null
                a.baca(); //a akan melakukan fungsi void baca yaitu menampilkan data yang tersimpan
            }
        }
    }
}