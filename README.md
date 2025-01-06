# API de Usuários e Transações

# Instalação
Clonar Repositório
```git
git clone https://github.com/ArmandoJunior00/Teste-Junior.git
```

# Funcionalidades 
* **Cadastro de Usuários**: Criação de usuários com informações como nome, CPF e idade.
* **Gerenciamento de Contas Bancárias**: Cada usuário tem uma conta bancária com saldo e número de conta gerados automaticamente.
* **Transferências**: Realização de transferências entre contas bancárias, desde que o saldo da conta de origem seja suficiente.

# Tecnologias
* **Spring Boot**: Framework para criação de APIs RESTful.
* **JPA/Hibernate**: Para interação com o banco de dados.
* **Banco de Dados H2**: Banco de dados em memória (configurável para outros bancos como MySQL ou PostgreSQL).

# Endpoints da API
**1. Criar Usuário**
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
```
* **Resposta**:
```json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "12345678900",
  "idade": 25,
  "numeroConta": "12345678",
  "saldo": 0.0
}
```

**2. Listar Usuários**
* **Método**: GET
* **URL**: /usuario
* **Descrição**: Retorna a lista de todos os usuários cadastrados.
* **Resposta**:
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "cpf": "12345678900",
    "idade": 25
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "cpf": "98765432100",
    "idade": 30
  }
]
```
3. Realizar Transferência
* **Método**: POST
* **URL**: /transferencias
* **Descrição**: Realiza uma transferência entre duas contas bancárias.
* **Corpo da Requisição**:

```json
{
  "contaOrigemId": 1,
  "contaDestinoId": 2,
  "valor": 150.00
}
```
* **Resposta de Sucesso**:

```json
{
  "id": 1,
  "contaOrigem": {
    "id": 1,
    "numeroConta": "123456",
    "titular": "João Silva",
    "saldo": 850.00
  },
  "contaDestino": {
    "id": 2,
    "numeroConta": "654321",
    "titular": "Maria Souza",
    "saldo": 1250.00
  },
  "valor": 150.00,
  "dataTransacao": "2025-01-04T10:30:00"
}
```
* **Resposta de Erro (Saldo Insuficiente)**:

```json
{
  "error": "Saldo insuficiente na conta de origem."
}
```

**4. Listar Transações**
* **Método**: GET
* **URL**: /transferencias
* **Descrição**: Retorna o histórico de todas as transações realizadas.
* **Resposta**:
```json
[
  {
    "id": 1,
    "contaOrigem": {
      "id": 1,
      "numeroConta": "123456",
      "titular": "João Silva",
      "saldo": 850.00
    },
    "contaDestino": {
      "id": 2,
      "numeroConta": "654321",
      "titular": "Maria Souza",
      "saldo": 1250.00
    },
    "valor": 150.00,
    "dataTransacao": "2025-01-04T10:30:00"
  }
]
```










