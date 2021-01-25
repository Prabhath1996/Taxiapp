package com.TaxiApp.repository.Rider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TaxiApp.Rider;

@Repository
public class JdbcRiderRepository implements RiderRepository{

	// Spring Boot will create and configure DataSource and JdbcTemplate
    // To use it, just @Autowired
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from Riders", Integer.class);
    }

    @Override
    public int save(Rider rider) {
        return jdbcTemplate.update(
                "INSERT INTO `rider`( `name`, `gender`, `country`, `phone_no`, `dob`, `current_payment_type`, `current_payement_ac`) VALUES (?,?,?,?,?,?,?)",
                rider.getName(), rider.getGender(),rider.getCountry(),rider.getPhone_no(),
                rider.getDob(),rider.getCurrent_payment_type(),rider.getCurrent_payement_ac());
    }

    @Override
    public int update(Rider rider) {
        return jdbcTemplate.update(
                "UPDATE `rider` SET `name`= ? ,`joined_date`= ? ,`gender`= ? ,`country`= ? ,`phone_no`= ? ,`dob`= ? ,`current_payment_type`= ? ,`current_payement_ac`= ? WHERE `id`= ? ",
                rider.getName(),rider.getJoined_date(), rider.getGender(),rider.getCountry(),rider.getPhone_no(),
                rider.getDob(),rider.getCurrent_payment_type(),rider.getCurrent_payement_ac(),rider.getId());
    }


    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from Riders where id = ?",
                id);
    }

    @Override
    public List<Rider> findAll() {
        return jdbcTemplate.query(
                "select * from rider",
                (rs, rowNum) ->
                
                        new Rider(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getTimestamp("joined_date"),
                                rs.getString("gender"),
                                rs.getString("country"),
                                rs.getString("phone_no"),
                                rs.getDate("dob"),
                                rs.getString("current_payment_type"),
                                rs.getString("current_payement_ac")
                        )
                       
        );
        

        }
    
    public List<String> getAllUser(){
    	List<String> users = new ArrayList<String>();
    	users.addAll(jdbcTemplate.queryForList("select name from rider;",String.class));
    	return users;
    	
    }
   
    

}
