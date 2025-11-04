# Instruções CI (Jenkins) - AC2 Upgrade

Arquivos de pipeline incluídos neste repositório:
- `Jenkinsfile` - Pipeline DEV (build + tests + coverage gate -> trigger Image_Docker)
- `Jenkinsfile.imagedocker` - Pipeline Image_Docker (build docker image, push to Docker Hub -> trigger Pipeline_Staging)
- `Jenkinsfile.staging` - Pipeline Staging (pull image, up, health check)
- `Jenkinsfile.prod` - (copiado do projeto completo) para uso em Prod (ajustar conforme infra)

## Credenciais necessárias no Jenkins (configure em **Credentials**)
- `docker-hub-credentials` - username/password for Docker Hub
- (Opcional) `git-credentials` - se usar repositórios privados

## Jobs sugeridos no Jenkins
- `DEV` -> multibranch pipeline / pipeline definido pelo `Jenkinsfile` neste repo
- `Image_Docker` -> pipeline apontando para `Jenkinsfile.imagedocker`
- `Pipeline_Staging` -> pipeline apontando para `Jenkinsfile.staging`
- `Pipeline_Prod` -> pipeline apontando para `Jenkinsfile.prod`

## Observações importantes
- O `pom.xml` foi modificado para incluir `jacoco-maven-plugin` (com regra de cobertura 70%), `maven-surefire-plugin` e `maven-pmd-plugin`.
- O gate de cobertura é executado durante `mvn verify`. Se a cobertura for menor que 70% o `mvn verify` falhará e o pipeline DEV não acionará o job `Image_Docker`.
- Ajuste as URLs de health-check e portas conforme a configuração da sua aplicação (ex.: `application.properties`).
- Você deve configurar as credenciais no Jenkins e, caso use agentes Windows, ajustar os comandos `sh` para `bat`.