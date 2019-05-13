package Models;

import java.util.*;

public class Cliente extends DefaultModel {
	public String Nome;
	public String Email;
	public String Telefone;
	public Date Data_Nasc;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public Date getData_Nasc() {
		return Data_Nasc;
	}
	public void setData_Nasc(Date data_Nasc) {
		Data_Nasc = data_Nasc;
	}
	
	
	
	
}
