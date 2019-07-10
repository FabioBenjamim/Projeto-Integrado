package br.usjt.pi.Projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_feedback")
public class Feedback implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private int visualizacao;
	
	@Column
	private int gostei;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVisualizacao() {
		return visualizacao;
	}

	public void setVisualizacao(int visualizacao) {
		this.visualizacao = visualizacao;
	}

	public int getGostei() {
		return gostei;
	}

	public void setGostei(int gostei) {
		this.gostei = gostei;
	}

	@Override
	public String toString() {
		return "Curtidas: "+ gostei+ " visualizações: " + visualizacao + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gostei;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + visualizacao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (gostei != other.gostei)
			return false;
		if (id != other.id)
			return false;
		if (visualizacao != other.visualizacao)
			return false;
		return true;
	}
	
	
	
}
