/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimasAngga.uts.jadwal.data.model;

/**
 *
 * Nama : Dimas Angga Surya Wijaya
 * NIM : 211011400018
 * Kelas : 04TPLE001
 */
public class Dosen {
    
    private String namaLengkap;
    private String nidn;
    private String jenisKelamin;
    private String prodi;
    
    /**
     * 
     * @param namaLengkap
     * @param nidn
     * @param jenisKelamin
     * @param prodi
     */
    public Dosen(String namaLengkap, String nidn, String jenisKelamin, String prodi){
        this.namaLengkap = namaLengkap;
        this.nidn = nidn;
        this.jenisKelamin = jenisKelamin;
        this.prodi = prodi;
    }
    
    /** getter
     * method untuk mengembalikan namaLengkap dari object Dosen
     * @return String namaLengkap
     */
    public String getName(){
        return namaLengkap;
    }
    
    /**
     * getter
     * method untuk mengembalikan nidn dari object Dosen
     * @return String nidn;
     */
    public String getNidn(){
        return nidn;
    }
    
    /**
     * getter
     * method untuk mengembalikan jenisKelamin dari object Dosen
     * @return String jenisKelamin
     */
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    
    /**
     * getter
     * method untuk mengembalikan prodi dari object Dosen
     * @return 
     */
    public String getProdi(){
        return prodi;
    }
}

