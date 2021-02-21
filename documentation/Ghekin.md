
## Cenários referentes ao Requisito de criação do board do Trello

```
Cenário cadastrar um novo board
GIVEN Tenha um app Key
AND um Token
WHEN Informar o nome do board
THEN o board deve ser cadastrado
AND a api deve retornar StatusCode 200

Cenário Atualizar o board cadastrado
GIVEN Tenha um board cadastrado
AND Tenha um app Key
AND um Token
WHEN Informar um novo nome
THEN O board deve ser deletado
AND retornar o statusCode 200

Cenário Deletar o board cadastrado
GIVEN Tenha um board cadastrado
AND Tenha um app Key
AND um Token
WHEN Informar o ID do board
THEN O board deve ser deletado
AND retornar o statusCode 200

Cenário Consultar o board cadastrado
GIVEN Tenha um boad cadastrado
AND Tenha um app Key
AND um Token
WHEN Informar o ID do board
THEN O board deve ser exibido
AND retornar o statusCode 200

Cenário Consultar cards do board
GIVEN Tenha um boad cadastrado
AND Tenha um app Key
AND um Token
WHEN Informar o ID do board
THEN Deve retornar os cards cadastrados para o board
AND retornar o statusCode 200

Cenário Excluir um board inexistente
GIVEN tenha um ID do board inexistente
AND Tenha um app Key
AND um Token
WHEN Informar um ID inexistente
THEN retornar o statusCode 404

Cenário Consultar um board inexistente
GIVEN tenha um ID do board inexistente
AND Tenha um app Key
AND um Token
WHEN Informar um ID inexistente
THEN retornar o statusCode 404

Cenário Atualizar um board inexistente
GIVEN tenha um ID do board inexistente
AND Tenha um app Key
AND um Token
WHEN Informar um ID inexistente
THEN retornar o statusCode 404

Cenário Atualizar um board sem a apiKey
GIVEN Tenha um board cadastrado
AND um Token
WHEN Informar um nome
THEN retornar o statusCode 401


Cenário Cadastrar um board sem a apiKey
GIVEN Tenha um token válido
WHEN Informar um nome
THEN retornar o statusCode 401
````

## Cenários referentes ao Requisito de criação do Card do Trello
```
Cenário cadastrar um novo card
GIVEN Tenha um board já cadastrado
AND tenha um Token
AND tenha um Key
WHEN Informar o nome do card
AND Informar o id da lista
THEN o card deve ser cadastrado
AND a api deve retornar StatusCode 200

Cenário Atualizar card cadastrado
GIVEN Tenha um card já cadastrado
AND tenha um Token
AND tenha um Key
WHEN Informar o nome do card
AND Informar o id da lista
THEN o card deve ser atualizado
AND a api deve retornar StatusCode 200

Cenário Deletar card cadastrado
GIVEN Tenha um card já cadastrado
AND tenha um Token
AND tenha um Key
WHEN Informar o id do card
THEN o card deve ser deletado
AND a api deve retornar StatusCode 200

Cenário Consultar um card cadastrado
GIVEN Tenha um card já cadastrado
AND tenha um Token
AND tenha um Key
WHEN Informar o id do card
THEN o card deve ser exibido
AND a api deve retornar StatusCode 200

Cenário Consultar um card inválido
GIVEN Tenha um card id invalido
AND tenha um Token
AND tenha um Key
WHEN Informar o id do card inválido
THEN AND a api deve retornar StatusCode 404

Cenário Deletar um card inválido
GIVEN Tenha um card id invalido
AND tenha um Token
AND tenha um Key
WHEN Informar o id do card inválido
THEN AND a api deve retornar StatusCode 404

Cenário Atualizar um card inválido
GIVEN Tenha um card id invalido
AND tenha um Token
AND tenha um Key
WHEN Informar o id do card inválido
THEN AND a api deve retornar StatusCode 404

Cenário Atualizar um card sem a apiKey
GIVEN Tenha um board cadastrado
AND um Token
WHEN Informar um nome
THEN retornar o statusCode 401


Cenário Cadastrar um card sem a apiKey
GIVEN Tenha um token válido
WHEN Informar um nome
THEN retornar o statusCode 401

Cenário Deletar todos os dados inseridos nos testes um card sem a apiKey
GIVEN Tenha um token válido
AND Tenha uma Key
WHEN Informar o ID do board
AND executar a operação de delete Board
THEN retornar o statusCode 200
````