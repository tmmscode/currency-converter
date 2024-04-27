<h1>Conversor de moedas</h1>

##  Sobre o projeto

Projeto feito em Java (JDK 21 "21.0.2"), que realiza conversões de valores entre moedas por meio de requisições em tempo real com o uso da API [ExchangeRateAPI](https://www.exchangerate-api.com/)

Este projeto foi desenvolvido durante a formação **"Oracle Next Education" (Especialização Back-End)**, em parceria com a **Alura**.

## Configuração e utilização

É necessário que você tenha uma chave de acesso para a API [ExchangeRateAPI](https://www.exchangerate-api.com/) (gratuita)

Deverá ser criado um arquivo "config.properties" no diretório abaixo:  
```
src/tmmscode/challengeCurrencyConverter/resources/config.properties  
```
A chave da API deve ser informada no campo:  
**"MY_API_KEY"**   

E um caminho existente para a exportação do arquivo de log das consultas realizadas, seja definido no campo:  
**"LOG_OUTPUT_DIRECTORY"**  

**Atenção: A aplicação não irá criar uma pasta, caso o diretório informado não exista.**


Exemplo das informações necessárias, estão no arquivo em:    
```
src/tmmscode/challengeCurrencyConverter/resources/config-example.properties  
```


---
A execução da aplicação se inicia pelo arquivo:  
``` 
src/tmmscode/challengeCurrencyConverter/main/Main.java
```
---
## Informações adicionais e Curiosidades

O desenvolvimento dessa aplicação me ajudou a entender melhor o funcionamento de algumas classes Java, como a "Properties" e "FileInputStream", que utilizei para fazer o mapeamento das informações externas da aplicação.  

Pude entender melhor sobre o funcionamento do recurso "try-with-resources", que facilita a utilização de instâncias que precisam ser fechadas ao término de um conjunto de instruções.  

E durante o desafio adicional de desenvolver uma solução para gerar logs das consultas realizadas, consegui entender um pouco mais sobre o funcionamento de atributos e métodos estáticos, que foram fundamentais para o acesso e manipulação de objetos entre diferentes pacotes.

---

## Ajustes futuros

Pretendo trocar o formato do atributo "requestedAt" da classe "LogRegistry.java":  
Alterando o formato "String" pra "Instant" (java.time.Instant), mas pra isso, eu tenho que implementar meu próprio TypeAdapter e adicionar como parâmetro ao instanciar o objeto "gson" em:  
```
src/tmmscode/challengeCurrencyConverter/api/ExchangeRateService.java  
```
para que seja feita a conversão do objeto para JSON de forma correta, na criação do arquivo de log.  

---
Criado por: [Thiago de Melo Marçal da Silva](https://github.com/tmmscode)
