package com.recell.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recell.config.JwtProvider;
import com.recell.exception.UserException;
import com.recell.model.User;
import com.recell.repository.UserRepository;
import com.recell.request.LoginRequest;
import com.recell.response.AuthResponse;
import com.recell.service.CustomeUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	//to encode password
	private PasswordEncoder passwordEncoder;
	
	private CustomeUserServiceImplementation customeUserService;
	 
	
	public AuthController(UserRepository userRepository, CustomeUserServiceImplementation customeUserService, PasswordEncoder passwordEncoder,JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.customeUserService=customeUserService;
		this.passwordEncoder=passwordEncoder;
		this.jwtProvider=jwtProvider;
	}

    @PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException{
		String email=user.getEmail();
		String password=user.getPassword();
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		
		User isEmailExist=userRepository.findByEmail(email);
		
		if(isEmailExist!=null) {
			throw new UserException("Email is already used with another Account");
		}
		
		User createdUser=new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));//here we are encoding the password
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);
		
		
		User savedUser=userRepository.save(createdUser);
		
		Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse =new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("SignUp Success");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}
    
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest){
    	
    	String username=loginRequest.getEmail();
    	String password=loginRequest.getPassword();
    	
    	
    	Authentication authentication=authenticate(username, password);
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
        String token=jwtProvider.generateToken(authentication);
		
		AuthResponse authResponse =new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Signin Success");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    	
    }

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails=customeUserService.loadUserByUsername(username);
		
		if(userDetails==null) {
			//is data is not present in database then it will give you BadCredentialsException
			throw new BadCredentialsException("Invalid Username.. ");
		}
		
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password...");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}
}
