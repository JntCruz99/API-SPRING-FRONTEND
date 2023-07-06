package com.CourseSecurity.Security;

import com.CourseSecurity.Security.entity.Role;
import com.CourseSecurity.Security.entity.Usuario;
import com.CourseSecurity.Security.entity.enums.RoleName;
import com.CourseSecurity.Security.repository.RoleRepository;
import com.CourseSecurity.Security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		//Usuario user = new Usuario();
		//user.setLogin("aluno");
		//user.setPassword(new BCryptPasswordEncoder().encode("senha"));
		//usuarioRepository.save(user);

		Role role1 = roleRepository.findByRoleName(RoleName.ROLE_USER);
		Usuario user1 = new Usuario();
		user1.setLogin("user");
		user1.setPassword(new BCryptPasswordEncoder().encode("1234"));
		user1.setRole(role1); // Inicializar a lista de roles
		usuarioRepository.save(user1);
	}
}
