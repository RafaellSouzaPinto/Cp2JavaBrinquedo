# Sistema de Cadastro de Brinquedos

# 🧑‍💻Integrantes do grupo: 
- Gustavo Monção / RM557515
- Rafael de Souza Pinto / RM555130

# 🖥️ Tecnologias utilizadas: 
- Java
- Orientação a Objetos (OOP)

# 🔍 Funcionalidades

O sitema permite:
- Cadastro de brinquedos com nome, faixa etária e preço;
- Listagem de todos os brinquedos cadastrados;
- Cálculo automático do valor total dos brinquedos;
- Validação simples de entrada;
- Exclusão de brinquedos por ID;

# 🗂️ Estrutura do projeto

Cp2JavaBrinquedo
  src/
    brinquedo/
      Brinquedo.java
      Principal.java
README.md

# `Brinquedo.java`
Classe responsável por representar um brinquedo, com atributos como:

- Nome;
- Faixa etária;
- Preço;

Inclui métodos para obter e modificar estes dados, além de validações.

# `Principal.java`
Classe principal que executa o programa. Utiliza um 'Scanner' para o usuário interagir e o mesmo permite cadastrar brinquedos rapidamente.

# 🔍 Exemplos de Requisições no Postman

- ▶️ POST
  - Descrição: Cadastra um novo brinquedo.
```json
{
  "nome": "Carrinho Hot Wheels",
  "faixaEtaria": "3+",
  "preco": 25.90
}
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Carrinho Hot Wheels",
  "faixaEtaria": "3+",
  "preco": 25.9
}
```
- ▶️ GET
  - Descrição: Lista todos os brinquedos cadastrados.

Resposta esperada:
```json
[
  {
    "id": 1,
    "nome": "Carrinho Hot Wheels",
    "faixaEtaria": "3+",
    "preco": 25.9
  },
  {
    "id": 2,
    "nome": "Boneca Barbie",
    "faixaEtaria": "5+",
    "preco": 89.99
  }
]
```
-  ▶️ DELETE
  - Descrição: Remove o brinquedo com o ID especificado.
```bash
DELETE /api/brinquedos/1
```

# Estrutura das Controllers
BrinquedoController.java
```java
@RestController
@RequestMapping("/api/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    @GetMapping
    public List<Brinquedo> listarTodos() {
        return service.listar();
    }

    @PostMapping
    public Brin(@RequestBody Brinquedo brinquedo) {
        return service.salvar(brinquedo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
```

# ▶️ Como executar o código? 
1. Clone o repositório:
   ```bash
   git clone https://github.com/RafaellSouzaPinto/Cp2JavaBrinquedo.git
2. Importe o projeto em uma IDE. (IntelliJ ou NetBeans)
3. Execute a classe principal para dar inicio ao programa.
