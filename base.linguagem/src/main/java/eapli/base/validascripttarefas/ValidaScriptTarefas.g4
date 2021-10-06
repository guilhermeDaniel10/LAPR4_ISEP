grammar ValidaScriptTarefas;

inicio:	(comandos NEWLINE | comandos)* ;

comandos: identificador | quantidade | metodo_pagamento | plano_pagamento | email | nome | tipo_desconto | recorrencia | percentagem_desconto | fatura | valor_desconto | data_limite | tipo_cliente;
email: EMAIL;
identificador: IDENTIFICADOR;
quantidade: QUANTIDADE;
metodo_pagamento: METODO_PAGAMENTO;
plano_pagamento: PLANO_PAGAMENTO;
nome: NOME;
tipo_desconto: TIPO_DESCONTO;
recorrencia: RECORRENCIA;
percentagem_desconto: PERCENTAGEM_DESCONTO;
fatura: FATURA;
valor_desconto: VALOR_DESCONTO;
data_limite: DATA_LIMITE;
tipo_cliente: TIPO_CLIENTE;

TIPO_CLIENTE: 'TIPO CLIENTE'|'tipo cliente';
DATA_LIMITE: 'DATA LIMITE'|'data limite'; 
VALOR_DESCONTO: 'VALOR DESCONTO'|'valor desconto';
FATURA: 'FATURA'|'fatura';
PERCENTAGEM_DESCONTO: 'percentagem desconto'| 'PERCENTAGEM DESCONTO';
RECORRENCIA: 'RECORRENCIA'|'recorrencia';
TIPO_DESCONTO: 'tipo desconto'|'TIPO DESCONTO';
NOME: 'nome'|'NOME';
IDENTIFICADOR: 'IDENTIFICADOR'|'identificador';
EMAIL: 'EMAIL'|'email';
QUANTIDADE: 'QUANTIDADE'|'quantidade';
PLANO_PAGAMENTO: 'PLANO PAGAMENTO'|'plano pagamento';
METODO_PAGAMENTO: 'METODO PAGAMENTO'|'metodo pagamento';
NEWLINE : [\r\n]+;
WS: (' ' | '\t')+ -> skip;
NL:  '\r'? '\n' -> skip;


