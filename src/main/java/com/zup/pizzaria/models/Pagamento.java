package com.zup.pizzaria.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @NotNull
    private String formaPagamento;

    @NotNull
    @DecimalMin(value = "0.01", message = "O valor pago deve ser maior que zero.")
    private BigDecimal valorPago;

    @NotNull
    private String dataHoraPagamento;

    // Construtores
    public Pagamento() {}

    public Pagamento(Pedido pedido, String formaPagamento, BigDecimal valorPago, String dataHoraPagamento) {
        this.pedido = pedido;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(String dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    // Validações de pagamento
    public boolean isValorPagoValido() {
        return valorPago.compareTo(pedido.getValorTotal()) >= 0;
    }

    public boolean isDataHoraValida() {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime.parse(dataHoraPagamento, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Método para exibir opções de pagamento
    public static String[] obterOpcoesPagamento() {
        return new String[] {"CARTÃO", "DINHEIRO", "PIX"};
    }
}

