package br.unisal.modelagem;
/** Classe de Modelagem Conceitual de Produto
 * @author Gustavo Silvestre
 * @data 16/04/2024
 */

public class Produto {
	
	//Atributos
	private int codigo;
	private String descricao;
	private UnidadeMedida un;
	private float largura;
	private float comprimento;
	private Situacao situacao;
	private String localizacao;
	public int getCodigo() {
		return codigo;
	}
	
	//Métodos
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UnidadeMedida getUn() {
		return un;
	}
	public void setUn(UnidadeMedida un) {
		this.un = un;
	}
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	public float getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
		@Override 
		public String toString() {
			return "Código: " + getCodigo() + " Descricao: " + getDescricao() + " UnidadeMedida: " + getUn().getDescricao()
					+ " Largura " + getLargura() + " Comprimento: " + getComprimento() + " Situação: " + getSituacao()
					+ " Localização: " + getLocalizacao();
		}
	
}
