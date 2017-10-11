#### Introdução
A finalidade desse documento é definir as especificações suplementares, ou seja, requisitos de sistema que não são capturados imediatamente no caso de uso CDU03 – Realizar transferência.

#### Funcionalidade
1. Sistema deve contar com registro e tratamento de erros, onde se armazena os erros em arquivos log para consultas futuras do administrador.
2. Todo acesso será mediante autenticação com login e senha.
3. Sistema estará disponível para caixas MultiBank e também no próprio aplicativo.

#### Usabilidade
1. Interface de transferência deve ser convidativa, com estética e design minimalista.
2. Fornecer opções de ajuda para usuários iniciantes.
3. Fornecer orientações de procedimentos de depósito.
4. A prática da transferência deve ser de ordem lógica e natural.
5. Oferecer controle ao usuário, ou seja, permitir que o usuário possa desfazer ações.
6. Detectar facilmente bancos através somente do número da Agência. 

#### Confiabilidade
1. O sistema deve estar disponível 24 horas por dia, 7 dias por semana.
2. O sistema será capaz de tratar erros e limitar o tempo de requisição para o depósito. 
3. Entregar corretamente as mensagens de um serviço a outro.
4. Se ocorrer um erro de transação, o sistema impede a transação e não altera o saldo do cliente emissor.

#### Manutenabilidade
1. Facilidade na identificação de falhas, como mensagens de exceção. 
2. Sistema precisa ser adequado a eventuais mudanças de ambiente operacional.
3. Sistema precisa suportar a testabilidade, ou seja, a facilidade de testar o software após alterações.

#### Restrições de Implementação
1. Software será desenvolvido em linguagem Java utilizando plataforma livre Eclipse;
2. Banco de dados MySQL;

#### Componentes comprados
1. Software de comunicação com o Sistemas MultiBank
2. Software de comunicação com outros bancos.

#### Componentes livres
1. Hospedar em servidor Apache Tomcat

#### Regras de Negócio
1. A autenticação só pode ser realizada com o cartão e senha ou com o código enviado pelo celular.
2. A senha deve ter, no mínimo, seis caracteres, entre números e letras.
3. Cliente só pode transferir dinheiro se o mesmo estiver com conta válida.
4. Cliente só pode transferir se o valor de transferência for menor ou igual a seu saldo.
5. O cliente pode realizar a transferência de duas maneiras: no MultiBank ou pelo Aplicativo 4Bank.
6. A conta destinatária deve existir e seu status deve ser ativo.
7. O cliente emissor deve obrigatoriamente informar a agência e conta destinatária.
8. O valor mínimo de transferência deve ser acima de 5 reais.  