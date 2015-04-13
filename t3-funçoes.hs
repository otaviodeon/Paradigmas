import Data.Char

--Escreva uma função recursiva firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome. 
--Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome. 

firstName :: String -> String
firstName (x:xs)=if x/=' ' then x:firstName xs else []

--Escreva uma função firstName' :: String -> String com o mesmo resultado do exercício anterior, mas sem usar recursão. 
firstName'::String -> String
firstName' str=takeWhile(/=' ')str

--Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. 
--Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
lastName::String->String
lastName str=reverse(takeWhile(/=' ')(reverse(str)))

--Escreva uma função não-recursiva userName :: String -> String que, dado o nome completo de uma pessoa, 
--crie um nome de usuário (login) da pessoa, formado por: primeira letra do nome seguida do sobrenome, tudo em minúsculas. 
userName:: String->String
userName str=map toLower (head str:last (words str))


--Escreva uma função não-recursiva encodeName :: String -> String que substitua vogais em uma string, 
--conforme o esquema a seguir: a = 4, e = 3, i = 1, o = 0, u = 00. 
encodeName::String->String
encodeName str= 
	let func x
		|x=='a'="4"
		|x=='e'="3"
		|x=='i'="1"
		|x=='o'="0"
		|x=='u'="00"
		|otherwise=[x]
	in concat(map(func)str)

--Escreva uma função isElem :: Int -> [Int] -> Bool que verifique se um dado elemento pertence a uma lista
isElem ::Int->[Int]->Bool
isElem x str=any (x==)str

--Escreva uma função recursiva que retorne o número de vogais em uma string. 
nVogais :: String->Int
nVogais []=0
nVogais (x:xs)
	|x=='a'=1+nVogais xs
	|x=='e'=1+nVogais xs
	|x=='i'=1+nVogais xs
	|x=='o'=1+nVogais xs
	|x=='u'=1+nVogais xs
	|x=='A'=1+nVogais xs
	|x=='E'=1+nVogais xs
	|x=='I'=1+nVogais xs
	|x=='O'=1+nVogais xs
	|x=='U'=1+nVogais xs
	|otherwise=0+nVogais xs

--Escreva uma função não-recursiva que retorne o número de consoantes em uma string. 
nConsoantes :: String -> Int
nConsoantes x = length [y|y<-x, y/='a', y/='e', y/='i', y/='o', y/='u', y/='A', y/='E', y/='I', y/='O', y/='U']

--Escreva uma função não-recursiva isInt :: String -> Bool que verifique se uma dada string só contém dígitos (0 a 9). 
isInt :: String -> Bool
isInt x = if any (>'9')x then False else True


--Escreva uma função não-recursiva strToInt :: String -> Int que converta uma string em um número inteiro, fazendo operações 
--aritméticas com seus dígitos (p.ex.: "356" = 3*100 + 5*10 + 6*1 = 356). Considere que a string seja um número válido, 
--isto é, só contenha dígitos de 0 a 9. 
strToInt :: String -> Int
strToInt str = sum(zipWith(*) (reverse(map digitToInt str)) (zipWith(\x y -> x^y)(replicate (length(str)) 10)[0..]))

--As funções de alta ordem any e all são pré-definidas na biblioteca Prelude do Haskell (veja seção Special Folds). 
--Estude e teste essas funções e apresente 2 exemplos de uso de cada uma delas. 
--Ex1: any (0==) [100..0]	retorna True
--Ex2: any odd [0,2..100]	retorna False
--Ref:http://zvon.org/other/haskell/Outputprelude/any_f.html
--Ex1: all (>10) [10,20..]	retorna True
--Ex2: all odd [1,3..]		retorna True
--Ref:http://zvon.org/other/haskell/Outputprelude/all_f.html

--Em Haskell, o símbolo '$' pode ser usado para escrever códigos ainda mais curtos. 
--Descubra seu significado e apresente 2 exemplos de uso. 
--Ex1: takeWhile(/=' ')$reverse$string
--Ex2: reverse $map $digitToInt str
