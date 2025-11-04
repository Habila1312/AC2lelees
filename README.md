# Projeto Alunos-Avaliacoes (Clean Architecture + DDD)

Conteúdo gerado automaticamente pelo assistente. Substitua valores sensíveis (Docker Hub credentials) antes de usar em produção.

## Como rodar local
1. mvn clean verify
2. mvn spring-boot:run
3. Acesse: http://localhost:8080/actuator/health (se exposto) e http://localhost:8080/h2-console

## Jenkins / Pipeline
- Jenkinsfile contém stages: Pre-Build, Build & Test, Quality Gate, Trigger Image_Docker.
- Jacoco está configurado para falhar o build em <70% de cobertura (INSTRUCTION).

## Docker
- Dockerfile e docker-compose para criar imagem e subir container.
- Para push no Docker Hub, faça: docker login; docker build -t USER/alunos-avaliacoes:latest .; docker push USER/alunos-avaliacoes:latest

Substitua USER pelas suas credenciais.
