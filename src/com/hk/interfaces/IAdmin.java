
package com.hk.interfaces;

import com.hk.models.Admin;


public interface IAdmin extends CRUD<Admin>{
    public Admin buscar(int id);
}
