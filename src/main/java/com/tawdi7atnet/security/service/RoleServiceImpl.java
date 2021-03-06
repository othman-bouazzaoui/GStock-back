package com.tawdi7atnet.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tawdi7atnet.exception.EntityNotFoundException;
import com.tawdi7atnet.security.dao.RoleRepository;
import com.tawdi7atnet.security.entities.RoleEntity;

@Service
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<RoleEntity> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public RoleEntity findRoleById(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role Id '" + id + "'Not Found !! "));
	}

	@Override
	public RoleEntity addRole(RoleEntity role) {
		System.out.println(role);
		return roleRepository.save(role);
	}

	@Override
	public RoleEntity updateRole(RoleEntity role) {
		findRoleById(role.getIdRole());
		return roleRepository.save(role);
	}

	@Override
	public void deleteRoleById(Long id) {
		findRoleById(id);
		roleRepository.deleteById(id);
	}

	@Override
	public RoleEntity findByRoleName(String name) {
		return roleRepository.findByRoleName(name);
	}

}
