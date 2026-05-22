package br.com.philance.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servico;
    private Long id_usuario;
    private int tags;
    private String titulo;
    private boolean status;
    private String descricao;
    private Double pagamento;
    private Date data_inicio;
    private int horas_trabalho;
    private String endereco;
    private int idade_min;
    private String vestimenta;
    private Date data_criacao;
    private Date data_edicao;


    //Construtor padrão obrigatório que o JPA precisa para funcionar
    // Construtor para facilitar a criação dos dados
    public Service(Long id_servico, Long id_usuario, int tags, String titulo, boolean status, String descricao, Double pagamento, Date data_inicio, int horas_trabalho, String endereco, int idade_min, String vestimenta, Date data_criacao, Date data_edicao) {
        this.id_servico = id_servico;
        this.id_usuario = id_usuario;
        this.tags = tags;
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
        this.pagamento = pagamento;
        this.data_inicio = data_inicio;
        this.horas_trabalho = horas_trabalho;
        this.endereco = endereco;
        this.idade_min = idade_min;
        this.vestimenta = vestimenta;
        this.data_criacao = data_criacao;
        this.data_edicao = data_edicao;
    }


    // O Spring Boot PRECISA dos métodos Getters para transformar o objeto em JSON

    public Long getId_servico() {return id_servico;}
    public Long getId_usuario() {return id_usuario;}
    public int getTags() {return tags;}
    public String getTitulo() {return titulo;}
    public boolean isStatus() {return status;}
    public String getDescricao() {return descricao;}
    public Double getPagamento() {return pagamento;}
    public Date getData_inicio() {return data_inicio;}
    public int getHoras_trabalho() {return horas_trabalho;}
    public String getEndereco() {return endereco;}
    public int getIdade_min() {return idade_min;}
    public String getVestimenta() {return vestimenta;}
    public Date getData_criacao() {return data_criacao;}
    public Date getData_edicao() {return data_edicao;}
}
