# criptografia-rsa
### Exemplo contendo a base da criptografia RSA. 

### Aluno/Desenvolvedor: Rodrigo Bento Rodrigues.

## Introdução

Projeto proposto pelo professor Saymon Bezerra, na disciplina de Segurança de Dados - IFPB. A idéia foi de desenvolver um algoritmo que seja possivel criptografar e descriptografar uma palavra através das chaves (pública e privada) e que seja possível visualizar as variavéis necessárias para esse trabalho, que são: (N, P, Q, Z, E, D).

## Descrição da Aplicação

A aplicação conta com uma interface SWING Java, contendo 4 telas.

1 (Inicial) -> Contém uma descrição sobre a criptografia RSA e sobre o que a aplicação faz/realiza.

2 (Menu) -> Tela contendo uma bifurcação, apontando para qual tipo de criptografia você desejar utilizar. Uma criada "na mão" e outra criada a partir das ferramentas disponibilizadas pelo Java.

3 (RSD - Com Variaveis) -> Ao clique no botão de gerar chaves, é criado e mostrado na tela todas as variáveis necessárias para a criptografia e descriptografia.

4 (RSD - Java) -> A lógica foi construida utilizando os pacotes (java.security) e (javax.crypto), a idéia é gerar as chaves e salva-las na aplicação, requisitando-as quando necessário.

## Executando a aplicação

- Para rodar a aplicação em sua máquina é necessário fazer o download ou clone

- Executar em sua IDE de preferencia

- Através de linha de comando, pelos seguintes passos:

  - Compilando: mvn clean install
  - Entrando na pasta que contem o jar: cd target/  
  - Executando: java -jar Criptografia-1.jar

- Executando o sh disponivel: run.sh

### Codigo comentado e contendo passos intuitivos.


