/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimasAngga.uts.jadwal.data.model;

import com.dimasAngga.uts.jadwal.data.interfaces.JadwalListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class JadwalMengajar extends JadwalMatkul {
    private final ArrayList<Jadwal> listJadwal = new ArrayList<>(
            Arrays.asList(
                    new Jadwal(new Dosen("MUHAMAD ARIEF YULIANTO", "111", "L", "TI"), "PEMROGRAMAN 1", "07:40 - 09:20", "404", "3"),
                    new Jadwal(new Dosen("MAULANA  FANSYURI", "222", "L", "TI"),"BASIS DATA", "09:20 - 11:00", "404", "2"),
                    new Jadwal(new Dosen("WASIS HARYONO", "333", "P", "TI"), "PENGANTAR APLIKASI KOMPUTER","11:00 - 13:50", "404", "3"),
                    new Jadwal(new Dosen("AHMAD ARIFIN", "444", "L", "TI"), "B INGRISS", "13:50 - 15:30", "404", "2")
            )
    );
    private JadwalListener jadwalListener;
    
    public void setJadwalListener(JadwalListener jadwalListener){
        this.jadwalListener = jadwalListener;
    }
    
    @Override
    public void tambahJadwal(Jadwal jadwal) {
        listJadwal.add(jadwal);
        jadwalListener.onAdd("Berhasil menambahkan jadwal baru !");
    }

    @Override
    public void updateJadwal(int position, Jadwal jadwal) {
        try {
            listJadwal.set(position, jadwal);
            jadwalListener.onUpdate("Berhasil mengupdate jadwal baru !");
        } catch (Exception e){
            jadwalListener.onUpdate("Gagal mengupdate data !");
        }
    }
    
    @Override
    public void hapusJadwal(int position){
        try {
            listJadwal.remove(position);
            jadwalListener.onDelete("Berhasil menghapus jadwal !");
        } catch (Exception e){
            jadwalListener.onDelete("Gagal menghapus jadwal !");
        }
    }
    @Override
    public  Jadwal lihatJadwal(int position) {
        return listJadwal.get(position);
    }
    
    @Override
    public ArrayList<Jadwal> lihatSemuaJadwal(){
        return listJadwal;
    }
    
}