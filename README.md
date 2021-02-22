## Pré-Condição para execução do projeto
````
* Java 8 ou superior instalado;
* Intellij;
* Maven 3.6 ou superior instalado;
````
## Executando o  projeto
````
* Executando através do Intellij:
    **Importar o projeto na ide;
    **Selecionar o pacote Acceptance;
    **Run Tests in Acceptance;
    
* Executando  através do MAVEN:
    ** Realizar o clone do projeto e uma pasta desejada;
    ** Na raiz do projeto executar o comando: mvn clean test;
    
* Executando o projeto no Jenkins:
    ** Encontrasse na raiz, im modelo de JenkinsFile para execução do projeto;
    
````

## O Projeto:
````
* O projeto está dividido da seguinte forma:

*Pacote Acceptance:
    **Contém as classes para que as requisições sejam executadas, com suas determinadas assertivas conforme cenários Gherkin.
    
*Pacote Requests:
    **Contém as requisições que devem ser enviadas para api de desenvolvimento do Trello.    
    
*Pacote Config:
    **Contém os Enuns necessários, para passagem de parâmetros nas demais classes do projeto.    
    
* Executando o projeto no Jenkins:
    ** Encontrasse na raiz, im modelo de JenkinsFile para execução do projeto;
    
````

## Cenários de execução

````
* Os cenários pensados para execução da automação encontram-se no arquivo /documentation/Gherkin.md;  
````

## Planejamento realizado

````
* O planejamento aplicado ao projeto encontra-se no diretório: /documentation/images/MAPA.jpg;

* Segue um fluxo macro de aplicação dos testes integrados no ambiente DEVOPS da Sensedia, diretório: /documentation/images/Sensedia.jpg 
````

