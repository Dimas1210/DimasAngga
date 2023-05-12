/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimasAngga.uts.jadwal.data.model;

/**
 *
 * @author User
 */
    public class Jadwal extends JadwalMatkul {
    private final Dosen dosen;
    private final String matkul;
    private final String jam;
    private final String ruangan;
    private final String sks;
    
    public Jadwal(Dosen dosen, String matkul, String jam, String ruangan, String sks){
        this.dosen = dosen;
        this.matkul = matkul;
        this.jam = jam;
        this.ruangan = ruangan;
        this.sks = sks;
    }

   
    
    
    /**
     * getter
     * method untuk mengembalikan dosen dari object Jadwal
     * @return Dosen dosen
     */
    public Dosen getDosen(){
        return dosen;
    }
    
    /**
     * getter
     * method untuk mengembalikan matkul dari object Jadwal
     * @return String matkul
     */
    public String getMatkul(){
        return matkul;
    }
    
    /**
     * getter
     * method untuk mengembalikan jam dari object Jadwal
     * @return String jam
     */
    public String getJam(){
        return jam;
    }
    
    /**
     * getter
     * method untuk mengembalikan ruangan dari object Dosen
     * @return String ruangan
     */
    public String getRuangan(){
        return ruangan;
    }
    
    /**
     * getter
     * method untuk mengembalikan sks dari object Dosen
     * @return String sks;
     */
    public String getSks(){
        return sks;
    }
}

