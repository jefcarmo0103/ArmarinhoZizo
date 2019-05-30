package Models;

import java.util.Calendar;
import java.util.Date;

public class Cliente extends DefaultModel {

	public int Id;
	public String Nome;
	public Calendar Data_Nasc;
	public String Email;
	public String Telefone;


	public Cliente(){}
	public Cliente(String nome, String email, String telefone, Calendar data_nasc){
		Nome = nome;
		Email = email;
		Telefone = telefone;
		Data_Nasc = data_nasc;
	}
	
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
	public Calendar getData_Nasc() {
		return Data_Nasc;
	}

	public void setData_Nasc(Calendar data_Nasc) {

		Data_Nasc = data_Nasc;
	}

	@Override
	public String toString()
	{
		return "Cliente [Nome=" + Nome +"]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}





	
	
	
	
}
