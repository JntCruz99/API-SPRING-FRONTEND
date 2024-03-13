# Documentação da API AuthController

Esta API oferece endpoints para autenticação de usuários e geração de tokens de acesso.

## Endpoints

### Login

####POST /login


Este endpoint permite que um usuário faça login e receba um token de acesso.

#### Requisição

A requisição deve ser feita no formato JSON com os seguintes campos:

- `login`: O nome de usuário do usuário.
- `password`: A senha do usuário.

Exemplo de corpo da requisição:

```json
{
    "login": "exemplo_usuario",
    "password": "exemplo_senha"
}
````
Resposta
Se as credenciais estiverem corretas, o endpoint retornará um token de acesso.

###Exemplo de resposta:
```json
{
    "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJleGFtcGxlX3VzdWFyaW8iLCJpYXQiOjE2MTY5MzYwNjAsImV4cCI6MTYxNjkzNzg2MH0.5jSvPdRzqN-05tN8zBNutXJZtq30lJi-VX_RhDX_Tx0"
}
````
###Exemplo de Uso
curl -X POST http://localhost:8080/login \
    -H "Content-Type: application/json" \
    -d '{"login": "exemplo_usuario", "password": "exemplo_senha"}'
