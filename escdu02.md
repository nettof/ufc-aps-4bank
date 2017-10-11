#### Introdução
A finalidade desse documento é definir as especificações suplementares, ou seja, requisitos de sistema que não são capturados imediatamente no caso de uso CDU02 – Realizar depósito.

#### Funcionalidade
1. Sistema deve contar com registro e tratamento de erros, onde se armazena os erros em arquivos log para consultas futuras do administrador.
2. Todo acesso será mediante autenticação com login e senha.
3. Sistema estará disponível para caixas MultiBank e também no próprio aplicativo.

#### Usabilidade
1. Interface de depósito deve ser convidativa, com estética e design minimalista.
2. Fornecer opções de ajuda para usuários iniciantes.
3. Fornecer orientações de procedimentos de depósito.
4. A prática do depósito deve ser de ordem lógica e natural.
5. Oferecer controle ao usuário, ou seja, permitir que o usuário possa desfazer ações.
6. Oferecer duas opções de depósito: no MultiBank ou no boleto.

#### Confiabilidade
1. O sistema deve estar disponível 24 horas por dia, 7 dias por semana.
2. O sistema será capaz de tratar erros e limitar o tempo de requisição para o depósito. 
3. Entregar corretamente as mensagens de um serviço a outro.
4. Sistema deve registrar a quantidade depositada, independentemente da quantidade digitada.

#### Manutenabilidade
1. Facilidade na identificação de falhas, como mensagens de exceção. 
2. Sistema precisa ser adequado a eventuais mudanças de ambiente operacional.
3. Sistema precisa suportar a testabilidade, ou seja, a facilidade de testar o software após alterações.

#### Restrições de Implementação
1. Software será desenvolvido em linguagem Java utilizando plataforma livre Eclipse;
2. Banco de dados MySQL;

#### Componentes comprados
1. Software de comunicação com o Sistemas MultiBank

#### Componentes livres
1. Hospedar em servidor Apache Tomcat

#### Regras de Negócio
1. A autenticação só pode ser realizada com o cartão e senha ou com o código enviado pelo celular.
2. A senha deve ter, no mínimo, seis caracteres, entre números e letras.
3. Cliente só pode depositar se o mesmo estiver com conta válida.
4. O cliente pode depositar somente no MultiBank ou posteriormente pagar um boleto gerado pelo sistema e quitá-lo em qualquer outro serviço de pagamento.
5. O depósito só pode ser feito usando cédulas do tipo real.
