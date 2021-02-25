package com.diderikk.oving2.repository;

import java.util.List;
import java.util.Optional;

import com.diderikk.oving2.DAO.AddressDAO;
import com.diderikk.oving2.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {
   @Autowired
   private AddressDAO addressDAO;
   
   public List<Address> findAll(){
        return addressDAO.getAddresses();
    }

    public Optional<Address> findById(long id) {
        return Optional.of(addressDAO.getAddressById(id));
    }

    public Address save(Address address){      
        if(addressDAO.insert(address) == 1) return address;
        else return null;
    }

    public Address update(long id, Address address){
        if(addressDAO.update(id, address) == 1) return address;
        else return null;
    }

    public void deleteById(long id){
        addressDAO.delete(id);
    }
}
