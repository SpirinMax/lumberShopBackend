package com.partner.dataCrudInterfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.CustomerLogin;

@Repository
public interface CustomerLoginRepository extends CrudRepository<CustomerLogin, Integer> {
	Optional<CustomerLogin> findByLoginAndPassword(String login, String password);
}
