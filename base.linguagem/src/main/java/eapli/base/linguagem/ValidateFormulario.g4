grammar ValidateFormulario;

inicio:	(expr NEWLINE | expr)* ;

expr: expr valida NEWLINE | valida;
valida: posicao tipoDado obrigatoriedade dependencia expressaoRegular resposta;
tipoDado: ('numerico'|'NUMERICO') | ('texto'|'TEXTO') | ('DATA'|'data') | ('FICHEIRO'|'ficheiro') | ('BOOLEANO'|'booleano');
obrigatoriedade: ('NF'|'F');
posicao: INTEIRO;
dependencia: INTEIRO_NULO | INTEIRO;
expressaoRegular: ANYCHAR;
resposta: INTEIRO_NULO | INTEIRO | ANYCHAR;

NEWLINE : [\r\n]+;
INTEIRO: [1-9]+[0-9]*;
INTEIRO_NULO: '0';
ANYCHAR: ('"'([0-9]+|[a-zA-Z]+|
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
WS: (' ' | '\t')+ -> skip;
NL:  '\r'? '\n' -> skip;