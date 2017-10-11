+Escopo: Aplicativo 4Bank

+Nível: Objetivo do usuário

+Ator principal: Cliente do banco

+Interessados e interesses: 
- Cliente do banco: deseja fechar a conta de forma rápida, precisa e sem erros, e com o mínimo de esforço possível. 
- Banco: deseja registrar precisamente as operações de fechamento de conta e satisfazer os interesses do cliente. Deseja uma atualização 
rápida e precisa no sistema.

+Pré-condições: Cliente está devidamente autenticado e identificado pelo sistema. Cliente com pelo menos uma conta ativa.

+Garantia de Sucesso (ou Pós-condição): Comprovante de fechamento da conta

+Cenário de sucesso principal (ou Fluxo Básico): 
   1. Cliente entra no App.
   2. Cliente se autentica.
   3. Cliente vai na aba ferramentas, e escolhe a opção fechar conta.
   4. Sistema solicita ao usuário que confirme a operação.
   5. Cliente confirma a operação.
   6. Sistema verifica saldo.
   7. Sistema exibe uma mensagem ao usuário informando que o fechamento da conta foi concluído com sucesso.
   
+Extensões
	2. Erro de autenticação
	    1. Sistena avisa o erro e rejeita a entrada.
	    2. Sistema solicita a inserção dos dados novamente.
	6. Saldo diferente de zero.
		6.1 Saldo positivo
			1. Sistema solicita ao usuário que saque o dinheiro.
		6.2 Saldo negativo
			1. Sistema solicita ao usuário que deposite um valar que zere seu saldo.
