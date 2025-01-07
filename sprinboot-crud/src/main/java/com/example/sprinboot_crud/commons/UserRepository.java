package com.example.sprinboot_crud.commons;


import com.example.sprinboot_crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);

}
