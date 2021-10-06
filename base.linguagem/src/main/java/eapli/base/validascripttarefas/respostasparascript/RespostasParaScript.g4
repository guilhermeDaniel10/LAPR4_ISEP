grammar RespostasParaScript;

inicio:	(comandos NEWLINE | comandos)* ;

comandos: script atributo;
script: SCRIPT;
atributo: email | identificador | quantidade | metodo_pagamento | plano_pagamento | nome | tipo_desconto | percentagem_desconto | fatura | valor_desconto | tipo_cliente;
email: EMAIL;
identificador: CLI | PROD;
quantidade: INTEIRO_QUANTIDADE;
metodo_pagamento: NUMERARIO | MB | CHEQUE;
plano_pagamento: PLANO_PAGAMENTO;
nome: NOME;
tipo_desconto: TIPO_DESCONTO;
percentagem_desconto: PERCENTAGEM_DESCONTO;
fatura: FATURA;
valor_desconto: VALOR_DESCONTO;
tipo_cliente: TIPO_CLIENTE;

SCRIPT: ('"'([0-9]+|[a-zA-Z]+|
'('|
')'|
'['|
']'|
'+'|
'*'|
'-'|
'\''|
'|'|
'\\'|
' '|
'/'|
'_'|
'%'|
'.')+'"');
FATURA: COUNTRY_CODE BANK AGENCY ACOUNT_NUMBER TWO_DIGITS;
CLI: 'Cli' INTEIRO_QUANTIDADE;
PROD: 'Prod' INTEIRO_QUANTIDADE;
EMAIL: ([a-zA-Z0-9]+'_'*)+'@'([a-zA-Z]+'.')+('com'|'pt');
INTEIRO_QUANTIDADE: [1-9][0-9]*;
INTEIRO: [0-9];
NUMERARIO: 'NUMERARIO'|'numerario';
PLANO_PAGAMENTO: 'PRONTO PAGAMENTO'|'pronto pagamento'|'PAGAMENTO A 30 DIAS'|'pagamento a 30 dias'|'PAGAMENTO ANUAL'|'pagamento anual';
MB: 'MULTIBANCO'|'multibanco'|'MB'|'mb';
CHEQUE: 'CHEQUE'|'cheque';
NOME: [A-Z][a-z]+' '[A-Z][a-z]+;
TIPO_DESCONTO: 'SAZONAL'|'sazonal'|'relampago'|'RELAMPAGO'|'QUANTIDADE'|'quantidade';
RECORRENCIA: 'SEMANAL'|'semanal'|'ANUAL'|'anual'|'MENSAL'|'mensal';
PERCENTAGEM_DESCONTO: [0-9]'%';
COUNTRY_CODE: [A-Z][A-Z][0-9][0-9];
TWO_DIGITS: [0-9][0-9];
BANK: [0-9][0-9][0-9][0-9];
AGENCY: [0-9][0-9][0-9][0-9];
ACOUNT_NUMBER: [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9];
VALOR_DESCONTO: [0-9]*'.'[0-9][0-9];
TIPO_CLIENTE: 'nacional'|'europeu'|'resto do mundo'|'NACIONAL'|'EUROPEU'|'RESTO DO MUNDO';
NEWLINE : [\r\n]+;
WS: (' ' | '\t')+ -> skip;
NL:  '\r'? '\n' -> skip;


