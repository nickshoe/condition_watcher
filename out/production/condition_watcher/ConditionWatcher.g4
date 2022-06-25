grammar ConditionWatcher;

watch: (condition_expression NEWLINE)*;

/* https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=RSQL_PREDICATES */
condition_expression
                    // A condition expression can consist of one or more predicates.
                    // You can link multiple predicates together with the AND and OR logical operators.
                    : condition_expression logical_operator=('AND'|'OR') condition_expression
                    // You can invert the sense of a predicate by placing the NOT unary operator before the predicate.
                    // The NOT unary operator only affects the predicate that immediately follows it. 
                    | 'NOT' condition_expression
                    // You can use parentheses to group predicates. 
                    // You can place a NOT unary operator before the opening parentheses to invert the sense of a group of predicates. 
                    | '(' condition_expression ')'
                    // A predicate is the simplest version of a condition expression
                    | predicate;

// A predicate is a condition expression that evaluates to a boolean value, either true or false.
// [A predicate is] a term of a statement, where the statement may be true or false depending on whether the thing referred to by the values of the statement's variables has the property signified by that (predicative) term.
predicate: variable comparison_operator=('='|'!=') value;

variable: ID (DOT ID)*;
value: STRING_LITERAL;

ID: ALPHA (ALPHA | DIGIT)*;

STRING_LITERAL: UNTERMINATED_STRING_LITERAL '"';
UNTERMINATED_STRING_LITERAL: '"' (~["\\\r\n] | '\\' (. | EOF))*;

DOT: '.';
NEWLINE: [\r\n]+;
ALPHA: [a-zA-Z_];
DIGIT: [0-9];

WS: [ \n\t\r]+ -> skip;