/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimasAngga.uts.jadwal.data.interfaces;

/**
 *
 * @author User
 */
public interface JadwalListener {
    void onAdd(String message);
    void onUpdate(String message);
    void onDelete(String message);
}
