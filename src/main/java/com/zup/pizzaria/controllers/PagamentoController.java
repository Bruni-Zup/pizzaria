package com.zup.pizzaria.controllers;

import com.pizzaria.model.Pagamento;
import com.pizzaria.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @PostMapping("/realizar")
    public String realizarPagamento(@RequestBody Pagamento pagamento) {
        if (!pagamento.isValorPagoValido()) {
            return "Erro: O valor pago não pode ser menor que o valor total do pedido.";
        }
        if (!pagamento.isDataHoraValida()) {
            return "Erro: O formato da data e hora deve ser dd/MM/yyyy HH:mm.";
        }
        pagamentoRepository.save(pagamento);
        return "Pagamento realizado com sucesso!";
    }

    @GetMapping("/opcoes")
    public String[] obterOpcoesPagamento() {
        return Pagamento.obterOpcoesPagamento();
    }
}

