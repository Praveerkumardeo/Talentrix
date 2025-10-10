package com.project.Talentix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.Token;
import com.project.Talentix.models.User;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.request.ChangePassRequest;
import com.project.Talentix.request.EmployerRegstrationRequest;
import com.project.Talentix.service.AuthService;
import com.project.Talentix.util.PassEncoder;

import jakarta.servlet.http.HttpSession;


@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepo userRepository;

	@Override
	public Token RegisterUser(UserRegstrationRequest request) {
		// TODO Auto-generated method stub
		String email = request.getEmail();
		String password = PassEncoder.encode(request.getPassword());
		String name = request.getName();
		int phone = request.getPhone();
		
		User user = new User(name, email, password, phone);
		
		userRepository.save(user);
		
		return new Token("User", user.getId());
	}
	
	
	
	@Override
	public Token RegisterEmployer(EmployerRegstrationRequest request) {
		String email = request.getEmail();
		String password = PassEncoder.encode(request.getPassword());
		String name = request.getName();
		int phone = request.getPhone();
		String companyName = request.getCompanyName();
		
		User user = new User(name, email, password, phone, companyName);
		
		userRepository.save(user);
		
		return  new Token("Employer", user.getId());
	}


	@Override
	public Token Login(LoginRequest request) {
		String email = request.getEmail();
		String password = request.getPassword();
		
		User user = userRepository.findByEmail(email);

		
		if(user == null || !PassEncoder.verify(password, user.getPassword())) {
			return null;
		}
		
		return new Token(user.getRole(), user.getId());
	}
	




	@Override
	public boolean changePassword(ChangePassRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		Token token = (Token) session.getAttribute("token");
		
		if(token == null) {
			return false;
		}
		int id = token.getId();
		
		User user = userRepository.findById(id);
		
		String oldPass = request.getOldPass();
		String newPass = request.getNewPass();
		
		if(user != null && PassEncoder.verify(oldPass, user.getPassword())) {
			String encodedNewPass = PassEncoder.encode(newPass);
			user.setPassword(encodedNewPass);
			userRepository.save(user);
			return true;
		}
		
		
		return false;
	}
	

}
