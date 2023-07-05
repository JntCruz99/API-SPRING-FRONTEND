package com.CourseSecurity.Security;

import com.CourseSecurity.Security.entity.Usuario;
import com.CourseSecurity.Security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public void run(String... args) throws Exception {
		//Usuario user = new Usuario();
		//user.setLogin("aluno");
		//user.setPassword(new BCryptPasswordEncoder().encode("senha"));
		//usuarioRepository.save(user);
	}
}
