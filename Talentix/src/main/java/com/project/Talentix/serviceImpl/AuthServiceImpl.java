package com.project.Talentix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Talentix.models.User;
import com.project.Talentix.repo.UserRepo;
import com.project.Talentix.request.LoginRequest;
import com.project.Talentix.request.UserRegstrationRequest;
import com.project.Talentix.request.EmployerRegstrationRequest;
import com.project.Talentix.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepo userRepository;

	@Override
	public String RegisterUser(UserRegstrationRequest request) {
		// TODO Auto-generated method stub
		String email = request.getEmail();
		String password = request.getPassword();
		String name = request.getName();
		int phone = request.getPhone();
		
		User user = new User(name, email, password, phone);
		
		userRepository.save(user);
		
		return "User" + name + "Registered Successfully" + "with Role: User";
	}

	@Override
	public String Login(LoginRequest request) {
		String email = request.getEmail();
		String password = request.getPassword();
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			return "User Not Found";
		}
		
		if(!user.getPassword().equals(password)) {
			return "Invalid Password";
		}
		
		return "User" + user.getName() + "Logged In Successfully";
	}

	@Override
	public String RegisterEmployer(EmployerRegstrationRequest request) {
		String email = request.getEmail();
		String password = request.getPassword();
		String name = request.getName();
		int phone = request.getPhone();
		String companyName = request.getCompanyName();
		
		User user = new User(name, email, password, phone, companyName);
		
		userRepository.save(user);
		
		return "User" + name + "Registered Successfully" + "with Role: Employer";
	}


	
	

}
