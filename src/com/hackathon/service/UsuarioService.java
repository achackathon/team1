package com.hackathon.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.hackathon.model.Usuario;

@WebService
public interface UsuarioService {
	
	@WebMethod
	List<Usuario> getUsuarios();
	
	@WebMethod
	Usuario find(int id);
	
	@WebMethod
	public void add(Usuario usuario);
	
	@WebMethod
	public void delete(Usuario usuario);
	
	@WebMethod
	public boolean update(Usuario usuario);

	
}
