# Projeto microsserviços  ifood com Quarkus
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Verificar se o pacote compilou todos os módulos
```shell script
mvn clean package -DskipTests
```

## Adicionar algumas extenções
- mvn quarkus:add-extension -Dextensions="jdbc-postgres, hibernate-orm-panache, resteasy-reactive-jackson, smallrye-openapi, hibernate-validator"
> **_OBS:_** O quarkus ao criar o projeto inicial ele ja vem com quarkus-resteasy-reactive. Para não tomar erro ao executar o projeto
pode retirar do comando acima o trecho resteasy-jsonb ou ir no pom e retirar o trecho de dependency do quarkus-resteasy-reactive.
> 
> ## Adicionar extenção JWT
- mvn quarkus:add-extension -Dextensions="jwt"
> **_OBS:_** Essa extenção deve ser adicionada para utilizar junto com o keycloak e dentro do path do projeto microsserviço especifico

# Acessar dev ui
- http://localhost:8080/q/dev/

## Para criar a imagem docker executa o comando
```shell script
docker-compose up
```

## Para iniciar o docker já com imagem criada executa o comando
```shell script
- docker-compose up -d
```

## Para executar o projeto executa o comando
```shell script
- mvn quarkus:dev
```

## Projeto no Git
https://github.com/viniciusfcf/udemy-quarkus