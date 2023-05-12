/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimasAngga.uts.jadwal;

import com.dimasAngga.uts.jadwal.data.interfaces.JadwalListener;
import com.dimasAngga.uts.jadwal.data.model.Dosen;
import com.dimasAngga.uts.jadwal.data.model.Jadwal;
import com.dimasAngga.uts.jadwal.data.model.JadwalMengajar;
import java.util.Scanner;
/**
 *
 * Nama : Dimas Angga Surya Wijaya
 * NIM : 211011400018
 * Kelas : 01TPLE001
 */
public class Main implements JadwalListener {
    
    //deklarasi dan initialisasi object JadwalMengajar
    JadwalMengajar jadwalMengajar = new JadwalMengajar();
    Scanner scannerMenu;
    Scanner scannerRestart;
    String restart = "y";
    public static void main(String args[]){
        Main main = new Main();
        main.initProgram();
    }
    
    public void initProgram(){
        // instance object Scanner
        scannerMenu = new Scanner(System.in);
        int menu;
        // set listener pada object jadwalMengajar
        jadwalMengajar.setJadwalListener(this);
        
        
        do {
            printOutput("=========================================");
            printOutput("===== PROGRAM JADWAL DOSEN MENGAJAR =====");
            printOutput("=========================================");
            printOutput("1. LIHAT SEMUA JADWAL");
            printOutput("2. TAMBAH JADWAL");
            printOutput("3. UBAH JADWAL");
            printOutput("4. HAPUS JADWAL");
            printOutput("0. KELUAR PROGRAM");
            System.out.print("PILIH MENU : ");
            menu = scannerMenu.nextInt();
            switch(menu){
                case 1:
                    printListJadwal();
                    break;
                case 2:
                    tambahJadwal();
                    break;
                case 3:
                    updateJadwal();
                    break;
                case 4:
                    hapusJadwal();
                    break;
                case 0:
                    return;
                default:
                    printOutput("Pilihan tidak valid !");
                    
            }
            System.out.println();
        } while (!restart.equalsIgnoreCase("n"));
    }
    
    
    /** method menampilkan list Jadwal*/
    public void printListJadwal(){
        printOutput("===== LIST JADWAL MENGAJAR =====");
                    if(jadwalMengajar.lihatSemuaJadwal() != null && jadwalMengajar.lihatSemuaJadwal().size() > 0){
                        int number = 0;
                        for(Jadwal jadwal : jadwalMengajar.lihatSemuaJadwal()){
                            number++;
                            printOutput(number+"");
                            printOutput("MATKUL     :" + jadwal.getMatkul());
                            printOutput("JAM        :" + jadwal.getJam());
                            printOutput("SKS        :" + jadwal.getSks());
                            printOutput("RUANGAN    : "+jadwal.getRuangan());
                            printOutput("DOSEN      : "+ jadwal.getDosen().getName());
                        }
                        restart();
                    } else {
                        printOutput("Tidak ada list jadwal tersedia !");
                        restart();
                        
                    }
                    
    }
    
    /// method untuk tambah jadwal
    public void tambahJadwal(){
        System.out.print("NAMA DOSEN    : ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("NIDN          : ");
        String nidn = new Scanner(System.in).nextLine();
        System.out.print("JENIS KELAMIN L/P : ");
        String jenisKelamin = new Scanner(System.in).nextLine();
        System.out.print("PRODI : ");
        String prodi = new Scanner(System.in).nextLine();
        
        Dosen dosen = new Dosen(name, nidn, jenisKelamin, prodi);
        
        //matkul, jam, ruangan, sks
        System.out.print("MATKUL : ");
        String matkul = new Scanner(System.in).nextLine();
        System.out.print("JAM : ");
        String jam = new Scanner(System.in).nextLine();
        System.out.print("RUANGAN : ");
        String ruangan = new Scanner(System.in).nextLine();
        System.out.print("SKS : ");
        String sks = new Scanner(System.in).nextLine();
        jadwalMengajar.tambahJadwal(new Jadwal(dosen, matkul, jam, ruangan, sks));
    }
    
    /// method untuk tambah jadwal
    public void updateJadwal(){
        int total = jadwalMengajar.lihatSemuaJadwal().size();
        System.out.print("MASUKAN URUTAN JADWAL YANG MAU DIUPDATE (1-"+total+") : ");
        int position = new Scanner(System.in).nextInt();
        System.out.print("NAMA DOSEN    : ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("NIDN          : ");
        String nidn = new Scanner(System.in).nextLine();
        System.out.print("JENIS KELAMIN L/P : ");
        String jenisKelamin = new Scanner(System.in).nextLine();
        System.out.print("PRODI : ");
        String prodi = new Scanner(System.in).nextLine();
        
        Dosen dosen = new Dosen(name, nidn, jenisKelamin, prodi);
        
        //matkul, jam, ruangan, sks
        System.out.print("MATKUL : ");
        String matkul = new Scanner(System.in).nextLine();
        System.out.print("JAM : ");
        String jam = new Scanner(System.in).nextLine();
        System.out.print("RUANGAN : ");
        String ruangan = new Scanner(System.in).nextLine();
        System.out.print("SKS : ");
        String sks = new Scanner(System.in).nextLine();
        jadwalMengajar.updateJadwal(position-1, new Jadwal(dosen, matkul, jam, ruangan, sks));
        
    }
    
    /// method untuk menghapus jadwal
    public void hapusJadwal(){
        int total = jadwalMengajar.lihatSemuaJadwal().size();
        System.out.print("MASUKAN URUTAN JADWAL YANG MAU DIHAPUS  (1-"+total+") : ");
        int position = new Scanner(System.in).nextInt();
        jadwalMengajar.hapusJadwal(position-1);
    }
    
    // method menampilkan pertanyaan apakah ulangi atau tidak
    public void restart(){
        scannerRestart = new Scanner(System.in);
        System.out.print("Ulangi program (y / n) ? : ");
                        restart = scannerRestart.nextLine();
    }

    @Override
    public void onAdd(String message) {
        printOutput(message);
        restart();
    }

    @Override
    public void onUpdate(String message) {
        printOutput(message);
        restart();
    }

    @Override
    public void onDelete(String message) {
        printOutput(message);
        restart();
    }
    
    
    /// print message
    static void printOutput(String message){
        System.out.println(message);
    }
    
}
