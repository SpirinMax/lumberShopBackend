package com.partner.dataCrudInterfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	Optional<Admin> findByLoginAndPassword (String login, String password);
}
