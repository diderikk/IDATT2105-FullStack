package com.diderikk.oving2.DAO;

import java.util.List;

import com.diderikk.oving2.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public Address getAddressById(long id){
        String sql = "SELECT * FROM address WHERE address_id = ?";
        return jdbcTemplate.queryForObject(sql, 
        new Object[]{id},(rs, rowNum) ->
        new Address(rs.getLong("address_id"),
        rs.getString("address_gatename"),
        rs.getInt("address_gatenumber")));
    }

    public List<Address> getAddresses(){
        String sql = "SELECT * FROM address";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
        new Address(rs.getLong("address_id"),
        rs.getString("address_gatename"),
        rs.getInt("address_gatenumber")));
    }

    public int update(long id, Address address){
        String sql = "UPDATE address SET address_gatename = ?, address_gatenumber = ? WHERE address_id = ?";
        return jdbcTemplate.update(sql, new Object[]{address.getGateName(), address.getGateNumber(), id});
    }

    public int insert(Address address){
        String sql = "INSERT INTO address (address_gatename, address_gatenumber) VALUES (?, ?)";
        return jdbcTemplate.update(sql, new Object[]{address.getGateName(), address.getGateNumber()});
    }

    public int delete(long id){
        String sql = "DELETE FROM address WHERE address_id = ?";
        return jdbcTemplate.update(sql,new Object[]{id});
    }
}
