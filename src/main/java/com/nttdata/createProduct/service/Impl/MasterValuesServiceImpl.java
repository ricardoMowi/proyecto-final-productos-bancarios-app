package com.nttdata.createProduct.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.createProduct.entity.MasterValues;
import com.nttdata.createProduct.repository.MasterValueRepository;
import com.nttdata.createProduct.service.MasterValuesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MasterValuesServiceImpl implements MasterValuesService{
    @Autowired
	private MasterValueRepository masterValueRepository;

    
	public Flux<MasterValues> getAll() {
		return masterValueRepository.findAll();
	
	}

	public Mono<MasterValues> getMasterValue(String id) {
		return masterValueRepository.findById(id);
	}
	
	public Mono<MasterValues> createMasterValue(MasterValues new_register) {

		java.util.Date date = new java.util.Date();
        new_register.setCreationDate(date);
		new_register.setStatus("ACTIVE");
		return masterValueRepository.save(new_register);
	}
	

	public Mono<MasterValues> updateMasterValue(MasterValues temp_register,String id){
		return masterValueRepository.findById(id)
				.map(c->{
					c.setDescription(temp_register.getDescription());
                    c.setCode(temp_register.getCode());
                    c.setValue(temp_register.getValue());
                    c.setMasterType(temp_register.getMasterType());
					return c;
				}).flatMap(masterValueRepository::save);
	}
	
	public Mono<Void> deleteMasterValue(String id){
		return masterValueRepository.deleteById(id);
	}
	
	public Mono<MasterValues> setInactiveMasterValue(String id){
		return masterValueRepository.findById(id)
				.doOnNext(e->e.setStatus("INACTIVE"))
				.flatMap(masterValueRepository::save);
	}
}
