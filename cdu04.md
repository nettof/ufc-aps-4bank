+Escopo: Aplicativo 4Bank

+Nível: Objetivo do usuário

+Ator principal: Cliente do banco

+Interessados e interesses: 
- CLiente do banco: deseja realizar o pagamento de forma rápida, precisa e sem erros, e com o mínimo de esforço possível. Deseja a exibição, 
facilmente visível e compreensível, do status atual do seu saldo. Deseja um comprovante de pagamento para possíveis adversidades que eventualmente 
possam vir à ocorrer. 
- Banco: deseja registrar precisamente os pagamentos e satisfazer os interesses do cliente. Deseja proteção contra falhas para garantir a atualização de saldo após o pagamento. Deseja uma atualização rápida e precisa no sistema.
- Destinatário de transferência: espera uma atualização rápida e eficiente do seu saldo, sem erros ou transtornos.

+Pré-condições: Cliente está devidamente autenticado e identificado pelo sistema. O mesmo precisa ter saldo disponível, no mínimo o valor do pagamento.

+Garantia de Sucesso (ou Pós-condição): Atualização de saldo.

+Cenário de sucesso principal (ou Fluxo Básico): 
   1. Cliente entra no App.
   2. Cliente se autentica.
   3. Cliente vai a ferramenta de pagamento.
   4. Cliente escolhe um dos métodos de identificação da conta a ser paga.
   5. Cliente confirma o pagamento.
   6. Sistema registra e autoriza o pagamento segundo um conjunto de regras de pagamento.
   7. Sistema informa que a operação foi realizada com sucesso.
   8. Sistema atualiza o saldo.
   9. Sistema gera um comprovante de pagamento.
   10. Cliente encerra sua sessão e fecha o App. 
   
+Extensões (ou Fluxos Alternativos)
  1. MultiBank não reconhece o cartão (se for no cartão)
      1. Sistema envia uma mensagem de alerta para a equipe de monitoramento.
      2. É exibida uma mensagem de cartão não reconhecido.
  2. Erro de autenticação
      3.1 Se for no cartão
        1. Sistena avisa o erro e rejeita a entrada.
	    2. Sistema solicita a inserção novamente.
	  3.2 Se for no aplicativo
	    1. Sistena avisa o erro e rejeita a entrada.
	    2. Sistema solicita a inserção dos dados novamente.
  4a. Falha na identificação
     1. Sistema avisa que ocorreu um erro.
	 2. Sistema rejeita a entrada.
     3. Sistema solicita a identificação novamente.
  5. Cliente pede para cancelar o pagamento
     1. Sistema cancela o pagamento.
  5. Saldo é menor que o valor de pagamento	
     1. Sistema avisa que a operação não pode ser realizada e rejeita a entrada.
     2. Sistema solicita a alteração do valor.
  6. Sistema detecta falha na comunicação com o serviço externo 
     1. Sistema reinicia esse serviço e continua.
	   1.1 Sistema detecta que o serviço nao reinicia.
	      1. Sistema avisa o erro.
		  2. Sistema cancela pagamento;
  9. Falha na geração de comprovante de tranferência
     1. Sistema avisa o erro.
	 2. Sistema tenta novamente gerar o comprovante
	   1.1 Sistema detecta falha
	   1.2 Sistema sugere ao cliente consultar o histórico de conta.
