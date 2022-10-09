package prova;

import java.util.Date;

public class Usuario {
	
	private String nome;
	private String enderecoInstalacao;
	private Date dataInstalacao;
	private String numeroTelefone;
	private boolean possuiInternet;
	private double valorBasico;
	private String tipoTelefone;

	public Usuario(String nome, String enderecoInstalacao, Date dataInstalacao, String numeroTelefone,
			boolean possuiInternet, double valorBasico, String tipoTelefone) {
		super();
		this.nome = nome;
		this.enderecoInstalacao = enderecoInstalacao;
		this.dataInstalacao = dataInstalacao;
		this.numeroTelefone = numeroTelefone;
		this.possuiInternet = possuiInternet;
		this.valorBasico = valorBasico;
	}
	
	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public void setValorBasico(double valorBasico) {
		this.valorBasico = valorBasico;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderecoInstalacao() {
		return enderecoInstalacao;
	}

	public void setEnderecoInstalacao(String enderecoInstalacao) {
		this.enderecoInstalacao = enderecoInstalacao;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public boolean isPossuiInternet() {
		return possuiInternet;
	}

	public void setPossuiInternet(boolean possuiInternet) {
		this.possuiInternet = possuiInternet;
	}

	public double getValorBasico() {
		return valorBasico;
	}
}
