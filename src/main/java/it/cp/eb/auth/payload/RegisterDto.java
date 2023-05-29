package it.cp.eb.auth.payload;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
	private String name;
    private String username;
    private String email;
    private String password;
	
    //private String surname;
	//private String birthDate;
	//private String address;
	//private String phonenumber;
	//private String idNumber;

 // Per registrare tutti come USER di Default commentare roles
 //   private Set<String> roles;
}
