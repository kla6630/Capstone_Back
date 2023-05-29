package it.cp.eb.auth.service;

import it.cp.eb.auth.payload.LoginDto;
import it.cp.eb.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
