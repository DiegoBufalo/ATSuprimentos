<h1>Comando para subir uma imagem postgres (Docker):</h1>

docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 -d postgres

<h1>Para 'buildar' entre na pasta raiz do micro servico e digite:</h1>

mvn clean package install -DskipTests

obs: maven previamente instalado na maquina

<h1>Para rodar entre na pasta target e digite:</h1>

java -jar *NOME DO JAR GERADO*.jar

<h1>Para testar no insomnia importar o json abaixo para dentro do app:</h1>

Importar para dentro o Insomnia o arquivo TesteInsomnia.json, ele ira criar todos os endpoints para teste da aplicacao.

