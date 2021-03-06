--Escreva uma função hasEqHeads :: [Int] -> [Int] -> Bool que verifica se as 2 listas possuem o mesmo primeiro elemento. 
hasEqHeads::[Int]->[Int]->Bool
hasEqHeads [] []=False
hasEqHeads l1 l2= if head(l1)==head(l2) then True else False

--Escreva uma função recursiva add10, que adicione a constante 10 a cada elemento de uma lista, produzindo outra lista. 
add10 :: [Int] -> [Int]
add10 [] = []
add10 ns = (head(ns)+10):add10(tail(ns))

--Escreva uma função recursiva addComma, que adicione uma vírgula no final de cada string contida numa lista. 
addComma :: [String] -> [String]
addComma []=[]
addComma l=((head l)++","):addComma(tail l)

--Refaça os 2 exercícios anteriores usando a função de alta ordem 'map'.
mapAdd10 :: [Int] -> [Int]
mapAdd10 []=[]
mapAdd10 l=map(+10)l

mapAddComma :: [String]->[String]
mapAddComma l=map(++",")l

--Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML.
aux::String->String
aux s="<LI>"++s++"</LI>"

htmlListItems :: [String] -> [String]
htmlListItems l=map(aux)l

--Crie uma função recursiva charFound :: Char -> String -> Bool, que verifique se o caracter (primeiro argumento) está contido na string (segundo argumento).
charFound :: Char -> String -> Bool
charFound x l
	|l==[]=False
	|x==(head l)=True
	|x/=(head l)=charFound x (tail l)

--Reescreva a função anterior sem recursão, usando outras funções pré-definidas já vistas em aula. 
filterCharFound :: Char -> String -> Bool
filterCharFound x l
	|filter(==x) l/=[]=True
	|filter(==x) l==[]=False

--Use a função de alta ordem 'zipWith' para produzir uma função que obtenha as diferenças, par a par, dos elementos de duas listas.
difZip::[Int]->[Int]->[Int]
difZip l1 l2=zipWith(-) l1 l2

--Dada uma lista de números, calcular 2*n+1 para cada número n contido na lista. 
doublePlusOne::[Int]->[Int]
doublePlusOne l=map(+1)(map(2*)l)

--Dadas duas listas X e Y de números inteiros, calcular 4*x+2*y+1 para cada par de números x e y pertencentes às listas.
calcPares::[Int]->[Int]->[Int]
calcPares l1 l2=zipWith(\l1 l2 -> 4*l1+2*l2+1) l1 l2

--Dada uma lista de strings, produzir outra lista com strings de 10 caracteres, usando o seguinte esquema: strings de entrada com mais 
--de 10 caracteres são truncadas, strings com até 10 caracteres são completadas com '.' até ficarem com 10 caracteres.
--strings10 :: [String] -> [String]
--strings10 l
--	|head l>10=take 10 (head l)
--	|head l<10=head l++"."
--	|otherwise=strings10 (tail l)


--Dada uma lista de idades, selecionar as que são maiores que 20 e, para cada uma, calcular o ano de nascimento correspondente.
calcIdade::[Int]->[Int]
calcIdade l=map(2015-)(filter (>20)l)
