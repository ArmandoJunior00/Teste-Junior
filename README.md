# API de Usuários e Transações

# Instalação
Clonar Repositorio
git clone https://github.com/ArmandoJunior00/Teste-Junior.git

# Funcionalidades 
* **Cadastro de Usuários**: Criação de usuários com informações como nome, CPF e idade.
* **Gerenciamento de Contas Bancárias**: Cada usuário tem uma conta bancária com saldo e número de conta gerados automaticamente.
* **Transferências**: Realização de transferências entre contas bancárias, desde que o saldo da conta de origem seja suficiente.

# Tecnologias
* **Spring Boot**: Framework para criação de APIs RESTful.
* **JPA/Hibernate**: Para interação com o banco de dados.
* **Banco de Dados H2**: Banco de dados em memória (configurável para outros bancos como MySQL ou PostgreSQL).

# Endpoints da API
1. **Criar Usuário**
* **Método**: POST
* **URL**: /usuario
* **Descrição**: Cria um novo usuário.
* **Corpo da Requisição**:
```json
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "idade": 25
}



