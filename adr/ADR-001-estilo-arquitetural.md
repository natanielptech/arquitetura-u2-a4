# ADR-001 — Estilo arquitetural para os exemplos

- **Status:** Aceito
- **Data:** 2026-10-28
- **Contexto:** Unidade 2 · Aula 4 — Prof. Nataniel Paiva

## Contexto

O projeto precisa comparar camadas, hexagonal e Clean Architecture implementando o mesmo caso de uso, “processar novo pedido”. Para que as diferenças de isolamento e dependência fiquem claras, o fluxo deve ser equivalente nos três módulos e testável sem banco real.

## Decisão

Os três estilos serão implementados em módulos Maven separados. A comparação inclui explicitamente o acoplamento JPA no serviço em camadas e as portas do núcleo em hexagonal e Clean. Para a composição de referência da aplicação didática, adotamos Clean Architecture: entidades e casos de uso Java puro, adaptadores externos para HTTP/persistência e configuração Spring externa.

## Consequências

- Cada estrutura pode ser executada e testada isoladamente via Maven.
- Testes usam adaptadores em memória; ArchUnit verifica que o núcleo hexagonal e as camadas internas Clean não importam Spring/JPA.
- A composição e conversão de dados na Clean exigem mais código que a solução em camadas.
- O H2 existe apenas para execução local; não é necessário para os testes de unidade.

## Alternativas consideradas

- **Camadas:** menor complexidade, mas permite vazamento da persistência para o negócio.
- **Hexagonal:** oferece forte isolamento por portas e adaptadores, com complexidade moderada.
- **Clean Architecture:** reforça as dependências sempre para dentro e serve como escolha de referência para este projeto comparativo.
