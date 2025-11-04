AC2lelesss-upgraded
===================

Esta versão foi criada automaticamente para adicionar suporte a múltiplos ambientes (prod/staging/test),
Jenkinsfiles de CI, scripts do Maven wrapper e a estrutura de src do projeto completo (`ac2_ca-main`).

O *tema* base foi incluído a partir do projeto 'pratica4-master/gamificacao' em `src/main/resources/theme-from-pratica`.

Arquivos adicionados/alterados importantes:
- pom.xml (baseado no projeto completo, com artifactId mantido do projeto simples)
- .mvn/, mvnw, mvnw.cmd (copiados do projeto completo)
- docker-compose.prod.yml, docker-compose.staging.yml (copiados do projeto completo)
- Jenkinsfile.prod, Jenkinsfile.staging (copiados do projeto completo)
- src/ (copiado do projeto completo)
- src/main/resources/theme-from-pratica (arquivos de tema copiados de pratica4-master)

Por favor, revise e ajuste configurações específicas (ex.: application.properties, portas, credenciais) antes de rodar em produção.