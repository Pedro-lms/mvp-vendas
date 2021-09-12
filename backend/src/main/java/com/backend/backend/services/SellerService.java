package com.backend.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.SellerDTO;
import com.backend.backend.entities.Seller;
import com.backend.backend.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired //Injeção automatica e aclopamento fraco
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
