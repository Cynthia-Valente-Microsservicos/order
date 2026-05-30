# Order

Módulo de contrato compartilhado para o serviço de pedidos. Funciona como uma **biblioteca de API**, definindo as interfaces Feign, DTOs de requisição e resposta que outros microsserviços utilizam para se comunicar com o `order-service`.

## Tecnologias

- Java 25
- Spring Boot 4.0.3
- Spring Cloud 2025.1.0 (OpenFeign)
- Lombok

## Estrutura

Este módulo **não é uma aplicação executável**. Ele é empacotado como dependência Maven e consumido por outros serviços.

```
store:order:1.0.0
```

## Feign Client

A interface `OrderController` define os endpoints expostos pelo `order-service`:

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/orders` | Cria um novo pedido |
| `GET` | `/orders` | Lista pedidos de uma conta (header `idAccount`) |
| `GET` | `/orders/{id}` | Busca detalhes de um pedido |
| `GET` | `/orders/health-check` | Health check do serviço |

## DTOs

### Requisição

**`OrderIn`**
```
items: List<OrderItemIn>
```

**`OrderItemIn`**
```
idProduct: String
quantity:  Integer
```

### Resposta

**`OrderOut`** — pedido completo
```
id:    String
date:  LocalDateTime
items: List<OrderItemOut>
total: Double
```

**`OrderSummaryOut`** — resumo para listagem
```
id:    String
date:  LocalDateTime
total: Double
```

**`OrderItemOut`** — item do pedido
```
id:       String
product:  OrderProductOut
quantity: Integer
total:    Double
```

**`OrderProductOut`** — referência ao produto
```
id: String
```

## Como usar

Adicione ao `pom.xml` do serviço consumidor:

```xml
<dependency>
    <groupId>store</groupId>
    <artifactId>order</artifactId>
    <version>1.0.0</version>
</dependency>
```

Instale no repositório local antes:

```bash
mvn install -DskipTests
```
