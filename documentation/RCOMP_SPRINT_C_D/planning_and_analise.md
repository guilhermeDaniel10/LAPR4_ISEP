RCOMP 2020-2021 Project - Sprint C e D planning/análise
===========================================
### Sprint master: 1181743 ###

No âmbito do projeto LAPR4, escolheu-se juntar o planning das User Stories relativas a RCOMP num só planning, sendo que grande parte das Users Stories do Sprint D, são complementares ao Sprint C.

## User Stories- Sprint C

Nota: o planeamento mais detalhado de cada caso de uso encontra-se no seu respetivo diretório.

* **US-3011**- Como utilizador, eu pretendo que após me autenticar me seja apresentado o meu dashboard web e que este se mantenha atualizado (automaticamente).
  * No âmbito deste caso de uso, foi necessário usar o motor de fluxo de atividades em modo servidor, para comunicar com a base de dados e enviar para o portal de utilizadores, toda a informação relativa à página HTML do utilizador em questão. 
  * Para a implementação do caso de uso, recorrendo ao protocolo TCP, obedencendo às regras estabelicidas no protocolo SPD 2021, estabelecemos comunicação entre o Servidor e o Cliente. 
  * No Sprint C, a ligação estaria a ser feita através de um Socket normal, que iria transmitir mensagens com o servidor, que estaria a aceitar mensagens recorredo a um ServerSocket.
  (Feito por todos os elementos)


* **US-4001**- Como Gestor de Projeto, eu pretendo que seja desenvolvido no Motor de Fluxo de Atividade o mecanismo de gestão/controlo/avanço do fluxo de atividades de um dado pedido.
  * A implementação do caso de uso foi sendo feita ao longo da implementação dos restantes, sendo que se trata de uma US mais generalista.
  (Feito por todos os elementos)

* **US-4002**- Como Gestor de Projeto, eu pretendo que o Motor de Fluxo de Atividades disponibilize, a pedido, os dados necessários às aplicações "Serviços e RH" e "Portal dos Utilizadores".
  * Para a implementação do caso de uso, foram usadas queries de obtenção da informação necessária a cada um dos intervinientes. 
  * Utilizou-se um mecanismo de Threads para que fosse possível fazer com que o motor de fluxo de atividades conseguisse estabelecer comunicação com as diferentes aplicações, assim como com a base de dados. 
  (Feito por todos os elementos)

* **US-5001**- Como Gestor de Projeto, eu pretendo que seja desenvolvido o Executor de Tarefas Automáticas.
  * No âmbito do Sprint C, era apenas necessário que o executor de tarefas automáticas estivesse em modo servidor (ServerSocket), à espera de uma mensagem para execução de uma tarefa automática. 
  * A obtenção das tarefas automáticas está a ser feita no motor de fluxo de atividades (lado do cliente), e sempre que uma for encontrada, irá ser estabelida uma ligação TCP, com o respetivo código e tarefa.
  * A execução da tarefa automática (no Sprint C), seria apenas simulada.
  * As múltiplas instâncias de executores de atividades ainda não era suportada no Sprint C.
  (Feito por todos os elementos)

* **US-2011**- Como GSH, eu pretendo conhecer o estado atual do motor de fluxos de atividades e que este se mantenha atualizado (automaticamente).
  * Semelhante ao caso de uso da dashboard do utilizador.
  * O motor de fluxo de atividades (Servidor), estará constantemente à espera de mensagens do cliente (Executor de atividades), e com a receção das mensagens, serão feitas queries de obtenção de serviços/tarefas a ser executados no motor de fluxo de atividades.
  * A informação do motor será enviada para o cliente (página HTML completa), que irá gerar a página
  (Feito por Guilherme Daniel)


## User Stories- Sprint D
* No Sprint D, será implementada a possibilidade de existirem várias instâncias do executor de atividades automáticas a correrem em simultâneo, em servidores diferentes. Podendo estes serem executados em modo servidor, ou localmente (principalmente para testagem- localhost).

* Será feita uma alteração na página HTML da Dashboard do utilizador (data limite de uma tarefa).

* Existirão melhorias relativamente ao tratamento de exceções/erros que possam existir aquando do estabelecimento de ligação entre servidor e cliente, fazendo com que a execução do programa não seja totalmente comprometida face a um ligeiro erro de runtime.
  

* **US-5003**- Como Gestor de Projeto, eu pretendo que a equipa conclua o desenvolvimento do Executor de Tarefas Automáticas tornando-o bastante robusto.
  * O caso de uso trata-se da continuação do caso de uso 5001 do sprint passado, e neste caso, já era necessária a execução completa de tarefas automáticas. 
  * Como referido anteriormente, será implementada a possibilidade de execução em diferentes instâncias do executor de atividades (vários servidores).
  
* Casos de uso com SSL/TLS
  * A implementação dos casos de uso de SSL/TLS foi praticamente igual em todos, existindo ligeiras mudanças entre servidor e cliente
  * Inicialmente, seria necessário gerar os certificados de chave pública, para servidores e cliente (make_certs).
  * Recorrendo TrustStore do java, será necessário fazer a validação das chaves, com a respetiva identificação e password definidas aquando da sua criação.
   #### Servidores
  * Todas os ServerSockets passarão a ser SSLServerSockets, de modo a permitir que haja a possibilidade de definir a obrigatoriedade de autenticação a cada cliente que tentar estabelecer ligação com os servidores (i.e envio de mensagens).
  * Para instânciar uma SSLServerSocket, apenas será necessário definir a porta, assim como a necessidade de aprovação por parte dos clientes. 

  #### Clientes
  * Todos os Sockets passam a ser SSLSockets, que mais uma vez, recorrendo à TrustStore do java, irão ter que estar identificados como um possível cliente (gerado aquando da criação dos certificados), com uma password. Este cliente terá que ser verificado, sendo que poderá não ter permissões de estabelecer ligação com o servidor. 
  * Sempre que uma ligação com o servidor tente ser estabelecida, recorrendo ao X509Certificate, é impresso o certificado e a respetivo sucesso/insucesso da ligação.
  * Para estabelecer a ligação correta entre um servidor/cliente, é necessário que haja um Handshake, comprovando a ligação entre os mesmos.  


  




