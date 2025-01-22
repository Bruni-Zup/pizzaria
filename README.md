�#   p i z z a r i a 
 
UML pizzaria

Classe: Pagamento

Atributos:
- `id: Long`  
- `pedido: Pedido`  
- `formaPagamento: String`  
- `valorPago: BigDecimal`  
- `dataHoraPagamento: String`

Métodos:
- `Pagamento(pedido: Pedido, formaPagamento: String, valorPago: BigDecimal, dataHoraPagamento: String)`  
- `getId(): Long`  
- `setId(id: Long): void`  
- `getPedido(): Pedido`  
- `setPedido(pedido: Pedido): void`  
- `getFormaPagamento(): String`  
- `setFormaPagamento(forma: String): void`  
- `getValorPago(): BigDecimal`  
- `setValorPago(valor: BigDecimal): void`  
- `getDataHoraPagamento(): String`  
- `setDataHoraPagamento(dataHora: String): void`  
- `isValorPagoValido(): boolean`  

  - `isDataHoraValida(): boolean`  
- `obterOpcoesPagamento(): String[]`
 
