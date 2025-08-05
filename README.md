[![Typing SVG](https://readme-typing-svg.demolab.com?font=Fira+Code&size=22&pause=1000&color=F30B99&width=435&lines=PADROES+DE+PROJETOS)](https://git.io/typing-svg)

# Desafio GFT Start#7
# Agendamento de Consultas Médicas

Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciar o agendamento de consultas médicas. Ele foi criado com foco em aplicar **padrões de projeto** na prática, seguindo boas práticas de arquitetura, organização e legibilidade.

Repositório oficial:  [github.com/LiviaMor/agendamento-consulta](https://github.com/LiviaMor/agendamento-consulta)



## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Lombok
- H2 Database (para testes locais)
- Maven


## Padrões de Projeto Aplicados

### ✅ Strategy Pattern
Utilizado para definir diferentes formas de agendamento:
- `AgendamentoPorEspecialidade`
- `AgendamentoPorProfissional`

Cada estratégia implementa a interface `AgendamentoStrategy` e é registrada como um `@Component` com nome específico. O serviço injeta todas as estratégias como `Map<String, AgendamentoStrategy>` e seleciona dinamicamente com base em um `enum`.

### ✅ Factory Method
Encapsula a criação de objetos `Consulta` com base no tipo:
- `ConsultaPresencialFactory`
- `ConsultaTelemedicinaFactory`

Evita lógica duplicada e centraliza a construção de objetos com `@Builder`.

### ✅ Enum para Tipos de Estratégia
O `enum TipoAgendamento` define os tipos disponíveis de agendamento, evitando o uso de strings soltas e garantindo segurança de tipo.

```java
public enum TipoAgendamento {
    ESPECIALIDADE("especialidade"),
    PROFISSIONAL("profissional");
}
```


###  Estrutura do Projeto

```java
src/
├── main/
│   ├── java/
│   │   └── com.scarlet.agendamento/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── enums/
│   │       ├── factory/
│   │       ├── repository/
│   │       ├── service/
│   │       ├── strategy/
│   │       └── dto/
│   └── resources/
│       └── application.properties
```
