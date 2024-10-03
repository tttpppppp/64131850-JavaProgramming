package cm.service;

import java.util.List;

import cm.model.Role;
import cm.respoitory.RoleRepository;

public class RoleService {
	RoleRepository roleRepository = new RoleRepository();
	public List<Role> getAllRole(){
		return roleRepository.getAllRole();
	}
	public boolean deletRoleById(int id) {
		return roleRepository.deleteRoleById(id) > 0 ? true : false;
	}
	public boolean addRole(String rolename) {
		return roleRepository.addRole(rolename) > 0 ? true : false;
	}
}
