+Escopo: Aplicativo 4Bank

+Nível: Objetivo do usuário

+Ator principal: Cliente do banco 

+Interessados e interesses: 
 - CLiente do banco: deseja realizar o saque de forma rápida, precisa e sem erros, e com o mínimo de esforço possível. Deseja a exibição, facilmente visível e compreensível, do status atual do seu saldo. Deseja um comprovante de saque para possíveis adversidades que eventualmente possam vir à ocorrer. 
 - Banco: deseja registrar precisamente os saques e satisfazer os interesses do cliente. Deseja proteção contra falhas para garantir a atualização de saldo após o saque. Deseja uma atualização rápida e precisa no sistema.

+Pré-condições: Cliente está devidamente autenticado e identificado pelo sistema. O mesmo precisa ter saldo disponível.

+Garantia de Sucesso (ou Pós-condição): Atualização de saldo. Cliente com o dinheiro sacado em mãos. 

+Cenário de sucesso principal (ou Fluxo Básico): 
  1. Cliente chega ao MultiBank 24 Horas com o cartão ou dispositivo com o aplicativo.
  2. Cliente insere o cartão no MultiBank ou entra no aplicativo.
  3. Cliente se autentica. 
  4. Cliente entra com o valor de saque.
  5. Cliente recebe um código do Sistema enviado pelo MultiBank(se for no aplicativo)
  6. Cliente entra com o código (se for no aplicativo)
  7. Sistema registra e autoriza o saque segundo um conjunto de regras de saque.
  8. Cliente retira o dinheiro.
  9. Sistema informa que a operação foi realizada com sucesso.
  10. Sistema atualiza o saldo.
  11. Sistema emite comprovante de saque.
  12. Cliente encerra sua sessão no aplicativo ou retira o cartão.
  13. Cliente vai embora com comprovante e dinheiro (se o saque ocorreu). 

+Extensões (ou Fluxos Alternativos)
  2. MultiBank não reconhece o cartão (se for no cartão)
      1. Sistema envia uma mensagem de alerta para a equipe de monitoramento.
      2. É exibida uma mensagem de cartão não reconhecido.
	  2. Solicita a inserção do cartão novamente.
  3. Erro de autenticação
      3.1 Se for no cartão
        1. Sistena avisa o erro e rejeita a entrada.
	    2. Sistema solicita a inserção novamente.
	  3.2 Se for no aplicativo
	    1. Sistena avisa o erro e rejeita a entrada.
	    2. Sistema solicita a inserção dos dados novamente.
  4. Valor de entrada do saque é maior que o saldo	
     1. Sistema avisa que a operação não pode ser realizada.
     2. Sistema solicita a alteração do valor.
  4a. Cliente pede para cancelar o saque
     1. Sistema cancela saque
  5. Sistema detecta falha na comunicação com o serviço externo do MultiBank
     1. Sistema reinicia esse serviço e continua.
	   1.1 Sistema detecta que o serviço nao reinicia.
	      1. Sistema avisa o erro.
		   2. Sistema informa a opçao de sacar com o cartão ou finaliza chamada. 
  6. Código inválido (não encontrado no sistema)
     1. Sistema avisa o erro e rejeita a entrada.
     2. Cliente responde ao erro
        2.1. Existe outra maneira de entrada
          1. Cliente insere o cartão no MultiBank
            1.1 Cartão inválido: sistema avisa erro.		
  11. Ferramenta de impressao do MultiBank não tem papel ou tinta
     1. Se o sistema detecta a falha, avisará sobre o problema.
	 2. Funcionario do MultiBank repõe papel ou tinta.
	 3. Cliente solicita outro recibo.