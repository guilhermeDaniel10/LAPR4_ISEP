grammar ValidateFormulario;

inicio:	(expr NEWLINE)* ;

expr: expr valida NEWLINE | valida;
valida: posicao tipoDado obrigatoriedade dependencia expressaoRegular resposta;
tipoDado: ('numero'|'NUMERO') | ('texto'|'TEXTO') | ('DATA'|'data') | ('FICHEIRO'|'ficheiro') | ('BOOLEAN'|'boolean');
obrigatoriedade: ('NF'|'F');
posicao: INTEIRO;
dependencia: INTEIRO_NULO;
expressaoRegular: ANYCHAR;
resposta: INTEIRO_NULO | INTEIRO | ANYCHAR;

NEWLINE : [\r\n]+;
INTEIRO: [1-9]+[0-9]*;
INTEIRO_NULO: [0-9]; 
ANYCHAR: ('"'([0-9]+|[a-zA-Z]+|'('|')'|'['|']'|'+'|'*'|'-'|' ')+'"');
WS: (' ' | '\t')+ -> skip;
NL:  '\r'? '\n' -> skip;