# Análise OO #

## Racional para identificação de classes de domínio ##

### _Lista de Categorias_ ###

**Transações (do negócio)**
---

**Linhas de transações**
---

**Produtos ou serviços relacionados com transações**
---

**Registos (de transações)**
---

**Papéis das pessoas**

* Administrativo
* Colaborador
* Utilizador
* Gestor Helpdesk
* Responsável Recursos Humanos
---

**Lugares**

* Residencia
---

**Eventos**

* Solicitação de Serviço
* Aprovação de Serviço
* Formulario Tarefa
---

**Objectos físicos**

---

**Especificações e descrições**

* Serviço
* Pedido
* Tarefa
---

**Catálogos**

* Cotações e Descontos
* A. Pedidos aos Recursos Humanos
* A.1 -> Alteração Dados Pessoais
* A.2 -> Férias e Justificações
* Reportar anomalia em equipamento
---

**Conjuntos**

* Dashboard
* SLA
* Catalogo
* HistoricoPedido
* TarefaDisponivel
* ResolucaoAtividade
---

**Elementos de Conjuntos**

* Tarefa
* NivelCriticidade
* Servico
* Pedidos
* TarefaDisponivel
* FluxoAtividade
---


**Organizações**

* Organização
---

**Outros sistemas (externos)**

* Base de dados H2
---

**Registos (financeiros), de trabalho, contractos, documentos legais**
---

**Instrumentos financeiros**
---

**Documentos referidos/para executar as tarefas/**
---

**Racional sobre identificação de associações entre classes**

| Conceito (A) 		|  Associação   		|  Conceito (B) |
|----------	   		|:-------------:		|------:        |
|  Colaborador    |  trabalha para    | Organizacao   |
|   					    |  possui           | EnderecoEmail |
|   				    	|  contém           | Contacto      |
|                 |  habita           | Residencia    |
|   					    |  desempenha       | Funcao        |
|   				    	|  supervisiona     | Colaborador   |
|   				    	|  chefia           | Equipa        |
|                 |  pertence         | Equipa        |
|   					    |  é um             | Utilizador    |
|   				    	|  é um             | GestorHelpdesk |
|   				    	|  reivindica       | TarefasDisponiveis |
|                 |  dá               | Feedback      |
|   					    |  reflete sobre    | Dashboard     |
|   				    	|  referenciado     | Pedido        |
|   				    	|  verifica         | HistoricoPedidos |
|                 |  preenche         | Formulario    |
|   					    |  acede            | Catalogo      |
| Equipa  				|  pertence         | TipoEquipa    |
| Cor         		|  distingue        | TipoEquipa    |
|                 |  indica gravidade | NivelCriticidade |
| Administrador  	|  administra       | Utilizador    |
| Utilizador  		|  acede            | Password      |
|   				    	|  autenticado      | EnderecoEmail |
| Contacto        |  é um             | Telefone      |
|   					    |  é um             | Telemovel     |
| Organizacao  		|  rege-se por      | SLA           |
| SLA  				    |  possui           | NivelCriticidade |
| NivelCriticidade |  detém           | Objetivo      |
| Catalogo  			| simbolizado       | Icone         |
|   				    	| cumpre            | SLA           |
|                 | engloba           | Servico       |
| GestorHelpdesk  | gere              | Catalogo      |
|   					    | preenche          | Formulario    |
| Formulario      | tem               | Atributo      |
| Servico  				| referente         | Formulario    |
|   				    	| regista           | FluxoAtividade |
|   				    	| simbolizado por   | Icone         |
|                 | cumpre            | NivelCriticidade |
| Dashboard   		| agrupa            | Tarefa        |
| HistoricoPedido | armazena          | Pedido        |
| TarefaDisponivel | agrupa           | Tarefa        |
| Tarefa          | rebece            | Feedback      |
|   					    | rege-se por       | EstadoTarefa  |
|   				    	| verifica resolução | ResolucaoAtividade |
| EscalaSatisfacao | classifica       | Feedback      |
| Pedido          | referente         | Servico       |
|   					    | classificado      | Urgencia      |
|   				    	| rege-se por       | EstadoPedido  |
|   				    	| resulta           | Tarefa        |
| Keyword         | identifica        | Servico       |
| FluxoAtividade  | regista           | ResolucaoAtividade |
|   				    	|                   |               |

## Modelo de Domínio

![ModeloDominio](ModeloDominio.png)
