package com.partner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.AdminRepository;
import com.partner.dataObjects.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	protected AdminService() {

	}
	
	public Optional<Admin> authAdmin (String login, String password) {
		Optional<Admin> foundedAdmin = adminRepository.findByLoginAndPassword(login, password);
		if (foundedAdmin.isPresent()) {
			return adminRepository.findById(foundedAdmin.get().getIdAdm());
		} else {
			return Optional.empty();
		}
	}
}
