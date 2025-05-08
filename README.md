# 🎮 Sistema de Cadastro de Brinquedos

## 👥 Integrantes do Grupo
- Gustavo Monção – RM557515  
- Rafael de Souza Pinto – RM555130  

---

## 💻 Tecnologias Utilizadas
- Java  
- Programação Orientada a Objetos (POO)  
- Spring Boot (para API REST)  

---

## ✅ Funcionalidades
O sistema permite:
- ✅ Cadastro de brinquedos com nome, tipo, faixa etária, tamanho e preço  
- ✅ Listagem de todos os brinquedos cadastrados  
- ✅ Busca de brinquedos por ID e por tipo  

---

## 📁 Estrutura do Projeto

Cp2JavaBrinquedo/
│
├── src/
│ └── brinquedo/
│ ├── Brinquedo.java
│ └── Principal.java
│
├── BrinquedoController.java
├── BrinquedoRepository.java
├── Application.java
└── README.md

## 🧸 `Brinquedo.java`

Classe responsável por representar um brinquedo, contendo os seguintes atributos:

- `id` (gerado automaticamente)
- `nome`
- `tipo`
- `classificacao` (faixa etária)
- `tamanho`
- `preco`


## 📡 API REST - Exemplos de Requisições (Postman)

### ▶️ POST /brinquedos  
**Descrição:** Cadastra um novo brinquedo  
**Corpo da requisição:**
```json
{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "6+",
  "tamanho": "Médio",
  "preco": 149.90
}
```
Resposta esperada:
```json
{
    "id": 23,
    "nome": "Carrinho de Controle Remoto",
    "tipo": "Eletrônico",
    "classificacao": "6+",
    "tamanho": "Médio",
    "preco": 149.9
}
```
- ▶️ GET
  - Descrição: Lista todos os brinquedos cadastrados

Resposta esperada:
```json
[
  {
    "id": 1,
    "nome": "Carrinho Hot Wheels",
    "tipo": "Miniatura",
    "classificacao": "3+",
    "tamanho": "Pequeno",
    "preco": 25.9
  },
  {
    "id": 2,
    "nome": "Boneca Barbie",
    "tipo": "Boneca",
    "classificacao": "5+",
    "tamanho": "Médio",
    "preco": 89.99
  }
]
```
-  ▶️ Buscar por Id
  - Descrição: Busca o Id especifico.
```bash
GET http://localhost:8080/brinquedos/2
```
Resposta esperada:
```json
{
    "id": 2,
    "nome": "Boneca Barbie",
    "tipo": "Boneca",
    "classificacao": "5+",
    "tamanho": "Médio",
    "preco": 89.99
}
```
-  ▶️ Buscar por Tipo
  - Descrição: Busca por tipo
GET http://localhost:8080/brinquedos/tipo/Miniatura
Resposta esperada:
```json
[
    {
        "id": 24,
        "nome": "Carrinho Hot Wheels",
        "tipo": "Miniatura",
        "classificacao": "3+",
        "tamanho": "Pequeno",
        "preco": 25.9
    }
]
```

# Estrutura das Controllers
BrinquedoController.java
```java
@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @PostMapping
    public ResponseEntity<Brinquedo> criar(@RequestBody Brinquedo brinquedo) {
        return ResponseEntity.ok(repository.save(brinquedo));
    }

    @GetMapping
    public ResponseEntity<List<Brinquedo>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Brinquedo>> buscarPorTipo(@PathVariable String tipo) {
        List<Brinquedo> brinquedos = repository.findAll()
                .stream()
                .filter(brinquedo -> brinquedo.getTipo() != null && brinquedo.getTipo().equalsIgnoreCase(tipo))
                .toList();
        return ResponseEntity.ok(brinquedos);
    }

}

```

# ▶️ Como executar o código? 
1. Clone o repositório:
   ```bash
   git clone https://github.com/RafaellSouzaPinto/Cp2JavaBrinquedo.git
2. Importe o projeto em uma IDE. (IntelliJ ou NetBeans)
3. Execute a classe principal para dar inicio ao programa.
