package com.udemy.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	private Date date;
	private AuthorDTO authorDTO;

	public CommentDto() {

	}

	public CommentDto(String texto, Date date, AuthorDTO authorDTO) {
		this.texto = texto;
		this.date = date;
		this.authorDTO = authorDTO;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
	}

}
