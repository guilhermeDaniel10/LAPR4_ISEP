RCOMP 2020-2021 Project - Sprint D review
=========================================
### Sprint master: 1181743 ###

# 1. Diferenças entre o Sprint C e Sprint D #
Para o Sprint D destacam-se mudanças/melhoramentos feitos do Sprint C. Destacam-se então os seguimentes pontos:
    * Possibilidade de múltiplas instâncias do executor de atividades automáticas. a execução principal do programa será feita com duas instâncias a correr no SSH3 com portas diferentes, e outras duas a correr no SSH4, também com portas diferentes entre as duas;
    * Proteção recorrendo a certificados de chave pública (SSL) em todos as comunicações do Sistema;
    * Melhoramento da dashboard dos utilizadores- implementação da data limite e melhoramento no layout da dashboard caso não hajam tarefas;
    * A ligação TCP entre o lado do cliente do motor de fluxo de atividades e uma instância do executor de tarefas automáticas apenas é criada quando chega uma tarefa automática e é fechada mal acabe a execução da tarefa;
    * Implementação dos algoritmos de assignação de tarefas a colaboradores e de execução de tarefas automáticas;
    * Sincronização de todas as Threads do lado cliente do motor de fluxo de atividades utilizando semáforos, de modo a não existir a manipulação de tabelas concorrentemente da base de dados e/ou utilização do mesmo socket concorrentemente, ou seja, o socket única e exclusivamente abre para uma tarefa, fecha, e só volta a abrir para executar a outra nova tarefa;
    * Mudança das portas de execução nos SSH para os executores de atividades (32510 e 32511, sendo que as mesmas portas são repetidas no SSH2 e SSH3);
    * Melhoramento da organização do código, para melhor entendimento e possíveis atualizações futuras.

